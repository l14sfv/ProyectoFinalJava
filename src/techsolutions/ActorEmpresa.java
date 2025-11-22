package techsolutions;

public abstract class ActorEmpresa {
    private String nombre;
    private String identificacion;

    public ActorEmpresa(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public abstract void mostrarResumen();
}

