module com.example.demotextfield1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demotextfield1 to javafx.fxml;
    exports com.example.demotextfield1;
}