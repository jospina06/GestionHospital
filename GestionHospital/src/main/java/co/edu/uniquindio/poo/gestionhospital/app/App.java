package co.edu.uniquindio.poo.gestionhospital.app;

import co.edu.uniquindio.poo.gestionhospital.model.*;

import co.edu.uniquindio.poo.gestionhospital.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

public class App extends Application {

    public static Hospital hospital = new Hospital("Cosmitet");

    static {
        // Agregando datos de prueba
        Paciente paciente1 = new Paciente("Juan Pérez", "123", 50);
        Paciente paciente2 = new Paciente("Ana Gómez", "456", 35);

        Doctor doctor1 = new Doctor("Carlos Rodríguez", "789", 60, "Cardiología");
        Doctor doctor2 = new Doctor("Maria Rodriguez", "101", 40,"Pediatría");

        hospital.agregarPaciente(paciente1);
        hospital.agregarPaciente(paciente2);
        hospital.agregarDoctor(doctor1);
        hospital.agregarDoctor(doctor2);

        hospital.agendarCita(LocalDate.now(), "123", "789");
        hospital.agendarCita(LocalDate.of(2026, 10, 5), "456", "101");
        hospital.agendarCita(LocalDate.of(1970, 5, 20), "123", "101");

    }

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        cargarVista("/menu.fxml");
        stage.setTitle("Gestión Hospitalaria");
        stage.show();
    }

    public static void cargarVista(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

            // Obtener el controlador de la vista cargada
            Object viewController = loader.getController();

            // Pasar la instancia del hospital según el tipo de controlador
            if (viewController instanceof GestionPacientesViewController) {
                ((GestionPacientesViewController) viewController).setHospital(hospital);
            } else if (viewController instanceof GestionDoctoresViewController) {
                ((GestionDoctoresViewController) viewController).setHospital(hospital);
            } else if (viewController instanceof GestionCitasViewController) {
                ((GestionCitasViewController) viewController).setHospital(hospital);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
