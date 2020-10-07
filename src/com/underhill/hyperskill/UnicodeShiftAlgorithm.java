package com.underhill.hyperskill;

public class UnicodeShiftAlgorithm extends Algorithm {

    public UnicodeShiftAlgorithm(String msg, int key, String operation) {
        super(msg, key, operation);
    }

    @Override
    public String encrypt() {
        if (key == 0) {
            return msg;
        }
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            int index = msg.charAt(i);
            encryptedMessage.append((char) (index + key));
        }
        return encryptedMessage.toString();
    }

    @Override
    public String decrypt() {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            int index = msg.charAt(i);
            encryptedMessage.append((char) (index - key));
        }
        return encryptedMessage.toString();
    }
}
