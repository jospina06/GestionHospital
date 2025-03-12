package co.edu.uniquindio.poo.gestionhospital.model;

import java.util.LinkedList;

public class Doctor extends Persona{

    private String area;
    private LinkedList<Cita> citas;



    public Doctor(String nombre, String id, int edad, String area) {
        super(nombre, id, edad);
        this.area = area;
        this.citas = new LinkedList<>();
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    public LinkedList<Cita> getCitas() {
        return citas;
    }
    public void setCitas(LinkedList<Cita> citas) {
        this.citas = citas;
    }
}
