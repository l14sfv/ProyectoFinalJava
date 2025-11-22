package techsolutions;

public class Contrato {
    private String tipo;
    private String duracion;

    public Contrato(String tipo, String duracion) {
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public void mostrarContrato() {
        System.out.println("Contrato: " + tipo + " | Duración: " + duracion);
    }
}

