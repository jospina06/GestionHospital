package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.util.LinkedList;

public class Historial {
    private LinkedList<Consulta> consultas;

    public Historial(LinkedList<Consulta> consultas) {
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
        return "Historial{ consultas= " + consultas + '}';
    }
}
