package co.edu.uniquindio.poo.gestionhospitalaria.model;

public class GestorConfig {
    private static GestorConfig instancia;

    private GestorConfig() {

    }

    public static GestorConfig getInstancia(){
        if(instancia == null){
            instancia = new GestorConfig();
        }
        return instancia;
    }
}
