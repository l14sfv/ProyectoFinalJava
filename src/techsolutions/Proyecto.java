package techsolutions;

public class Proyecto {
    private String nombre;
    private double presupuesto;

    public Proyecto(String nombre, double presupuesto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }

    public void mostrarInfo() {
        System.out.println("Proyecto: " + nombre + " | Presupuesto: $" + presupuesto);
    }
}

