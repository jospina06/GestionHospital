package co.edu.uniquindio.poo.gestionhospital.viewController;


import co.edu.uniquindio.poo.gestionhospital.Controller.GestionCitasController;
import co.edu.uniquindio.poo.gestionhospital.Controller.GestionDoctoresController;
import co.edu.uniquindio.poo.gestionhospital.app.App;
import co.edu.uniquindio.poo.gestionhospital.model.*;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GestionCitasViewController {

    private Hospital hospital;

    @FXML private TableView<Cita> tablaCitas;
    @FXML private TableColumn<Cita, Integer> colId;
    @FXML private TableColumn<Cita, String> colFecha;
    @FXML private TableColumn<Cita, String> colPaciente;
    @FXML private TableColumn<Cita, String> colDoctor;


    GestionCitasController gestionCitasController;



    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtPaciente;

    @FXML
    private TextField txtDoctor;


    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
        cargarCitas(); // Llenar la tabla cuando se asigne el hospital
    }



    private void cargarCitas() {
        if (hospital != null) {
            ObservableList<Cita> citas = FXCollections.observableArrayList(hospital.getCitas());
            tablaCitas.setItems(citas);
        }
    }


    @FXML
    public void initialize() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        colId.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getId()).asObject());

        colFecha.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getFecha().format(formatter)));

        colPaciente.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getPaciente().getNombre()));

        colDoctor.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDoctor().getNombre()));

        tablaCitas.setItems(FXCollections.observableArrayList());

        gestionCitasController = new GestionCitasController(App.hospital);
    }





    public void agregarCita(ActionEvent event) {
        System.out.println("Cita agregada con fecha: " + txtFecha.getText());
        // Aquí llamas al método de tu hospital para agregar la cita
    }

    public void eliminarCita(ActionEvent event) {
        System.out.println("Cita eliminada");
        // Aquí llamas al método para eliminar la cita
    }

    public void volverAlMenu(ActionEvent event) {
        App.cargarVista("/menu.fxml");
    }
}
