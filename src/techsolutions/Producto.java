package techsolutions;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void mostrarProducto() {
        System.out.println("Producto: " + nombre + " | Precio: $" + precio);
    }
}

