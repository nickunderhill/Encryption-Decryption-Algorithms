package com.underhill.hyperskill;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {
        Algorithm encryptionAlg;
        String message = "";
        //Read console arguments
        Map<String, String> consoleArgs = Utils.parseConsoleArgs(args);

        //Choose encryption algorithm
        String encAlgParam = consoleArgs.getOrDefault("-alg", "shift");

        //Choose mode
        String operation = consoleArgs.getOrDefault("-mode", "enc");

        //Read key
        int key = Integer.parseInt(consoleArgs.getOrDefault("-key", "1"));

        //Choose input (file or console) and read message
        if (consoleArgs.containsKey("-data")) {
            message = consoleArgs.get("-data");
            System.out.println("Console input: " + message);
        } else if (consoleArgs.containsKey("-in")) {
            Path input = Paths.get(consoleArgs.get("-in"));
            message = Files.readString(input);
            System.out.println("File input: " + message);
        } else {
            System.out.println("No input detected. Please specify it directly in the arguments using -data \"Some input\" or indicate filepath like this -in input_file.txt");
            System.exit(2);
        }

        //Write to file if -out specified
        if (!consoleArgs.containsKey("-data") && consoleArgs.containsKey("-out")) {
            PrintStream output = new PrintStream(consoleArgs.get("-out"));
            System.setOut(output);
        }

        //Choose and run algorithm
        encryptionAlg = encAlgParam.equals("unicode") ? new UnicodeShiftAlgorithm(message, key, operation) : new CaesarCipherAlgorithm(message, key, operation);
        System.out.print(encryptionAlg.process());
    }
}


