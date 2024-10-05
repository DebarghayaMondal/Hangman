package com.example.hangman;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class HangmanHandler extends TextWebSocketHandler {

    private String wordToGuess = "example";  // Word to guess
    private String currentWordState = "_ _ _ _ _ _ _";  // Starting state of the word

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(payload);
        String guessedLetter = node.get("letter").asText();

        currentWordState = updateWordState(guessedLetter);
        String responseMessage = (wordToGuess.equals(currentWordState)) ? "You've won!" : "Keep guessing!";

        Map<String, String> response = new HashMap<>();
        response.put("wordState", currentWordState);
        response.put("message", responseMessage);

        session.sendMessage(new TextMessage(mapper.writeValueAsString(response)));
    }

    private String updateWordState(String guessedLetter) {
        StringBuilder updatedWordState = new StringBuilder(currentWordState);
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guessedLetter.charAt(0)) {
                updatedWordState.setCharAt(i * 2, guessedLetter.charAt(0));  // Account for spaces between letters
            }
        }
        return updatedWordState.toString();
    }
}
