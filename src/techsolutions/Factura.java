package techsolutions;

public class Factura {
    private String numero;
    private double total;

    public Factura(String numero, double total) {
        this.numero = numero;
        this.total = total;
    }

    public void mostrarFactura() {
        System.out.println("Factura #" + numero + " | Total: $" + total);
    }
}

