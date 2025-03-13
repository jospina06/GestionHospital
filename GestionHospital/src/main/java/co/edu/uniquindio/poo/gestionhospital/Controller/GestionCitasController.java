package co.edu.uniquindio.poo.gestionhospital.Controller;

import co.edu.uniquindio.poo.gestionhospital.model.*;

import java.time.LocalDate;
import java.util.*;

public class GestionCitasController {

    Hospital hospital;

    public GestionCitasController(Hospital hospital) {
        this.hospital = hospital;
    }

    public void agendarCita(LocalDate fecha,   String idPaciente, String idDoctor ){
        hospital.agendarCita(fecha, idPaciente, idDoctor);
    }

    public void cancelarCita(int id){
        hospital.cancelarCita(id);
    }

    public List listarCitas(){
        return hospital.listarCitasOrdenadasPorFecha();
    }

}
