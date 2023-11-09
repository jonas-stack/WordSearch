package dal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataAccess {

    public ObservableList<String> getWordsFromTextFile() {
        ObservableList<String> words = FXCollections.observableArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Codeing\\Coding School\\WordSearch\\resources/WordsFromMoodle.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}