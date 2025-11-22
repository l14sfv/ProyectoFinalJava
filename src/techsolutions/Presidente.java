package techsolutions;

public class Presidente extends Empleado {
    public Presidente(String nombre, String identificacion, double salario) {
        super(nombre, identificacion, "Presidente", salario);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("[PRESIDENTE] " + getNombre() + " | ID: " + getIdentificacion() + " | Salario: $" + getSalario());
    }

    @Override
    public void realizarTarea() {
        System.out.println(getNombre() + " define la visión estratégica de la empresa.");
    }
}

