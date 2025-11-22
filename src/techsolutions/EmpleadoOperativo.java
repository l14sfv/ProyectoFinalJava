package techsolutions;

public class EmpleadoOperativo extends Empleado {
    public EmpleadoOperativo(String nombre, String identificacion, double salario) {
        super(nombre, identificacion, "Operativo", salario);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("[OPERATIVO] " + getNombre() + " | ID: " + getIdentificacion() + " | Salario: $" + getSalario());
    }

    @Override
    public void realizarTarea() {
        System.out.println(getNombre() + " ejecuta tareas básicas del día a día.");
    }
}

