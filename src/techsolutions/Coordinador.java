package techsolutions;

public class Coordinador extends Empleado {
    public Coordinador(String nombre, String identificacion, double salario) {
        super(nombre, identificacion, "Coordinador", salario);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("[COORDINADOR] " + getNombre() + " | ID: " + getIdentificacion() + " | Salario: $" + getSalario());
    }

    @Override
    public void realizarTarea() {
        System.out.println(getNombre() + " organiza actividades dentro del departamento.");
    }
}

