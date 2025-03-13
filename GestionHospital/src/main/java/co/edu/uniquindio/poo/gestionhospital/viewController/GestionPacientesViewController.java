package co.edu.uniquindio.poo.gestionhospital.viewController;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;


import co.edu.uniquindio.poo.gestionhospital.app.App;
import co.edu.uniquindio.poo.gestionhospital.model.*;
import co.edu.uniquindio.poo.gestionhospital.Controller.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class GestionPacientesViewController {

    GestionPacientesController gestionPacientesController;

    private Hospital hospital;


    @FXML private TableView<Paciente> tablaPacientes;
    @FXML private TextField txtNombre;
    @FXML private TextField txtEdad;

    @FXML private TableColumn<Paciente, String> colId;
    @FXML private TableColumn<Paciente, String> colNombre;
    @FXML private TableColumn<Paciente, Integer> colEdad;
    @FXML private TableColumn<Paciente, Historial> colHistorial;

    @FXML
    private void agregarPaciente(ActionEvent event) {
        // Lógica para agregar paciente
    }

    @FXML
    private void eliminarPaciente(ActionEvent event) {
        // Lógica para eliminar paciente
    }

    @FXML
    private void actualizarPaciente(ActionEvent event) {
        // Lógica para actualizar paciente
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
        cargarPacientes(); // Llenar la tabla cuando se asigne el hospital
    }

    private void cargarPacientes() {
        if (hospital != null) {
            ObservableList<Paciente> pacientes = FXCollections.observableArrayList(hospital.getPacientes());
            tablaPacientes.setItems(pacientes);
        }
    }



    @FXML
    public void initialize() {
        colId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colEdad.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());
        colHistorial.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getHistorial()));

        tablaPacientes.setItems(FXCollections.observableArrayList());
        gestionPacientesController = new GestionPacientesController(App.hospital);
    }

    @FXML
    private void onMostrarNombresPalindromos(ActionEvent event) {
        mostrarNombresPalindromos();
    }

    public void mostrarNombresPalindromos(){
        gestionPacientesController.mostrarNombresPalindromos();
    }

    @FXML
    private void onMostrarNombresVocales(ActionEvent event) {
        mostrarNombresVocales();
    }

    public void mostrarNombresVocales(){
        gestionPacientesController.mostrarNombresVocales();
    }




    @FXML
    private void volverAlMenu(ActionEvent event) {
        App.cargarVista("/menu.fxml");
    }




}
