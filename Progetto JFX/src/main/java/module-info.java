module com.example.provajfx {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;


    opens com.example.provajfx to javafx.fxml;
    exports com.example.provajfx;
}