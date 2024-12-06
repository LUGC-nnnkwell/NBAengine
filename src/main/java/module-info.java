module com.example.bballengine {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires unirest.java;
    requires com.google.gson;


    opens com.example.bballengine to javafx.fxml;
    exports com.example.bballengine;
}