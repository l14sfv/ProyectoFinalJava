package techsolutions;

public class Sucursal {
    private String ciudad;

    public Sucursal(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void mostrarSucursal() {
        System.out.println("Sucursal ubicada en: " + ciudad);
    }
}

