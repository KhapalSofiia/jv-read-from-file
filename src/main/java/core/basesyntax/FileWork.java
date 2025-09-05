package core.basesyntax;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder answer = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] words = line.split(("\\s+"));
                for(String word : words) {
                    String cleaned = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!cleaned.isEmpty() && cleaned.charAt(0) == 'w') {
                        answer.append(cleaned).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (answer.length() == 0) {
            return new String[0];
        }

        String[] result = answer.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
