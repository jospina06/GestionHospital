package co.edu.uniquindio.poo.gestionhospital.model;

import java.util.LinkedList;

public class GestorConfig {
    
    private static GestorConfig instancia;
    private String horarioAtencion;
    private int maxPacientesXdoctor;
    private LinkedList<String> reglasFacturacion;


    private GestorConfig(){
        this.horarioAtencion = "7:00 AM - 6:00 PM";
        this.maxPacientesXdoctor = 7;
        this.reglasFacturacion = new LinkedList<>();

        this.reglasFacturacion.add("Se aceptan todos los medios de pago");
    }


    public static GestorConfig getInstance(){
        if(instancia == null){
            instancia = new GestorConfig();
        }
        return instancia;
    }


    public String getHorarioAtencion() {
        return horarioAtencion;
    }
    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public int getMaxPacientesXdoctor() {
        return maxPacientesXdoctor;
    }
    public void setMaxPacientesXdoctor(int maxPacientesXdoctor) {
        this.maxPacientesXdoctor = maxPacientesXdoctor;
    }

    public LinkedList<String> getReglasFacturacion() {
        return reglasFacturacion;
    }
    public void setReglasFacturacion(LinkedList<String> reglasFacturacion) {
        this.reglasFacturacion = reglasFacturacion;
    }


    @Override
    public String toString() {
        return "GestorConfig{" +
                "Horario de atencion ='" + horarioAtencion + '\'' +
                ", Numero maximo de pacientes por medico =" + maxPacientesXdoctor +
                ", Reglas de facturacion =" + reglasFacturacion +
                '}';
    }
}
