package techsolutions;

public abstract class Empleado extends ActorEmpresa {
    private String cargo;
    private double salario;

    public Empleado(String nombre, String identificacion, String cargo, double salario) {
        super(nombre, identificacion);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public abstract void realizarTarea();
}

