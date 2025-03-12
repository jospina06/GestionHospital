package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.time.LocalDate;
import java.util.*;

public class Hospital {
    protected GestorConfig gestorConfig;

    private String nombre;
    private LinkedList<Doctor> doctores;
    private LinkedList<Paciente> pacientes;
    private Collection<Cita> citas;

    public Hospital(String nombre) {
        this.gestorConfig = GestorConfig.getInstancia();
        this.nombre = nombre;
        this.doctores = new LinkedList<>();
        this.pacientes = new LinkedList<>();
        this.citas = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(LinkedList<Doctor> doctores) {
        this.doctores = doctores;
    }

    public LinkedList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(LinkedList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "Hospital{ nombre='" + nombre +
                "\n doctores=" + doctores +
                "\n pacientes=" + pacientes +
                '}';
    }

    // CRUD´s
    //metodo para crear un nuevo Doctor
    public void crearDoctor(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del doctor: ");
        String nombre = scanner.nextLine();

        String id;
        do{
            System.out.println("Ingrese el id del doctor: ");
            id = scanner.nextLine();
            if(verificarDoctor(id)) {
                System.out.println("ya existe un doctor con este id, por favor ingrese uno diferente");
            }
        } while (verificarDoctor(id));

        System.out.println("Ingrese la edad del doctor: ");
        int edad = scanner.nextInt();

        Doctor doctor = new Doctor(nombre, id, edad);
    }

    //metodo para agregar un doctor a la lista de doctores
    public void agregarDoctor(Doctor doctor){
        if (!verificarDoctor(doctor.getId())) {
            doctores.add(doctor);
        }
    }

    //metodo para verificar si ya existe un doctor con el mismo id
    public boolean verificarDoctor(String id) {
        boolean centinela = false;
        for (Doctor doctor : doctores) {
            if (doctor.getId().equals(id)) {
                return true;
            }
        }
        return centinela;
    }

    //metodo para crear un nuevo paciente
    public void crearPaciente(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();

        String id;
        do{
            System.out.println("Ingrese el id del paciente: ");
            id = scanner.nextLine();

            if(verificarPaciente(id)) {
                System.out.println("ya existe un paciente con este id ingrese uno nuevo");
            }
        } while (verificarPaciente(id));

        System.out.println("Ingrese la edad del paciente: ");
        int edad = scanner.nextInt();

        Paciente paciente = new Paciente(nombre, id, edad);
    }

    //metodo para agregar un paciente a la lista de pacientes
    public void agregarPaciente(Paciente paciente){
        if (!verificarPaciente(paciente.getId())) {
            pacientes.add(paciente);
        }
    }

    //metodo para verificar si ya existe un paciente con el mismo id
    public boolean verificarPaciente(String id) {
        boolean centinela = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                return true;
            }
        }
        return centinela;
    }

    //metodo para reservar una cita
    public void reservarCita(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la fecha de la cita (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(scanner.nextLine());

        System.out.println("Ingrese el id del paciente: ");
        int id = scanner.nextInt();

        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                Cita cita = new Cita(fecha, paciente);
                paciente.agregarCita(cita);
            }
        }
    }

    //metodo para cancelar una cita
    public void cancelarCita(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el id del paciente: ");
        int id = scanner.nextInt();
        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                System.out.println("¿Cual cita quiere cancelar?\n" + paciente.getCitas());
                int citaCancelar = scanner.nextInt();
                for (Cita cita : paciente.getCitas()) {
                    paciente.eliminarCita(cita);
                }
            }
        }
    }

    //metodo para listar citas
    public List<Cita> listarCitas() {
        List<Cita> citasOrdenadas = new ArrayList<>(citas);
        citasOrdenadas.sort(Comparator.comparing(Cita::getFecha));
        return citasOrdenadas;
    }

    //metodo que imprime a los pacientes con nombre palíndromo
    public void imprimirPalindromos(LinkedList<Paciente> pacientes){
        for (Paciente paciente : pacientes) {
            if (paciente.esPalindromo()) {
                System.out.println(paciente);
            }
        }
    }

    //metodo que imprime los pacientes con dos vocales iguales en su nombre
    public void imprimirVocalesiguales(LinkedList<Paciente> pacientes){
        for (Paciente paciente : pacientes) {
            if (paciente.vocalesIguales()){
                System.out.println(paciente);
            }
        }
    }
}
