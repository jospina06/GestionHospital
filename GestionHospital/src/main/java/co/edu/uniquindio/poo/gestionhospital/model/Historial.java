package co.edu.uniquindio.poo.gestionhospital.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Historial {

    private Collection<Consulta> consultas;

    /**
     * Constructor de la clase Historial
     */
    public Historial() {
        this.consultas = new LinkedList<>();
    }

    /**
     * Método para agregar una consulta a lista de consultas
     * @param consulta
     */
    public void agregarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    /**
     * Método que verifica si la lista de consultas está vacía
     * @return boolean
     */
    public boolean tieneConsultas() {
        return !consultas.isEmpty();
    }

    /**
     * Método que obtiene la ultima consulta registrada
     * @return ultimaConsulta
     */
    public Consulta obtenerUltimaConsulta() {
        if (consultas.isEmpty()) {
            throw new IllegalStateException("No hay consultas registradas.");
        }

        Consulta ultimaConsulta = null;
        for (Consulta consulta : consultas) {
            ultimaConsulta = consulta;
        }

        return ultimaConsulta;
    }


    /**
     * Método para clonar el historial
     * @return historialClon
     */
    public Historial clonarHistorial() {
        Historial historialClon = new Historial();
        for (Consulta consulta : this.consultas) {
            historialClon.agregarConsulta(consulta.clonarConsulta());
        }
        return historialClon;
    }


    //----------------------------- Get y Set de la clase---------------------------------//
    public Collection<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Collection<Consulta> consultas) {
        this.consultas = consultas;
    }



    /**
     * Método toString de la clase Historial
     * @return String Builder toString
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Historial Médico:\n");

        if (consultas.isEmpty()) {
            sb.append("   - No hay consultas registradas.\n");
        } else {
            for (Consulta consulta : consultas) {
                sb.append("   -> ").append(consulta).append("\n");
            }
        }

        return sb.toString();
    }



}
