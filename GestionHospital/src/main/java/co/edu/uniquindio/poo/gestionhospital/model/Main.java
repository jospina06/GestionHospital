package co.edu.uniquindio.poo.gestionhospital.model;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args){

        Hospital hospital = new Hospital("Hospital del Quindío");

        Paciente paciente0 = new Paciente("Juan", "123", 40);
        hospital.agregarPaciente(paciente0);
        hospital.agregarPaciente(new Paciente("María Gómez", "00", 25));

        Doctor doctor1 = new Doctor("Octavio", "DR1", 45, "Cardiología");
        hospital.agregarDoctor(doctor1);

        hospital.agendarCita(LocalDate.now(), "123", "DR1");
        hospital.agendarCita(LocalDate.of(2026, 10, 5), "123", "DR1");
        hospital.agendarCita(LocalDate.of(1970, 5, 20), "123", "DR1");



        System.out.println(hospital.listarCitasOrdenadasPorFecha());

    }

}
