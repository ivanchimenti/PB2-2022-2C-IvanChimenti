package pb2.unlam.edu.ar;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestCase {

    @Test
    public void queSePuedaRegistrarUnaAlarmaEnLaCentral(){
        CentralAlarmas central = new CentralAlarmas("PAS");
        Administrador usuarioAdm = new Administrador(26493581, "Andres");
        Alarma alarma = new Alarma(869324, 111, "abc123", "Alarma Casa");

        central.registrarUsuario(usuarioAdm);

        assertTrue(usuarioAdm.registrarAlarmaEnLaCentral(central, alarma));
    }

    @Test
    public void queSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma(){
        CentralAlarmas central = new CentralAlarmas("PAS");
        Administrador usuarioAdm = new Administrador(26493581, "Andres");
        Alarma alarma = new Alarma(869324, 111, "abc123", "Alarma Casa");
        Usuario usuarioConf = new Configurador(28341969, "German");

        central.registrarUsuario(usuarioAdm);
        usuarioAdm.registrarAlarmaEnLaCentral(central, alarma);
        usuarioAdm.agregarUsuarioEnLaCentral(central, usuarioConf);

        assertTrue(usuarioAdm.agregarUsuarioAUnaAlarma(alarma, usuarioConf));
    }

    @Test (expected = CodigoAlarmaIncorrectoException.class)
    public void alAgregarUnUsuarioAUnaAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSeLanceUnaExcepcion() throws CodigoAlarmaIncorrectoException{
        CentralAlarmas central = new CentralAlarmas("PAS");
        Administrador usuarioAdm = new Administrador(26493581, "Andres");
        Alarma alarma = new Alarma(869324, 111, "abc123", "Alarma Casa");
        Usuario usuarioConf = new Configurador(28341969, "German");

        central.registrarUsuario(usuarioAdm);
        usuarioAdm.registrarAlarmaEnLaCentral(central, alarma);
        usuarioAdm.agregarUsuarioEnLaCentral(central, usuarioConf);
        usuarioAdm.agregarUsuarioAUnaAlarmaConCod(central, usuarioConf, alarma, "def456");
    }

    @Test (expected = SensorDuplicadoException.class)
    public void alAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnaExcepcion() throws SensorDuplicadoException {
        CentralAlarmas central = new CentralAlarmas("PAS");
        Administrador usuarioAdm = new Administrador(26493581, "Andres");
        Alarma alarma = new Alarma(869324, 111, "abc123", "Alarma Casa");
        Sensor sensor1 = new Sensor(35489, true);
        Sensor sensor2 = new Sensor(98561, true);
        Sensor sensor3 = new Sensor(35489, false);

        central.registrarUsuario(usuarioAdm);
        usuarioAdm.registrarAlarmaEnLaCentral(central, alarma);

        usuarioAdm.agregarUnSensorAUnaAlarma(alarma, sensor1);
        usuarioAdm.agregarUnSensorAUnaAlarma(alarma, sensor2);
        usuarioAdm.agregarUnSensorAUnaAlarma(alarma, sensor3);
    }

    @Test
    public void queNoSePuedaActivarUnaAlarmaSiHayAlmenosUnSensorDesactivado() throws SensorDuplicadoException {
        CentralAlarmas central = new CentralAlarmas("PAS");
        Administrador usuarioAdm = new Administrador(26493581, "Andres");
        Alarma alarma = new Alarma(869324, 111, "abc123", "Alarma Casa");
        Sensor sensor1 = new Sensor(35489, true);
        Sensor sensor2 = new Sensor(98561, true);
        Sensor sensor3 = new Sensor(45632, false);

        central.registrarUsuario(usuarioAdm);
        usuarioAdm.registrarAlarmaEnLaCentral(central, alarma);

        usuarioAdm.agregarUnSensorAUnaAlarma(alarma, sensor1);
        usuarioAdm.agregarUnSensorAUnaAlarma(alarma, sensor2);
        usuarioAdm.agregarUnSensorAUnaAlarma(alarma, sensor3);

        assertFalse(usuarioAdm.activarDesactivarAlarma(alarma, 111));
    }


}
