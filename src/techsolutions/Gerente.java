package techsolutions;

public class Gerente extends Empleado {
    public Gerente(String nombre, String identificacion, double salario) {
        super(nombre, identificacion, "Gerente", salario);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("[GERENTE] " + getNombre() + " | ID: " + getIdentificacion() + " | Salario: $" + getSalario());
    }

    @Override
    public void realizarTarea() {
        System.out.println(getNombre() + " coordina equipos y reporta al director.");
    }
}

