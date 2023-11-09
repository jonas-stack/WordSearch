package gui;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    public TextField txtInput;
    private Main mainApp;
    public Button btnSearch;
    public Button btnReadA;
    public Button btnReadN;
    public Button btnClearHistory;
    public ListView listAllWords;
    public ListView listA;
    public ListView listN;
    public ListView listHistory;
    private List<String> searchHistory = new ArrayList<>();

    public Label lblWordCount;
    public Label lblFoundNotFound;

    public void Search(ActionEvent actionEvent) {
        List<String> searchWords = new ArrayList<>();
        searchWords.addAll(listAllWords.getItems());
        String txtInputString = txtInput.getText();
        boolean found = false;

        for (String word : searchWords) {
            if (txtInputString.equals(word)) {
                listAllWords.getSelectionModel().select(word);
                listAllWords.scrollTo(word);
                SearchWord = word;
                lblFoundNotFound.setText(SearchWord);
                lblWordCount.setText(Integer.toString(CountWords()));
                found = true;

                addToHistory(SearchWord);
                updateHistoryListView();
                break; // Exit the loop when a match is found
            }
        }

        if (!found) {
            lblFoundNotFound.setText("Word not found");
        }
    }

    private void addToHistory(String word) {
        searchHistory.add(word);
    }

    private void updateHistoryListView() {
        listHistory.getItems().setAll(searchHistory);
    }

    private String SearchWord;

    public void ReadA(ActionEvent actionEvent) {
        List<String> filteredAWords = new ArrayList<>();
        for(String word : mainApp.getListViewList())
        {
            if(word.startsWith("a") || word.startsWith("A") && !word.startsWith("aa") || !word.startsWith("Aa"))
            {
                filteredAWords.add(word);
            }
        }
        listA.getItems().setAll(filteredAWords);

    }

    public void setMainApp(Main main)
    {
        this.mainApp = main;
    }
    public void ReadN(ActionEvent actionEvent) {
        List<String> filteredNWords = new ArrayList<>();
        for(String word : mainApp.getListViewList())
        {
            if(word.startsWith("n") || word.startsWith("N"))
            {
                filteredNWords.add(word);
            }
        }
        listN.getItems().setAll(filteredNWords);
    }

    public int CountWords() {
        int wordCount = listAllWords.getItems().size();
        lblWordCount.setText("Word Count: " + wordCount);
        return wordCount;
    }


    public void ClearHistory(ActionEvent actionEvent) {
        searchHistory.clear();
        updateHistoryListView();
    }

}
