package pb2.unlam.edu.ar;

import java.util.ArrayList;
import java.util.HashSet;

public class Alarma {
    private Integer idAlarma;
    private Integer codActDesac;
    private String codConf;
    private String nombreAlarma;
    private ArrayList<Usuario> usuariosValidos;
//    private ArrayList<Accion> accionesRealizadas;
    private ArrayList<Sensor> sensores;

    public Alarma(Integer idAlarma, Integer codActDesac, String codConf, String nombreAlarma) {
        this.idAlarma = idAlarma;
        this.codActDesac = codActDesac;
        this.codConf = codConf;
        this.nombreAlarma = nombreAlarma;
        this.usuariosValidos = new ArrayList<>();
//        this.accionesRealizadas = new ArrayList<>();
        this.sensores = new ArrayList<>();
    }

    public Integer getIdAlarma() {
        return idAlarma;
    }

    public void setIdAlarma(Integer idAlarma) {
        this.idAlarma = idAlarma;
    }

    public Integer getCodActDesac() {
        return codActDesac;
    }

    public void setCodActDesac(Integer codActDesac) {
        this.codActDesac = codActDesac;
    }

    public String getCodConf() {
        return codConf;
    }

    public void setCodConf(String codConf) {
        this.codConf = codConf;
    }

    public void agregarUsuario(Usuario u){
        this.usuariosValidos.add(u);
    }

    public Integer obtenerCantUsuarioValidosRegistrados() {
        return this.usuariosValidos.size();
    }

    public Boolean buscarSensor(Integer idSensor) throws SensorDuplicadoException{
        for (Sensor s : sensores) {
            if (s.getIdSensor().equals(idSensor)) {
                throw new SensorDuplicadoException("Sensor duplicado");
            }
        }
        return false;
    }

    public void agregarSensor(Sensor sensor) {
        this.sensores.add(sensor);
    }

    public Boolean sensoresActivados() {
        int cont = 0;
        for (Sensor s : sensores) {
            if (s.getEstado().equals(true)){
                cont++;
                return true;
            }
        }
        if (sensores.size() == cont){
            return true;
        }else{
            return false;
        }
    }
}
