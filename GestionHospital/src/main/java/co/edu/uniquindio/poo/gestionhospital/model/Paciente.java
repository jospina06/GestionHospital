package co.edu.uniquindio.poo.gestionhospital.model;

import java.time.LocalDate;

public class Paciente extends Persona implements Cloneable{

    private Historial historial;

    /**
     * Constructor de la clase paciente
     * @param nombre
     * @param id
     * @param edad
     */
    public Paciente(String nombre, String id, int edad) {
        super(nombre, id, edad);
        this.historial = new Historial();

    }

    /**
     * Método para agregar una consulta al historial del paciente
     * @param fecha
     * @param doctor
     */
    public void agregarConsulta(LocalDate fecha, Doctor doctor) {
        Consulta nuevaConsulta = new Consulta(fecha, this, doctor);
        historial.agregarConsulta(nuevaConsulta);
    }

    /**
     * Método para agregar una enfermedad a la ultima consulta registrada del paciente
     * @param enfermedad
     */
    public void agregarEnfermedadUltimaConsulta(String enfermedad) {
        if (historial.tieneConsultas()) {
            historial.obtenerUltimaConsulta().agregarEnfermedad(enfermedad);
        }
    }

    /**
     * Método para agregar un medicamento a la ultima consulta registrada del paciente
     * @param medicamento
     */
    public void agregarMedicamentoUltimaConsulta(String medicamento) {
        if (historial.tieneConsultas()) {
            historial.obtenerUltimaConsulta().agregarMedicamento(medicamento);
        }
    }

    //-------------------------- Gets y Sets-----------------------------------//
    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    /**
     * Método para clonar a un paciente
     * @return pacienteClon
     */
    @Override
    public Paciente clone() {
        try {
            Paciente pacienteClon = new Paciente(super.getNombre(), super.getId(), super.getEdad());
            pacienteClon.historial = this.historial.clonarHistorial();
            return pacienteClon;
        } catch (Exception e) {
            throw new RuntimeException("Error al clonar el paciente", e);
        }
    }


    @Override
    public String toString() {
        return  "Paciente: " + getNombre() + " (ID: " + getId() + ", Edad: " + getEdad() + ")\n" + historial;
    }
}
