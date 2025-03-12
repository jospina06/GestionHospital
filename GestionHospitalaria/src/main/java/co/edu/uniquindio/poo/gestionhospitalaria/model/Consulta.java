package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.time.LocalDate;

public class Consulta {
    private LocalDate fecha;
    private String diagnostico;
    private Medicamento medicamento;
    private Paciente paciente;
    private Doctor doctor;

    public Consulta(LocalDate fecha, String diagnostico, Medicamento medicamento,
                    Paciente paciente, Doctor doctor) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.medicamento = medicamento;
        this.paciente = paciente;
        this.doctor = doctor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
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

    @Override
    public String toString() {
        return "Consulta{ fecha= " + fecha + " \npaciente= " + paciente +
                "doctor= " + doctor + " diagnostico= " + diagnostico +
                ", medicamento= " + medicamento + '}';
    }
}
