package dal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataAccess {

    public ObservableList<String> getWordsFromTextFile() {
        ObservableList<String> words = FXCollections.observableArrayList();

        // Define the file path
        Path filePath = Paths.get("C:\\DATAMATIKER\\Coding School\\WordSearch\\resources\\WordsFromMoodle.txt");

        // Use try-with-resources to auto-close the BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            // Read lines and add them to the list
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            // Print the stack trace in case of an exception
            e.printStackTrace();
        }
        // Return the populated list
        return words;
    }
}






