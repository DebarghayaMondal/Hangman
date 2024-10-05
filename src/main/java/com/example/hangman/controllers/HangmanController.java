package com.example.hangman.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hangman")
@CrossOrigin(origins={"http://127.0.0.1:5500","http://localhost:3000"})
public class HangmanController {

    private Map<String, String> gameState = new HashMap<>();
    private Map<String, String> currentWord = new HashMap<>();
    private Map<String, Integer> attempts = new HashMap<>();

    @GetMapping("/start")
    public String startGame(@RequestParam String playerId, @RequestParam String word) {
        gameState.put(playerId, "_".repeat(word.length())); // Initialize game state with the word length
        currentWord.put(playerId, word);
        attempts.put(playerId, 6); // Number of attempts
        return "Game started! Current state: " + gameState.get(playerId);
    }

    @PostMapping("/guess")
    public String makeGuess(@RequestParam String playerId, @RequestBody String letter) {
        String word = currentWord.get(playerId);
        StringBuilder currentState = new StringBuilder(gameState.get(playerId));
        int remainingAttempts = attempts.get(playerId);
        
        // Check if the letter is in the word
        if (word.contains(letter)) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter.charAt(0)) {
                    currentState.setCharAt(i, letter.charAt(0));
                }
            }
            gameState.put(playerId, currentState.toString());
        } else {
            remainingAttempts--;
            attempts.put(playerId, remainingAttempts);
        }

        if (remainingAttempts <= 0) {
            return "Game Over! The word was: " + word;
        }
        if (!currentState.toString().contains("_")) {
            return "Congratulations! You've guessed the word: " + word;
        }
        
        return "Current state: " + currentState + ", Remaining attempts: " + remainingAttempts;
    }
}
