package pb2.unlam.edu.ar;

import java.util.ArrayList;
import java.util.HashMap;

public class CentralAlarmas {
    private String nombreCentral;
    private ArrayList<Usuario> usuariosRegistrados;
    private HashMap<String, Alarma> alarmasRegistradas;

    public CentralAlarmas(String nombreCentral) {
        this.nombreCentral = nombreCentral;
        this.usuariosRegistrados = new ArrayList<>();
        this.alarmasRegistradas = new HashMap<>();
    }

    public void registrarUsuario(Usuario u){
        this.usuariosRegistrados.add(u);
    }

    public Integer obtenerCantDeUsuariosRegistrados(){
        return this.usuariosRegistrados.size();
    }

    public void registrarAlarma(Alarma a) {
        this.alarmasRegistradas.put(a.getCodConf(), a);
    }

    public Integer obtenerCantDeAlarmasRegistradas() {
        return this.alarmasRegistradas.size();
    }

    public Boolean buscarAlarmaPorCodDeConf(String codConfAlarm) throws CodigoAlarmaIncorrectoException {
        if (this.alarmasRegistradas.containsKey(codConfAlarm)){
            return true;
        }else{
            throw new CodigoAlarmaIncorrectoException("Codigo de configuracion incorrecto");
        }
    }

}
