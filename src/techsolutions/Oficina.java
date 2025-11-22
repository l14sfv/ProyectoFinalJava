package techsolutions;

public class Oficina {
    private String ubicacion;

    public Oficina(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void mostrarOficina() {
        System.out.println("Oficina en: " + ubicacion);
    }
}

