package co.edu.uniquindio.poo.gestionhospital.model;

import java.time.LocalDate;

public class Cita {

    private static int contadorId = 1;
    private int id;
    private LocalDate fecha;
    private Paciente paciente;
    private Doctor doctor;

    public Cita(LocalDate fecha, Paciente paciente, Doctor doctor) {
        this.id = contadorId++;
        this.fecha = fecha;
        this.paciente = paciente;
        this.doctor = doctor;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Cita ID: " + id + " | Fecha: " + fecha + " | Paciente: " + paciente.getNombre() + " | Doctor: " + doctor.getNombre();
    }

}
