package gui;

import dal.DataAccess;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
   private Main mainApp;


    public static void main(String[] args) {
        launch(args);

    }
     List<String> ListViewList = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        MainController mainController = loader.getController();
        mainController.setMainApp(this);
        primaryStage.show();

        populateListView(primaryStage);
    }

    private void populateListView(Stage primaryStage) {
        DataAccess dataAccess = new DataAccess();
        ListView<String> listAllWords = (ListView<String>) primaryStage.getScene().lookup("#listAllWords");
        if (listAllWords != null) {
            listAllWords.setItems(dataAccess.getWordsFromTextFile());
        }
        ListViewList.addAll(listAllWords.getItems());
    }



    public List<String> getListViewList()
    {
                    return ListViewList;
    }
}
