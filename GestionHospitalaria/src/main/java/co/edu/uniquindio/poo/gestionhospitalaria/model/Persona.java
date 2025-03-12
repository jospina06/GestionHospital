package co.edu.uniquindio.poo.gestionhospitalaria.model;

public class Persona {
    private String nombre;
    private String id;
    private int edad;

    public Persona(String nombre, String id, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "nombre= " + nombre + ", id= " + id + ", edad= " + edad;
    }
}
