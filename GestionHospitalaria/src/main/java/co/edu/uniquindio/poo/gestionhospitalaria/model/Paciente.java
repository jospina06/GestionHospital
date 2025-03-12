package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Paciente extends Persona implements ClaseClonable {
    private LinkedList<Cita> citas;
    private Historial historial;

    public Paciente(String nombre, String id, int edad) {
        super(nombre, id, edad);
        this.citas = new LinkedList<>();
        this.historial = historial;
    }

    public LinkedList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(LinkedList<Cita> citas) {
        this.citas = citas;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    @Override
    public String toString() {
        return "Paciente{ " + super.toString() + ", citas= " + citas
                + ", historial= " + historial + '}';
    }

    //metodo para clonar un Paciente y su historial
    @Override
    public Paciente clone() {
        try {
           Paciente clonado = (Paciente) super.clone();

            clonado.historial = this.historial.clone();
            
            return clonado;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("El paciente no puede ser Cloneable");
        }
    }

    //agregar una cita a la lista
    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    //eliminar una cita de la lista
    public void eliminarCita(Cita cita) {
        citas.remove(cita);
    }

    //metodo para verificar si el nombre es palíndromo
    public boolean esPalindromo(){
        String nombreRevertido = new StringBuilder(getNombre()).reverse().toString();
        return getNombre().equalsIgnoreCase(nombreRevertido);
    }

    //metodo que determina si  el paciente tiene dos vocales iguales en su nombre
    public boolean vocalesIguales(){
        String nombreMinusculas = getNombre().toLowerCase();
        int[] contadorVocales = new int [5];

        for (char c : nombreMinusculas.toCharArray()) {
            switch (c) {
                case 'a': contadorVocales[0]++; break;
                case 'e': contadorVocales[1]++; break;
                case 'i': contadorVocales[2]++; break;
                case 'o': contadorVocales[3]++; break;
                case 'u': contadorVocales[4]++; break;
            }
        }

        for (int i : contadorVocales) {
            if (i >= 2){
                return true;
            }
        }
        return false;
    }
}
