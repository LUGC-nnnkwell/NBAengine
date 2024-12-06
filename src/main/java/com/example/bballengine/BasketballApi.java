package com.example.bballengine;

import com.google.gson.Gson;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;


public class BasketballApi {
    @FXML
    private TextField SearchField;

    @FXML
    private TableColumn<Player, String> nameColumn;

    @FXML
    private TableView<Player> nameTable;

    @FXML
    private Button searchbutton;

    @FXML
    public void initialize() {
        if (nameTable != null) {
            // if user clicks table take to details with info from selected row
            nameTable.setOnMouseClicked(event -> {
                Player selectedName = nameTable.getSelectionModel().getSelectedItem();
                if (selectedName != null) {
//                    System.out.println("Selected Name: " + selectedName);


                    Main.detailsController.setPlayer(selectedName);



                    Main.stage.setScene(Main.scene2);
                    Main.stage.show();
                }
            });

        }
        // Initialize the TableView and connect the column
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Connect the search button to the searchPlayers method
        searchbutton.setOnAction(event -> searchPlayers());
    }

    @FXML
    void kkk(ActionEvent event) {
searchPlayers();
    }
    public void searchPlayers() {
        String query = SearchField.getText();
        if (query == null || query.isEmpty()) {
            new IllegalArgumentException("Input Error - Please enter a valid search query.");
            showAlert("Input Error", "Please enter a player's name to search.");
            return;
        }

        try {
            // Set up the GET request
            HttpResponse<String> response = Unirest.get("https://v1.basketball.api-sports.io/players?search="+query)
                    .header("x-rapidapi-key", "23beeadc3c9e934cd95d1df7543df318") // Replace with your API key
                    .header("x-rapidapi-host", "v1.basketball.api-sports.io")
                    .asString();

            // Print the response body
          System.out.println("Response: " + response.getBody());

            // Parse the JSON response using Gson
            Gson gson = new Gson();
            Response apiResponse = gson.fromJson(response.getBody(), Response.class);
//            outcome.getChildren().clear();
//            // Access player details
//            if (apiResponse.getResults() > 0) {
//                List<Player> players = apiResponse.getResponse();
//                for (Player player : players) {
//                    System.out.println("Player Name: " + player.getName());
//                    System.out.println("Player Position: " + player.getPosition());
//                    System.out.println("Player Age: " + player.getAge());
//                }
//            } else {
//                System.out.println("No players found for the given search.");
//            }

            nameTable.getItems().clear();

            if (apiResponse.getResults() > 0) {

                List<Player> players = apiResponse.getResponse();
                for (Player player : players) {

                    nameTable.getItems().add(player);
                }
            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while fetching data. Please try again.");
        }


    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
