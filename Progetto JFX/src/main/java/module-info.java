module com.example.provajfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.provajfx to javafx.fxml;
    exports com.example.provajfx;
}