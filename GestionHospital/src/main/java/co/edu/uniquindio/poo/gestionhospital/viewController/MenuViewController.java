package co.edu.uniquindio.poo.gestionhospital.viewController;
import co.edu.uniquindio.poo.gestionhospital.app.App;
import javafx.event.ActionEvent;

public class MenuViewController {

    public void irAGestionPacientes(ActionEvent event) {
        App.cargarVista("/GestionPacientes.fxml");
    }

    public void irAGestionDoctores(ActionEvent event) {
        App.cargarVista("/GestionDoctores.fxml");
    }

    public void irAGestionCitas(ActionEvent event) {
        App.cargarVista("/GestionCitas.fxml");
    }

    public void salir(ActionEvent event) {
        System.exit(0);
    }
}
