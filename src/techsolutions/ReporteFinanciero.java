package techsolutions;

public class ReporteFinanciero {
    private double ingresos;
    private double egresos;

    public ReporteFinanciero(double ingresos, double egresos) {
        this.ingresos = ingresos;
        this.egresos = egresos;
    }

    public double getIngresos() {
        return ingresos;
    }

    public double getEgresos() {
        return egresos;
    }

    public double getBalance() {
        return ingresos - egresos;
    }

    public void mostrarReporte() {
        System.out.println("Ingresos: $" + ingresos + " | Egresos: $" + egresos);
    }
}

