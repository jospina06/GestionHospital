package co.edu.uniquindio.poo.gestionhospital.model;

import javax.swing.*;
import java.util.*;
import java.time.LocalDate;

public class Hospital {

    private String nombre;
    private Collection<Paciente> pacientes;
    private Collection<Doctor> doctores;
    private Collection<Cita> citas;
    protected GestorConfig gestorConfig;



    public Hospital(String nombre) {
        this.nombre = nombre;
        this.pacientes = new LinkedList<>();
        this.doctores = new LinkedList<>();
        this.citas = new LinkedList<>();
        this.gestorConfig = gestorConfig.getInstance();
    }



    //--------------CRUD PACIENTE----------------//

    /**
     * Método para agregar un nuevo paciente a la lista de pacientes del hospital
     * @param paciente
     */
    public void agregarPaciente(Paciente paciente) {
        if (buscarPacientePorId(paciente.getId()) == null) {
            pacientes.add(paciente);
            System.out.println("Paciente agregado correctamente.");
        } else {
            System.out.println("Error: Ya existe un paciente con este ID.");
        }
    }

    /**
     * Método que busca a un paciente dentro de la lista de pacientes del hospital
     * @param id del paciente a buscar
     * @return paciente encontrado
     */
    public Paciente buscarPacientePorId(String id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                return paciente;
            }
        }
        System.out.println("Paciente no encontrado.");
        return null;
    }

    /**
     * Método para actualizar los datos de un paciente
     * @param id
     * @param nuevoNombre
     * @param nuevaEdad
     */
    public void actualizarPaciente(String id, String nuevoNombre, int nuevaEdad) {
        Paciente paciente = buscarPacientePorId(id);
        if (paciente != null) {
            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                paciente.setNombre(nuevoNombre);
            }
            if ( nuevaEdad > 0) {
                paciente.setEdad(nuevaEdad);
            }
            System.out.println("Paciente actualizado correctamente.");
        } else {
            System.out.println("Error: No se encontró el paciente para actualizar.");
        }
    }

    /**
     * Método para eliminar un paciente
     * @param id del paciente a eliminar
     */
    public void eliminarPaciente(String id) {
        Paciente paciente = buscarPacientePorId(id);
        if (paciente != null) {
            pacientes.remove(paciente);
            System.out.println("Paciente eliminado correctamente ");
        } else {
            System.out.println("Error: No se encontró el paciente para eliminar ");
        }
    }

    //------------------- CRUD DOCTOR----------------------//

    /**
     * Método para agregar un nuevo doctor
     * @param doctor
     */
    public void agregarDoctor(Doctor doctor){
        if(buscarDoctorPorId(doctor.getId()) == null){
            doctores.add(doctor);
            System.out.println("Doctor agregado con exito. ");
        } else {
            System.out.println("Error: Ya existe un doctor con este ID.");
        }
    }

    /**
     * Método para buscar a un doctor dentro de la lista de doctores del hospital
     * @param id
     * @return doctor encontrado
     */
    public Doctor buscarDoctorPorId(String id){
        for(Doctor doctor : doctores){
            if(doctor.getId().equals(id)){
                return doctor;
            }
        }
        System.out.println("Doctor no encontrado.");
        return null;
    }

    /**
     * Método para actualizar los datos de un doctor
     * @param id del doctor a actualizar
     * @param nuevoNombre
     * @param nuevaEdad
     * @param nuevaArea
     */
    public void actualizarDoctor(String id, String nuevoNombre, int nuevaEdad, String nuevaArea){
        Doctor doctor = buscarDoctorPorId(id);
        if (doctor != null) {
            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                doctor.setNombre(nuevoNombre);
            }
            if ( nuevaEdad > 0) {
                doctor.setEdad(nuevaEdad);
            }
            if(nuevaArea != null && !nuevaArea.trim().isEmpty()){
                doctor.setArea(nuevaArea);
            }
            System.out.println("Doctor actualizado correctamente.");
        } else {
            System.out.println("Error: No se encontró el doctor para actualizar.");
        }
    }

    /**
     * Método para eliminar a un doctor
     * @param id del doctor a eliminar
     */
    public void eliminarDoctor(String id){
        Doctor doctor = buscarDoctorPorId(id);
        if(doctor!= null){
            doctores.remove(doctor);
            System.out.println("Doctor eliminado correctamente");
        }
    }


    //------------------ CRUD de Cita---------------------//

    /**
     * Método para agendar una cita
     * @param fecha
     * @param idPaciente
     * @param idDoctor
     */
    public void agendarCita(LocalDate fecha, String idPaciente, String idDoctor) {
        Paciente paciente = buscarPacientePorId(idPaciente);
        Doctor doctor = buscarDoctorPorId(idDoctor);

        if (paciente == null) {
            System.out.println("Error: No se encontró un paciente con el ID " + idPaciente);
            return;
        }
        if (doctor == null) {
            System.out.println("Error: No se encontró un doctor con el ID " + idDoctor);
            return;
        }

        Cita nuevaCita = new Cita(fecha, paciente, doctor);
        citas.add(nuevaCita);
        System.out.println("Cita reservada con éxito: " + nuevaCita);
    }

    /**
     * Método para cancelar una cita
     * @param idCita
     */
    public void cancelarCita(int idCita) {
        for(Cita cita : citas){
            if(cita.getId() == (idCita)){
                citas.remove(cita);
                System.out.println(" Cita ID " + idCita + " cancelada. " );
            } else {
                System.out.println("No se encontró una cita con el id " + idCita);
            }
        }
    }

    //COMPLETAR
    public List<Cita> listarCitasOrdenadasPorFecha() {
        List<Cita> citasOrdenadas = new ArrayList<>(citas);
        citasOrdenadas.sort(Comparator.comparing(Cita::getFecha));
        return citasOrdenadas;
    }






    //---------------- CRUD DE CONSULTA---------------------//

    /**
     * Método para agregar una consulta al historial de un paciente
     * @param consulta que se desea agregar
     * @param idPaciente del paciente
     */
    public void agregarConsultaHistorial(Consulta consulta, String idPaciente) {
        Objects.requireNonNull(consulta, "La consulta no puede ser nulo");
        Paciente paciente = buscarPacientePorId(idPaciente);
        if (paciente == null) {
            throw new NoSuchElementException("El paciente con ID " + idPaciente + " no existe.");
        }
        paciente.getHistorial().agregarConsulta(consulta);
    }


    /**
     * Método para agregar una enfermedad a la ultima consulta de un paciente
     * @param idPaciente
     * @param enfermedad
     */
    public void agregarEnfermedadUltimaConsulta(String idPaciente, String enfermedad) {
        Paciente paciente = buscarPacientePorId(idPaciente);
        if (paciente == null) {
            throw new NoSuchElementException("El paciente con ID " + idPaciente + " no existe.");
        }
        paciente.agregarEnfermedadUltimaConsulta(enfermedad);
    }

    /**
     * Método para agregar un medicamento a la ultima consulta de un paciente
     * @param idPaciente
     * @param medicamento
     */
    public void agregarMedicamentoUltimaConsulta(String idPaciente, String medicamento) {
        Paciente paciente = buscarPacientePorId(idPaciente);
        if (paciente == null) {
            throw new NoSuchElementException("El paciente con ID " + idPaciente + " no existe.");
        }
        paciente.agregarMedicamentoUltimaConsulta(medicamento);
    }

    //----------------------Métodos adicionales--------------------//

    /**
     * Método que imprime todos los pacientes con nombre palindromo
     * @param
     */
    public void imprimirPalindromos() {
        StringBuilder mensaje = new StringBuilder("Pacientes con nombre palíndromo:\n");

        for (Paciente paciente : pacientes) {
            if (paciente.esPalindromo()) {
                mensaje.append(paciente.getNombre()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Pacientes con Nombre Palíndromo", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * metodo que imprime los pacientes con dos vocales iguales en su nombre
     * @param
     */
    public void imprimirVocalesIguales() {
        StringBuilder mensaje = new StringBuilder("Pacientes con vocales iguales en el nombre:\n");

        for (Paciente paciente : pacientes) {
            if (paciente.vocalesIguales()) {
                mensaje.append(paciente.getNombre()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Pacientes con Vocales Iguales", JOptionPane.INFORMATION_MESSAGE);
    }





    //----------------------- Gets Y Sets------------------------//
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Collection<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Collection<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(Collection<Doctor> doctores) {
        this.doctores = doctores;
    }

    public Collection<Cita> getCitas() {
        return citas;
    }

    public void setCitas(Collection<Cita> citas) {
        this.citas = citas;
    }

    public GestorConfig getGestorConfig() {
        return gestorConfig;
    }

    public void setGestorConfig(GestorConfig gestorConfig) {
        this.gestorConfig = gestorConfig;
    }
}
