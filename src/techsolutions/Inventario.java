package techsolutions;

public class Inventario {
    private int cantidadProductos;

    public Inventario(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public void mostrarInventario() {
        System.out.println("Inventario: " + cantidadProductos + " productos disponibles.");
    }
}

