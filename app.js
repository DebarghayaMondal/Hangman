const playerId = "player1"; // Unique identifier for the player

document.getElementById('startGame').addEventListener('click', async () => {
    const wordToGuess = document.getElementById('wordInput').value;
    if (!wordToGuess) {
        alert("Please enter a word to guess!");
        return;
    }
    
    const response = await fetch(`http://localhost:8080/hangman/start?playerId=${playerId}&word=${wordToGuess}`, {
        method: 'GET'
    });
    const result = await response.text();
    document.getElementById('gameState').innerText = result;
});

document.getElementById('makeGuess').addEventListener('click', async () => {
    const letter = document.getElementById('guessInput').value;
    const response = await fetch(`http://localhost:8080/hangman/guess?playerId=${playerId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'text/plain'
        },
        body: letter
    });
    const result = await response.text();
    document.getElementById('result').innerText = result;
    document.getElementById('guessInput').value = ''; // Clear input
});

