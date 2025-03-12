package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.time.LocalDate;

public class Cita {
    private LocalDate fecha;
    private Paciente paciente;

    public Cita(LocalDate fecha, Paciente paciente) {
        this.fecha = fecha;
        this.paciente = paciente;
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

    @Override
    public String toString() {
        return "{ paciente= " + paciente + " fecha= " + fecha + '}';
    }
}
