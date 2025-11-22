package techsolutions;

public class Nomina {
    private double totalPagado;

    public Nomina(double totalPagado) {
        this.totalPagado = totalPagado;
    }

    public void mostrarNomina() {
        System.out.println("Total nómina: $" + totalPagado);
    }
}

