package com.underhill.hyperskill;

public class CaesarCipherAlgorithm extends Algorithm {


    public CaesarCipherAlgorithm(String msg, int key, String operation) {
        super(msg, key, operation);
    }

    @Override
        public String encrypt() {
            if (key == 0) {
                return msg;
            }
            StringBuilder result = new StringBuilder();
            for (char character : msg.toCharArray()) {
                if (character != ' ') {
                    int originalAlphabetPosition = character - 'a';
                    int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                    char newCharacter = (char) ('a' + newAlphabetPosition);
                    result.append(newCharacter);
                } else {
                    result.append(character);
                }
            }
            return result.toString();
        }

        @Override
        public String decrypt() {
            StringBuilder result = new StringBuilder();
            for (char character : msg.toCharArray()) {
                if (character != ' ') {
                    int originalAlphabetPosition = character - 'a';
                    int newAlphabetPosition = (originalAlphabetPosition + (26 - (key % 26))) % 26;
                    char newCharacter = (char) ('a' + newAlphabetPosition);
                    result.append(newCharacter);
                } else {
                    result.append(character);
                }
            }
            return result.toString();
        }
}
