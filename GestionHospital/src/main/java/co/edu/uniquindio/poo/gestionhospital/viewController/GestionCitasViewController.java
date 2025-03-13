package co.edu.uniquindio.poo.gestionhospital.viewController;

import co.edu.uniquindio.poo.gestionhospital.Controller.GestionCitasController;
import co.edu.uniquindio.poo.gestionhospital.app.App;
import co.edu.uniquindio.poo.gestionhospital.model.*;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class GestionCitasViewController {

    private Hospital hospital;

    @FXML private TableView<Cita> tablaCitas;
    @FXML private TableColumn<Cita, Integer> colId;
    @FXML private TableColumn<Cita, String> colFecha;
    @FXML private TableColumn<Cita, String> colPaciente;
    @FXML private TableColumn<Cita, String> colDoctor;

    @FXML private TextField txtFecha;
    @FXML private ComboBox<Paciente> cmbPaciente;
    @FXML private ComboBox<Doctor> cmbDoctor;

    GestionCitasController gestionCitasController;

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
        cargarCitas();
        cargarListas();
    }

    private void cargarCitas() {
        if (hospital != null) {
            ObservableList<Cita> citas = FXCollections.observableArrayList(hospital.getCitas());
            tablaCitas.setItems(citas);
        }
    }

    private void cargarListas() {
        if (hospital != null) {
            cmbPaciente.setItems(FXCollections.observableArrayList(hospital.getPacientes()));
            cmbDoctor.setItems(FXCollections.observableArrayList(hospital.getDoctores()));
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

    public void onAgregarCita(ActionEvent event) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(txtFecha.getText(), formatter);
            Paciente paciente = cmbPaciente.getValue();
            Doctor doctor = cmbDoctor.getValue();

            if (paciente == null || doctor == null) {
                mostrarAlerta("Error", "Debe seleccionar un paciente y un doctor.");
                return;
            }

            gestionCitasController.agendarCita(fecha, paciente.getId(), doctor.getId());
            cargarCitas();
            mostrarAlerta("Éxito", "Cita agendada correctamente.");


            txtFecha.clear();
            cmbPaciente.setValue(null);
            cmbDoctor.setValue(null);

        } catch (DateTimeParseException e) {
            mostrarAlerta("Error", "Formato de fecha incorrecto. Use dd/MM/yyyy.");
        }
    }

    public void onListarCitas() {
        List<Cita> citas = gestionCitasController.listarCitas();
        ObservableList<Cita> citasObservable = FXCollections.observableArrayList(citas);
        tablaCitas.setItems(citasObservable);
    }

    public void onEliminarCita(ActionEvent event) {
        Cita citaSeleccionada = tablaCitas.getSelectionModel().getSelectedItem();
        if (citaSeleccionada != null) {
            gestionCitasController.cancelarCita(citaSeleccionada.getId());
            cargarCitas();
            mostrarAlerta("Éxito", "Cita eliminada correctamente.");
        } else {
            mostrarAlerta("Error", "Debe seleccionar una cita para eliminar.");
        }
    }

    public void volverAlMenu(ActionEvent event) {
        App.cargarVista("/menu.fxml");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}