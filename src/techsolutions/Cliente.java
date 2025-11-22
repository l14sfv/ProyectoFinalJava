package techsolutions;

public class Cliente extends ActorEmpresa {
    private String email;

    public Cliente(String nombre, String identificacion, String email) {
        super(nombre, identificacion);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("[CLIENTE] " + getNombre() + " | ID: " + getIdentificacion() + " | Email: " + email);
    }
}

