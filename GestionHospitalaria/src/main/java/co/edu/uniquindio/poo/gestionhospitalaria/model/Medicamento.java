package co.edu.uniquindio.poo.gestionhospitalaria.model;

public class Medicamento {
    private String nombre;
    private String codigo;
    private String dosis;

    public Medicamento(String nombre, String codigo, String dosis) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.dosis = dosis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    @Override
    public String toString() {
        return "Medicamento{ \nnombre= " + nombre + "\n codigo= " + codigo +
                "\n dosis= " + dosis +'}';
    }
}
