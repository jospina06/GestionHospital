package co.edu.uniquindio.poo.gestionhospital.Controller;

import co.edu.uniquindio.poo.gestionhospital.model.*;

import java.util.Collection;
import java.util.List;

public class GestionPacientesController {

    private Hospital hospital;

    public GestionPacientesController(Hospital hospital) {
        this.hospital = hospital;
    }

    public void mostrarNombresPalindromos(){
        hospital.imprimirPalindromos();
    }

    public void mostrarNombresVocales(){
        hospital.imprimirVocalesIguales();
    }

    public void agregarPaciente(Paciente paciente){
        hospital.agregarPaciente(paciente);
    }

    public void eliminarPaciente(String id){
        hospital.eliminarPaciente(id);
    }

    public void actualizarPaciente(String id, String nuevoNombre, int nuevaEdad){
        hospital.actualizarPaciente(id, nuevoNombre, nuevaEdad);
    }

    public Collection<Paciente> obtenerPacientes(){
        return hospital.getPacientes();
    }
}
