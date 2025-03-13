package co.edu.uniquindio.poo.gestionhospital.Controller;

import co.edu.uniquindio.poo.gestionhospital.model.*;

public class GestionPacientesController {

    Hospital hospital;

    public GestionPacientesController(Hospital hospital) {
        this.hospital = hospital;
    }

    public void mostrarNombresPalindromos(){
        hospital.imprimirPalindromos();
    }

    public void mostrarNombresVocales(){
        hospital.imprimirVocalesIguales();
    }



}
