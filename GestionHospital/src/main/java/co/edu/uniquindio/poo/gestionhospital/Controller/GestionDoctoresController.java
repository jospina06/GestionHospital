package co.edu.uniquindio.poo.gestionhospital.Controller;

import co.edu.uniquindio.poo.gestionhospital.model.*;


import java.util.Collection;

public class GestionDoctoresController {

    Hospital hospital;

    public GestionDoctoresController(Hospital hospital) {
        this.hospital = hospital;
    }



    public void agregarDoctor(Doctor doctor){
        hospital.agregarDoctor(doctor);
    }

    public void eliminarDoctor(String id){
        hospital.eliminarDoctor(id);
    }

    public void actualizarDoctor(String id, String nuevoNombre, int nuevaEdad, String nuevaArea){
        hospital.actualizarDoctor(id, nuevoNombre, nuevaEdad, nuevaArea);
    }

    public Collection<Doctor> obtenerDoctores(){
        return hospital.getDoctores();
    }


}
