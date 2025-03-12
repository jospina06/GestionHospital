package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.util.LinkedList;

public class Doctor extends Persona {
    private LinkedList<Consulta> consultas;

    public Doctor(String nombre, String id, int edad) {
        super(nombre, id, edad);
        this.consultas = new LinkedList<>();
    }

    public LinkedList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(LinkedList<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "Doctor{ " + super.toString() + ", consultas= " + consultas + " }";
    }
}
