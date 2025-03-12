package co.edu.uniquindio.poo.gestionhospital.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class Consulta {

    private LocalDate fecha;
    private Paciente paciente;
    private Doctor doctor;
    private Collection<String> enfermedades;
    private Collection<String> medicamentos;

    /**
     * Constructor de la clase
     * @param fecha
     * @param paciente
     * @param doctor
     */
    public Consulta(LocalDate fecha, Paciente paciente, Doctor doctor) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.doctor = doctor;
        this.enfermedades = new LinkedList<>();
        this.medicamentos = new LinkedList<>();
    }

    /**
     * Método para clonar una consulta
     * @return consultaCLon
     */
    public Consulta clonarConsulta() {
        Consulta consultaClon = new Consulta(this.fecha, this.paciente, this.doctor);
        consultaClon.enfermedades = new LinkedList<>(this.enfermedades);
        consultaClon.medicamentos = new LinkedList<>(this.medicamentos);
        return consultaClon;
    }

    /**
     * Método para agregar una enfermedad a la consulta
     * @param enfermedad
     */
    public void agregarEnfermedad(String enfermedad) {
        enfermedades.add(enfermedad);
    }

    /**
     * Método para agregar un medicamento a la consulta
     * @param medicamento
     */
    public void agregarMedicamento(String medicamento) {
        medicamentos.add(medicamento);
    }


    //----------- Gets y Sets de la clase consulta-------------------//
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Collection<String> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(Collection<String> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public Collection<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Collection<String> medicamentos) {
        this.medicamentos = medicamentos;
    }


    @Override
    public String toString() {
        return "Consulta [" + fecha + "] con Dr. " + doctor.getNombre() + "\n" +
                "    Enfermedades: " + (enfermedades.isEmpty() ? "Ninguna" : enfermedades) + "\n" +
                "    Medicamentos: " + (medicamentos.isEmpty() ? "Ninguno" : medicamentos);
    }


}
