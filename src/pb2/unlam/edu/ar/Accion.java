package pb2.unlam.edu.ar;

import java.util.Date;

public class Accion {
    private Integer idAccion;
    private Alarma alarmaDondeSeRealiza;
    private Usuario usuarioRealizador;
    private Date fecha;
    private TipoOperacion tipoOp;

    public Accion(Integer idAccion, Alarma alarmaDondeSeRealiza, Usuario usuarioRealizador, Date fecha, TipoOperacion tipoOp) {
        this.idAccion = idAccion;
        this.alarmaDondeSeRealiza = alarmaDondeSeRealiza;
        this.usuarioRealizador = usuarioRealizador;
        this.fecha = fecha;
        this.tipoOp = tipoOp;
    }

    public Integer getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(Integer idAccion) {
        this.idAccion = idAccion;
    }

    public Alarma getAlarmaDondeSeRealiza() {
        return alarmaDondeSeRealiza;
    }

    public void setAlarmaDondeSeRealiza(Alarma alarmaDondeSeRealiza) {
        this.alarmaDondeSeRealiza = alarmaDondeSeRealiza;
    }

    public Usuario getUsuarioRealizador() {
        return usuarioRealizador;
    }

    public void setUsuarioRealizador(Usuario usuarioRealizador) {
        this.usuarioRealizador = usuarioRealizador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoOperacion getTipoOp() {
        return tipoOp;
    }

    public void setTipoOp(TipoOperacion tipoOp) {
        this.tipoOp = tipoOp;
    }
}
