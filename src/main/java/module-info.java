module ro.tu.pt2022_30423_chete_doru_assignment_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ro.tu.pt2022_30423_chete_doru_assignment_1 to javafx.fxml;
    exports ro.tu.pt2022_30423_chete_doru_assignment_1;
    exports ro.tu.pt2022_30423_chete_doru_assignment_1.controller;
    opens ro.tu.pt2022_30423_chete_doru_assignment_1.controller to javafx.fxml;
    //exports ro.tu.pt2022_30423_chete_doru_assignment_1.view;
    opens ro.tu.pt2022_30423_chete_doru_assignment_1.view to javafx.fxml;
}