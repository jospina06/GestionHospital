module co.edu.uniquindio.poo.gestionhospital {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.poo.gestionhospital to javafx.fxml;
    exports co.edu.uniquindio.poo.gestionhospital.model;
    exports co.edu.uniquindio.poo.gestionhospital.viewController;
    exports co.edu.uniquindio.poo.gestionhospital.controller;
    exports co.edu.uniquindio.poo.gestionhospital.app;
    opens co.edu.uniquindio.poo.gestionhospital.app to javafx.fxml;
}