package pb2.unlam.edu.ar;

public class Usuario {
    protected Integer dni;
    protected String nombre;

    public Usuario(Integer dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
