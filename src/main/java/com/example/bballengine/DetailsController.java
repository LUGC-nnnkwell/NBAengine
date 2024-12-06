package com.example.bballengine;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailsController {
    @FXML
    private Label Label_resultage;

    @FXML
    private Label Label_resultcountry;

    @FXML
    private Label Label_resultname;

    @FXML
    private Label Label_resultnumber;

    @FXML
    private Label Label_resultposition;

    @FXML
    private Label playerName;

    @FXML
    private Label playerNumber;

    @FXML
    private Label playerPosition;

    @FXML
    private Label playerage;

    @FXML
    private Label playercountry;

    @FXML
    public void back() {
        // Go back to the main scene
        Main.stage.setScene(Main.scene1);
        Main.stage.show();
    }
    public void setPlayer(Player player) {
        // Set the player's details
        if (player != null) {
            // Update UI components with the player's details, check for null or empty values
            Label_resultname.setText(player.getName() != null && !player.getName().isEmpty() ? player.getName() : "NULL");
            Label_resultnumber.setText(player.getNumber() != null && !player.getNumber().isEmpty() ? player.getNumber() : "NULL");
            Label_resultposition.setText(player.getPosition() != null && !player.getPosition().isEmpty() ? player.getPosition() : "NULL");
            Label_resultage.setText(player.getAge() != 0 ? String.valueOf(player.getAge()) : "NULL");
            Label_resultcountry.setText(player.getCountry() != null && !player.getCountry().isEmpty() ? player.getCountry() : "NULL");
        } else {
            // If the player object is null, display "NULL"
            Label_resultname.setText("NULL");
            Label_resultnumber.setText("NULL");
            Label_resultposition.setText("NULL");
            Label_resultage.setText("NULL");
            Label_resultcountry.setText("NULL");
        }

    }
    public void initialize() {
        System.out.println("DetailsController initialized successfully!");
    }
}
