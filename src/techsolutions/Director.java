package techsolutions;

public class Director extends Empleado {
    public Director(String nombre, String identificacion, double salario) {
        super(nombre, identificacion, "Director", salario);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("[DIRECTOR] " + getNombre() + " | ID: " + getIdentificacion() + " | Salario: $" + getSalario());
    }

    @Override
    public void realizarTarea() {
        System.out.println(getNombre() + " lidera las divisiones y toma decisiones clave.");
    }
}

