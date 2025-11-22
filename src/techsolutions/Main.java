package techsolutions;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    private List<Empleado> empleados = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Proveedor> proveedores = new ArrayList<>();

    private JTextArea areaResultados;
    private JPanel panelPrincipal;

    public Main() {
        inicializarInterfaz();
    }

    private void inicializarInterfaz() {
        setTitle("TECHSOLUTIONS - Sistema de Gestión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);

        panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelPrincipal.setBackground(new Color(245, 245, 250));

        JLabel titulo = new JLabel("TECHSOLUTIONS", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(new Color(0, 102, 204));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        JPanel panelBotones = new JPanel(new GridLayout(3, 2, 10, 10));
        panelBotones.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
            "Opciones",
            javax.swing.border.TitledBorder.CENTER,
            javax.swing.border.TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));

        JButton btnRegistrarEmpleado = crearBoton("Registrar Empleado", new Color(52, 152, 219));
        JButton btnRegistrarCliente = crearBoton("Registrar Cliente", new Color(46, 204, 113));
        JButton btnRegistrarProveedor = crearBoton("Registrar Proveedor", new Color(155, 89, 182));
        JButton btnVerEmpleados = crearBoton("Ver Empleados", new Color(241, 196, 15));
        JButton btnVerClientes = crearBoton("Ver Clientes", new Color(230, 126, 34));
        JButton btnVerProveedores = crearBoton("Ver Proveedores", new Color(231, 76, 60));

        btnRegistrarEmpleado.addActionListener(e -> registrarEmpleado());
        btnRegistrarCliente.addActionListener(e -> registrarCliente());
        btnRegistrarProveedor.addActionListener(e -> registrarProveedor());
        btnVerEmpleados.addActionListener(e -> mostrarEmpleados());
        btnVerClientes.addActionListener(e -> mostrarClientes());
        btnVerProveedores.addActionListener(e -> mostrarProveedores());

        panelBotones.add(btnRegistrarEmpleado);
        panelBotones.add(btnRegistrarCliente);
        panelBotones.add(btnRegistrarProveedor);
        panelBotones.add(btnVerEmpleados);
        panelBotones.add(btnVerClientes);
        panelBotones.add(btnVerProveedores);

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        areaResultados.setFont(new Font("Consolas", Font.PLAIN, 12));
        areaResultados.setBackground(Color.WHITE);
        areaResultados.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JScrollPane scrollPane = new JScrollPane(areaResultados);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
            "Resultados",
            javax.swing.border.TitledBorder.CENTER,
            javax.swing.border.TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));

        JButton btnLimpiar = new JButton("Limpiar Resultados");
        estilizarBoton(btnLimpiar, new Color(127, 140, 141));
        btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 11));
        btnLimpiar.addActionListener(e -> areaResultados.setText(""));

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelInferior.add(btnLimpiar);

        panelPrincipal.add(titulo, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.WEST);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    private void estilizarBoton(JButton boton, Color colorFondo) {
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setPreferredSize(new Dimension(180, 50));
        estilizarBoton(boton, color);
        return boton;
    }
    private void registrarEmpleado() {
        JDialog dialog = new JDialog(this, "Registrar Empleado", true);
        dialog.setSize(450, 350);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout(10, 10));
        dialog.getContentPane().setBackground(new Color(245, 245, 250));

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField txtNombre = new JTextField(20);
        JTextField txtID = new JTextField(20);
        JComboBox<String> comboCargo = new JComboBox<>(new String[]{
            "presidente", "director", "gerente", "coordinador", "operativo"
        });
        JTextField txtSalario = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc); gbc.gridx = 1;
        panel.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("ID:"), gbc); gbc.gridx = 1;
        panel.add(txtID, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Cargo:"), gbc); gbc.gridx = 1;
        panel.add(comboCargo, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Salario:"), gbc); gbc.gridx = 1;
        panel.add(txtSalario, gbc);

        JPanel panelBotones = new JPanel(new FlowLayout());

        JButton btnGuardar = new JButton("Guardar");
        estilizarBoton(btnGuardar, new Color(52, 152, 219));
        btnGuardar.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText().trim();
                String id = txtID.getText().trim();
                String cargo = (String) comboCargo.getSelectedItem();
                double salario = Double.parseDouble(txtSalario.getText().trim());

                if (nombre.isEmpty() || id.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Por favor complete todos los campos.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Empleado emp = switch (cargo.toLowerCase()) {
                    case "presidente" -> new Presidente(nombre, id, salario);
                    case "director" -> new Director(nombre, id, salario);
                    case "gerente" -> new Gerente(nombre, id, salario);
                    case "coordinador" -> new Coordinador(nombre, id, salario);
                    case "operativo" -> new EmpleadoOperativo(nombre, id, salario);
                    default -> null;
                };

                if (emp != null) {
                    empleados.add(emp);
                    JOptionPane.showMessageDialog(dialog, "Empleado registrado exitosamente.",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "El salario debe ser un número válido.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancelar = new JButton("Cancelar");
        estilizarBoton(btnCancelar, new Color(231, 76, 60));
        btnCancelar.addActionListener(e -> dialog.dispose());

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(panelBotones, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private void registrarCliente() {
        JDialog dialog = new JDialog(this, "Registrar Cliente", true);
        dialog.setSize(450, 250);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout(10, 10));
        dialog.getContentPane().setBackground(new Color(245, 245, 250));

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField txtNombre = new JTextField(20);
        JTextField txtID = new JTextField(20);
        JTextField txtEmail = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc); gbc.gridx = 1;
        panel.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("ID:"), gbc); gbc.gridx = 1;
        panel.add(txtID, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Email:"), gbc); gbc.gridx = 1;
        panel.add(txtEmail, gbc);

        JPanel panelBotones = new JPanel(new FlowLayout());

        JButton btnGuardar = new JButton("Guardar");
        estilizarBoton(btnGuardar, new Color(46, 204, 113));
        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String id = txtID.getText().trim();
            String email = txtEmail.getText().trim();

            if (nombre.isEmpty() || id.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Por favor complete todos los campos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            clientes.add(new Cliente(nombre, id, email));
            JOptionPane.showMessageDialog(dialog, "Cliente registrado exitosamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });

        JButton btnCancelar = new JButton("Cancelar");
        estilizarBoton(btnCancelar, new Color(231, 76, 60));
        btnCancelar.addActionListener(e -> dialog.dispose());

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(panelBotones, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private void registrarProveedor() {
        JDialog dialog = new JDialog(this, "Registrar Proveedor", true);
        dialog.setSize(450, 250);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout(10, 10));
        dialog.getContentPane().setBackground(new Color(245, 245, 250));

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField txtNombre = new JTextField(20);
        JTextField txtID = new JTextField(20);
        JTextField txtProducto = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc); gbc.gridx = 1;
        panel.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("ID:"), gbc); gbc.gridx = 1;
        panel.add(txtID, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Producto:"), gbc); gbc.gridx = 1;
        panel.add(txtProducto, gbc);

        JPanel panelBotones = new JPanel(new FlowLayout());

        JButton btnGuardar = new JButton("Guardar");
        estilizarBoton(btnGuardar, new Color(155, 89, 182));
        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String id = txtID.getText().trim();
            String producto = txtProducto.getText().trim();

            if (nombre.isEmpty() || id.isEmpty() || producto.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Por favor complete todos los campos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            proveedores.add(new Proveedor(nombre, id, producto));
            JOptionPane.showMessageDialog(dialog, "Proveedor registrado exitosamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });

        JButton btnCancelar = new JButton("Cancelar");
        estilizarBoton(btnCancelar, new Color(231, 76, 60));
        btnCancelar.addActionListener(e -> dialog.dispose());

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(panelBotones, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    private void mostrarEmpleados() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== EMPLEADOS REGISTRADOS ===\n\n");

        if (empleados.isEmpty()) {
            sb.append("No hay empleados registrados.\n");
        } else {
            for (Empleado emp : empleados) {
                String tipo = emp.getClass().getSimpleName();
                String nombre = emp.getNombre();
                String id = emp.getIdentificacion();
                double salario = emp.getSalario();

                String cargo = tipo.equals("EmpleadoOperativo") ? "OPERATIVO" : tipo.toUpperCase();

                sb.append("[").append(cargo).append("] ")
                .append(nombre).append(" | ID: ").append(id)
                .append(" | Salario: $").append(String.format("%.2f", salario))
                .append("\n");
            }
        }

        areaResultados.setText(sb.toString());
    }

    private void mostrarClientes() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== CLIENTES REGISTRADOS ===\n\n");

        if (clientes.isEmpty()) {
            sb.append("No hay clientes registrados.\n");
        } else {
            for (Cliente cliente : clientes) {
                sb.append("[CLIENTE] ")
                .append(cliente.getNombre()).append(" | ID: ")
                .append(cliente.getIdentificacion()).append(" | Email: ")
                .append(cliente.getEmail()).append("\n");
            }
        }

        areaResultados.setText(sb.toString());
    }

    private void mostrarProveedores() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== PROVEEDORES REGISTRADOS ===\n\n");

        if (proveedores.isEmpty()) {
            sb.append("No hay proveedores registrados.\n");
        } else {
            for (Proveedor proveedor : proveedores) {
                sb.append("[PROVEEDOR] ")
                .append(proveedor.getNombre()).append(" | ID: ")
                .append(proveedor.getIdentificacion()).append(" | Producto: ")
                .append(proveedor.getProducto()).append("\n");
            }
        }

        areaResultados.setText(sb.toString());
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
