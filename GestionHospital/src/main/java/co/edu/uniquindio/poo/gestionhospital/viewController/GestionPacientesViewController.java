package co.edu.uniquindio.poo.gestionhospital.viewController;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import co.edu.uniquindio.poo.gestionhospital.app.App;
import co.edu.uniquindio.poo.gestionhospital.model.*;
import co.edu.uniquindio.poo.gestionhospital.Controller.*;

public class GestionPacientesViewController {

    private GestionPacientesController gestionPacientesController;
    private Hospital hospital;

    @FXML private TableView<Paciente> tablaPacientes;
    @FXML private TextField txtNombre;
    @FXML private TextField txtEdad;
    @FXML private TextField txtId;

    @FXML private TableColumn<Paciente, String> colId;
    @FXML private TableColumn<Paciente, String> colNombre;
    @FXML private TableColumn<Paciente, Integer> colEdad;
    @FXML private TableColumn<Paciente, Historial> colHistorial;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colEdad.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());
        colHistorial.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getHistorial()));

        tablaPacientes.setItems(FXCollections.observableArrayList());
        gestionPacientesController = new GestionPacientesController(App.hospital);
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
        cargarPacientes();
    }

    private void cargarPacientes() {
        if (hospital != null) {
            ObservableList<Paciente> pacientes = FXCollections.observableArrayList(hospital.getPacientes());
            tablaPacientes.setItems(pacientes);
        }
    }

    @FXML
    private void agregarPaciente(ActionEvent event) {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        int edad;

        try {
            edad = Integer.parseInt(txtEdad.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "La edad debe ser un número válido.");
            return;
        }

        Paciente paciente = new Paciente(nombre, id, edad);
        gestionPacientesController.agregarPaciente(paciente);
        cargarPacientes();
        limpiarCampos();
    }

    @FXML
    private void eliminarPaciente(ActionEvent event) {
        Paciente seleccionado = tablaPacientes.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            gestionPacientesController.eliminarPaciente(seleccionado.getId());
            cargarPacientes();
        } else {
            mostrarAlerta("Advertencia", "Seleccione un paciente para eliminar.");
        }
    }

    @FXML
    private void actualizarPaciente(ActionEvent event) {
        Paciente seleccionado = tablaPacientes.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            String nuevoNombre = txtNombre.getText();
            int nuevaEdad;
            try {
                nuevaEdad = Integer.parseInt(txtEdad.getText());
            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "La edad debe ser un número válido.");
                return;
            }
            gestionPacientesController.actualizarPaciente(seleccionado.getId(), nuevoNombre, nuevaEdad);
            cargarPacientes();
            limpiarCampos();
        } else {
            mostrarAlerta("Advertencia", "Seleccione un paciente para actualizar.");
        }
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtEdad.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void onMostrarNombresPalindromos(ActionEvent event) {
        mostrarNombresPalindromos();
    }

    public void mostrarNombresPalindromos() {
        gestionPacientesController.mostrarNombresPalindromos();
    }

    @FXML
    private void onMostrarNombresVocales(ActionEvent event) {
        mostrarNombresVocales();
    }

    public void mostrarNombresVocales() {
        gestionPacientesController.mostrarNombresVocales();
    }

    @FXML
    private void volverAlMenu(ActionEvent event) {
        App.cargarVista("/menu.fxml");
    }
}
