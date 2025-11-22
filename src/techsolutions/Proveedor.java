package techsolutions;

public class Proveedor extends ActorEmpresa {
    private String producto;

    public Proveedor(String nombre, String identificacion, String producto) {
        super(nombre, identificacion);
        this.producto = producto;
    }

    public String getProducto() {
        return producto;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("[PROVEEDOR] " + getNombre() + " | ID: " + getIdentificacion() + " | Producto: " + producto);
    }
}

