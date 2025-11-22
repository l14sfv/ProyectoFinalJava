package techsolutions;

public class Region {
    private String nombre;

    public Region(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarRegion() {
        System.out.println("Región: " + nombre);
    }
}

