package co.edu.uniquindio.poo.gestionhospital.viewController;

import co.edu.uniquindio.poo.gestionhospital.Controller.GestionDoctoresController;
import co.edu.uniquindio.poo.gestionhospital.app.App;
import co.edu.uniquindio.poo.gestionhospital.model.Doctor;
import co.edu.uniquindio.poo.gestionhospital.model.Hospital;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class GestionDoctoresViewController {

    private GestionDoctoresController gestionDoctoresController;
    private Hospital hospital;

    @FXML private TableView<Doctor> tablaDoctores;
    @FXML private TableColumn<Doctor, String> colId;
    @FXML private TableColumn<Doctor, String> colNombre;
    @FXML private TableColumn<Doctor, Integer> colEdad;
    @FXML private TableColumn<Doctor, String> colEspecialidad;

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtEdad;
    @FXML private TextField txtArea;

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
        gestionDoctoresController = new GestionDoctoresController(hospital);
        cargarDoctores();
    }

    @FXML
    public void initialize() {
        colId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colEdad.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());
        colEspecialidad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArea()));

        tablaDoctores.setItems(FXCollections.observableArrayList());
    }

    private void cargarDoctores() {
        if (hospital != null) {
            ObservableList<Doctor> doctores = FXCollections.observableArrayList(hospital.getDoctores());
            tablaDoctores.setItems(doctores);
        }
    }

    @FXML
    public void agregarDoctor(ActionEvent event) {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String edadTexto = txtEdad.getText();
        String area = txtArea.getText();

        if (id.isEmpty() || nombre.isEmpty() || edadTexto.isEmpty() || area.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios.");
            return;
        }

        try {
            int edad = Integer.parseInt(edadTexto);
            Doctor nuevoDoctor = new Doctor(id, nombre, edad, area);
            gestionDoctoresController.agregarDoctor(nuevoDoctor);
            cargarDoctores();
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "La edad debe ser un número válido.");
        }
    }

    @FXML
    public void eliminarDoctor(ActionEvent event) {
        Doctor doctorSeleccionado = tablaDoctores.getSelectionModel().getSelectedItem();

        if (doctorSeleccionado == null) {
            mostrarAlerta("Error", "Seleccione un doctor para eliminar.");
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION, "¿Está seguro de eliminar este doctor?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> resultado = confirmacion.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.YES) {
            gestionDoctoresController.eliminarDoctor(doctorSeleccionado.getId());
            cargarDoctores();
        }
    }

    @FXML
    public void actualizarDoctor(ActionEvent event) {
        Doctor doctorSeleccionado = tablaDoctores.getSelectionModel().getSelectedItem();

        if (doctorSeleccionado == null) {
            mostrarAlerta("Error", "Seleccione un doctor para actualizar.");
            return;
        }

        String nuevoNombre = txtNombre.getText();
        String nuevaEdadTexto = txtEdad.getText();
        String nuevaArea = txtArea.getText();

        if (nuevoNombre.isEmpty() || nuevaEdadTexto.isEmpty() || nuevaArea.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios para actualizar.");
            return;
        }

        try {
            int nuevaEdad = Integer.parseInt(nuevaEdadTexto);
            gestionDoctoresController.actualizarDoctor(doctorSeleccionado.getId(), nuevoNombre, nuevaEdad, nuevaArea);
            cargarDoctores();
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "La edad debe ser un número válido.");
        }
    }

    @FXML
    public void volverAlMenu(ActionEvent event) {
        App.cargarVista("/menu.fxml");
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtEdad.clear();
        txtArea.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
