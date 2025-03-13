package co.edu.uniquindio.poo.gestionhospital.viewController;

import co.edu.uniquindio.poo.gestionhospital.Controller.GestionDoctoresController;
import co.edu.uniquindio.poo.gestionhospital.Controller.GestionPacientesController;
import co.edu.uniquindio.poo.gestionhospital.app.App;
import co.edu.uniquindio.poo.gestionhospital.model.Hospital;
import co.edu.uniquindio.poo.gestionhospital.model.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionDoctoresViewController {

    GestionDoctoresController gestionDoctoresController;
    private Hospital hospital;


    @FXML private TableView<Doctor> tablaDoctores;
    @FXML private TableColumn<Doctor, String> colId;
    @FXML private TableColumn<Doctor, String> colNombre;
    @FXML private TableColumn<Doctor, Integer> colEdad;
    @FXML private TableColumn<Doctor, String> colEspecialidad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtArea;


    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
        cargarDoctores(); // Llenar la tabla cuando se asigne el hospital
    }

    private void cargarDoctores() {
        if (hospital != null) {
            ObservableList<Doctor> doctores = FXCollections.observableArrayList(hospital.getDoctores());
            tablaDoctores.setItems(doctores);
        }
    }


    @FXML
    public void initialize() {
        colId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colEdad.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());
        colEspecialidad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArea()));

        tablaDoctores.setItems(FXCollections.observableArrayList());

        gestionDoctoresController = new GestionDoctoresController(App.hospital);
    }



    public void agregarDoctor(ActionEvent event) {
        System.out.println("Doctor agregado: " + txtNombre.getText());
        // Llamar al método del hospital para agregar un doctor
    }

    public void eliminarDoctor(ActionEvent event) {
        System.out.println("Doctor eliminado");
        // Llamar al método para eliminar un doctor
    }

    public void actualizarDoctor(ActionEvent event) {
        System.out.println("Doctor actualizado");
        // Llamar al método para actualizar un doctor
    }

    public void volverAlMenu(ActionEvent event) {
        App.cargarVista("/menu.fxml");
    }
}
