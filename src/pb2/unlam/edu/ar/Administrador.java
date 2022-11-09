package pb2.unlam.edu.ar;

import java.util.ArrayList;

public class Administrador extends Usuario {

    public Administrador(Integer dni, String nombre) {
        super(dni, nombre);
    }

    public Boolean registrarAlarmaEnLaCentral(CentralAlarmas central, Alarma alarma) {
        central.registrarAlarma(alarma);
        return true;
    }

    public Boolean agregarUsuarioEnLaCentral(CentralAlarmas central, Usuario usuarioConf) {
        central.registrarUsuario(usuarioConf);
        return true;
    }

    public Boolean agregarUsuarioAUnaAlarma(Alarma alarma, Usuario usuarioConf) {
        alarma.agregarUsuario(usuarioConf);
        return true;
    }

    public void agregarUsuarioAUnaAlarmaConCod(CentralAlarmas central, Usuario usuarioConf, Alarma alarma, String codConf) throws CodigoAlarmaIncorrectoException {
        if (central.buscarAlarmaPorCodDeConf(codConf)){
            alarma.agregarUsuario(usuarioConf);
        }
    }

    public void agregarUnSensorAUnaAlarma(Alarma alarma, Sensor sensor) throws SensorDuplicadoException {
        if(!(alarma.buscarSensor(sensor.getIdSensor()))){
            alarma.agregarSensor(sensor);
        }
    }

    public Boolean activarDesactivarAlarma(Alarma alarma, Integer codActDesact) {
        if (alarma.getCodActDesac().equals(codActDesact)){
            return alarma.sensoresActivados();
        } else {
            return false;
        }
    }
}
