module com.example.echoservice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.echoservice to javafx.fxml;
    exports com.example.echoservice;
}