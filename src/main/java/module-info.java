module se.iths.lab3_joni {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.iths.lab3_joni to javafx.fxml;
    exports se.iths.lab3_joni;
    exports se.iths.lab3_joni.controller;
    opens se.iths.lab3_joni.controller to javafx.fxml;
}