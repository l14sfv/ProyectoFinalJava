package techsolutions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    private List<Empleado> empleados = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Proveedor> proveedores = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private List<Sucursal> sucursales = new ArrayList<>();
    private List<Region> regiones = new ArrayList<>();
    private Inventario inventario = new Inventario(0);
    
    private JTextArea areaResultados;
    private JPanel panelPrincipal;

    public Main() {
        inicializarInterfaz();
    }

    private void inicializarInterfaz() {
        setTitle("TECHSOLUTIONS - Sistema de Gestión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 800);
        setLocationRelativeTo(null);
        
        // Panel principal con BorderLayout
        panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelPrincipal.setBackground(new Color(245, 245, 250));
        
        // Título
        JLabel titulo = new JLabel("TECHSOLUTIONS", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(new Color(0, 102, 204));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        
        // Panel de botones con scroll
        JPanel panelBotones = new JPanel(new GridLayout(0, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
            "Opciones",
            javax.swing.border.TitledBorder.CENTER,
            javax.swing.border.TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        
        // Botones con estilo - Registros
        JButton btnRegistrarEmpleado = crearBoton("Registrar Empleado", new Color(52, 152, 219));
        JButton btnRegistrarCliente = crearBoton("Registrar Cliente", new Color(46, 204, 113));
        JButton btnRegistrarProveedor = crearBoton("Registrar Proveedor", new Color(155, 89, 182));
        JButton btnRegistrarProducto = crearBoton("Registrar Producto", new Color(26, 188, 156));
        JButton btnRegistrarSucursal = crearBoton("Registrar Sucursal", new Color(142, 68, 173));
        JButton btnRegistrarRegion = crearBoton("Registrar Región", new Color(39, 174, 96));
        
        // Botones - Visualización
        JButton btnVerEmpleados = crearBoton("Ver Empleados", new Color(241, 196, 15));
        JButton btnVerClientes = crearBoton("Ver Clientes", new Color(230, 126, 34));
        JButton btnVerProveedores = crearBoton("Ver Proveedores", new Color(231, 76, 60));
        JButton btnVerProductos = crearBoton("Ver Productos", new Color(52, 73, 94));
        JButton btnVerInventario = crearBoton("Ver Inventario", new Color(149, 165, 166));
        JButton btnVerSucursales = crearBoton("Ver Sucursales", new Color(192, 57, 43));
        JButton btnVerRegiones = crearBoton("Ver Regiones", new Color(127, 140, 141));
        JButton btnReporteFinanciero = crearBoton("Reporte Financiero", new Color(243, 156, 18));
        
        // Agregar listeners
        btnRegistrarEmpleado.addActionListener(e -> registrarEmpleado());
        btnRegistrarCliente.addActionListener(e -> registrarCliente());
        btnRegistrarProveedor.addActionListener(e -> registrarProveedor());
        btnRegistrarProducto.addActionListener(e -> registrarProducto());
        btnRegistrarSucursal.addActionListener(e -> registrarSucursal());
        btnRegistrarRegion.addActionListener(e -> registrarRegion());
        btnVerEmpleados.addActionListener(e -> mostrarEmpleados());
        btnVerClientes.addActionListener(e -> mostrarClientes());
        btnVerProveedores.addActionListener(e -> mostrarProveedores());
        btnVerProductos.addActionListener(e -> mostrarProductos());
        btnVerInventario.addActionListener(e -> mostrarInventario());
        btnVerSucursales.addActionListener(e -> mostrarSucursales());
        btnVerRegiones.addActionListener(e -> mostrarRegiones());
        btnReporteFinanciero.addActionListener(e -> mostrarReporteFinanciero());
        
        // Agregar botones al panel
        panelBotones.add(btnRegistrarEmpleado);
        panelBotones.add(btnRegistrarCliente);
        panelBotones.add(btnRegistrarProveedor);
        panelBotones.add(btnRegistrarProducto);
        panelBotones.add(btnRegistrarSucursal);
        panelBotones.add(btnRegistrarRegion);
        panelBotones.add(new JSeparator());
        panelBotones.add(btnVerEmpleados);
        panelBotones.add(btnVerClientes);
        panelBotones.add(btnVerProveedores);
        panelBotones.add(btnVerProductos);
        panelBotones.add(btnVerInventario);
        panelBotones.add(btnVerSucursales);
        panelBotones.add(btnVerRegiones);
        panelBotones.add(btnReporteFinanciero);
        
        // Scroll pane para botones
        JScrollPane scrollBotones = new JScrollPane(panelBotones);
        scrollBotones.setPreferredSize(new Dimension(200, 0));
        scrollBotones.setBorder(null);
        
        // Área de resultados
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
        
        // Botón limpiar
        JButton btnLimpiar = new JButton("Limpiar Resultados");
        btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 11));
        btnLimpiar.addActionListener(e -> areaResultados.setText(""));
        
        // Panel inferior
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelInferior.add(btnLimpiar);
        
        // Agregar componentes al panel principal
        panelPrincipal.add(titulo, BorderLayout.NORTH);
        panelPrincipal.add(scrollBotones, BorderLayout.WEST);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }
    
    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setPreferredSize(new Dimension(180, 50));
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Efecto hover
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(color.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(color);
            }
        });
        
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
        
        // Campos
        JTextField txtNombre = new JTextField(20);
        JTextField txtID = new JTextField(20);
        JComboBox<String> comboCargo = new JComboBox<>(new String[]{
            "presidente", "director", "gerente", "coordinador", "operativo"
        });
        JTextField txtSalario = new JTextField(20);
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNombre, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        panel.add(txtID, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Cargo:"), gbc);
        gbc.gridx = 1;
        panel.add(comboCargo, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Salario:"), gbc);
        gbc.gridx = 1;
        panel.add(txtSalario, gbc);
        
        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(46, 204, 113));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setOpaque(true);
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
        btnCancelar.setBackground(new Color(231, 76, 60));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setOpaque(true);
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
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNombre, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        panel.add(txtID, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        panel.add(txtEmail, gbc);
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(46, 204, 113));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setOpaque(true);
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
        btnCancelar.setBackground(new Color(231, 76, 60));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setOpaque(true);
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
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNombre, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        panel.add(txtID, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Producto:"), gbc);
        gbc.gridx = 1;
        panel.add(txtProducto, gbc);
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(46, 204, 113));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setOpaque(true);
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
        btnCancelar.setBackground(new Color(231, 76, 60));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setOpaque(true);
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
                
                String cargo = tipo.toUpperCase();
                if (tipo.equals("EmpleadoOperativo")) {
                    cargo = "OPERATIVO";
                }
                
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
    
    private void registrarProducto() {
        JDialog dialog = new JDialog(this, "Registrar Producto", true);
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
        JTextField txtPrecio = new JTextField(20);
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNombre, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Precio:"), gbc);
        gbc.gridx = 1;
        panel.add(txtPrecio, gbc);
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(46, 204, 113));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setOpaque(true);
        btnGuardar.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText().trim();
                double precio = Double.parseDouble(txtPrecio.getText().trim());
                
                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Por favor complete todos los campos.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                productos.add(new Producto(nombre, precio));
                inventario.setCantidadProductos(inventario.getCantidadProductos() + 1);
                JOptionPane.showMessageDialog(dialog, "Producto registrado exitosamente.", 
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "El precio debe ser un número válido.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(231, 76, 60));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setOpaque(true);
        btnCancelar.addActionListener(e -> dialog.dispose());
        
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        
        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(panelBotones, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    
    private void registrarSucursal() {
        JDialog dialog = new JDialog(this, "Registrar Sucursal", true);
        dialog.setSize(450, 200);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout(10, 10));
        dialog.getContentPane().setBackground(new Color(245, 245, 250));
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        JTextField txtCiudad = new JTextField(20);
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Ciudad:"), gbc);
        gbc.gridx = 1;
        panel.add(txtCiudad, gbc);
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(46, 204, 113));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setOpaque(true);
        btnGuardar.addActionListener(e -> {
            String ciudad = txtCiudad.getText().trim();
            
            if (ciudad.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Por favor complete todos los campos.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            sucursales.add(new Sucursal(ciudad));
            JOptionPane.showMessageDialog(dialog, "Sucursal registrada exitosamente.", 
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(231, 76, 60));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setOpaque(true);
        btnCancelar.addActionListener(e -> dialog.dispose());
        
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        
        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(panelBotones, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    
    private void registrarRegion() {
        JDialog dialog = new JDialog(this, "Registrar Región", true);
        dialog.setSize(450, 200);
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
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nombre de la Región:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNombre, gbc);
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(46, 204, 113));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setOpaque(true);
        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Por favor complete todos los campos.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            regiones.add(new Region(nombre));
            JOptionPane.showMessageDialog(dialog, "Región registrada exitosamente.", 
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(231, 76, 60));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setOpaque(true);
        btnCancelar.addActionListener(e -> dialog.dispose());
        
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        
        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(panelBotones, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    
    private void mostrarProductos() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== PRODUCTOS REGISTRADOS ===\n\n");
        
        if (productos.isEmpty()) {
            sb.append("No hay productos registrados.\n");
        } else {
            for (Producto producto : productos) {
                sb.append("Producto: ")
                  .append(producto.getNombre()).append(" | Precio: $")
                  .append(String.format("%.2f", producto.getPrecio())).append("\n");
            }
        }
        
        areaResultados.setText(sb.toString());
    }
    
    private void mostrarInventario() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== INVENTARIO ===\n\n");
        sb.append("Cantidad de productos disponibles: ")
          .append(inventario.getCantidadProductos()).append("\n\n");
        
        if (productos.isEmpty()) {
            sb.append("No hay productos en el inventario.\n");
        } else {
            sb.append("Detalle de productos:\n");
            sb.append("-".repeat(50)).append("\n");
            for (Producto producto : productos) {
                sb.append("• ").append(producto.getNombre())
                  .append(" - $").append(String.format("%.2f", producto.getPrecio())).append("\n");
            }
        }
        
        areaResultados.setText(sb.toString());
    }
    
    private void mostrarSucursales() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== SUCURSALES REGISTRADAS ===\n\n");
        
        if (sucursales.isEmpty()) {
            sb.append("No hay sucursales registradas.\n");
        } else {
            for (int i = 0; i < sucursales.size(); i++) {
                Sucursal sucursal = sucursales.get(i);
                sb.append((i + 1)).append(". Sucursal ubicada en: ")
                  .append(sucursal.getCiudad()).append("\n");
            }
        }
        
        areaResultados.setText(sb.toString());
    }
    
    private void mostrarRegiones() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== REGIONES REGISTRADAS ===\n\n");
        
        if (regiones.isEmpty()) {
            sb.append("No hay regiones registradas.\n");
        } else {
            for (int i = 0; i < regiones.size(); i++) {
                Region region = regiones.get(i);
                sb.append((i + 1)).append(". Región: ")
                  .append(region.getNombre()).append("\n");
            }
        }
        
        areaResultados.setText(sb.toString());
    }
    
    private void mostrarReporteFinanciero() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== REPORTE FINANCIERO ===\n\n");
        
        // Calcular nómina total (suma de todos los salarios)
        double totalNomina = 0;
        for (Empleado emp : empleados) {
            totalNomina += emp.getSalario();
        }
        
        // Calcular ingresos totales (suma de precios de productos)
        double totalIngresos = 0;
        for (Producto producto : productos) {
            totalIngresos += producto.getPrecio();
        }
        
        // Crear reporte financiero
        ReporteFinanciero reporte = new ReporteFinanciero(totalIngresos, totalNomina);
        double balance = reporte.getBalance();
        
        sb.append("RESUMEN FINANCIERO\n");
        sb.append("=".repeat(50)).append("\n\n");
        sb.append("INGRESOS (Ventas de Productos):\n");
        sb.append("  Total: $").append(String.format("%.2f", totalIngresos)).append("\n\n");
        sb.append("EGRESOS (Nómina de Empleados):\n");
        sb.append("  Total: $").append(String.format("%.2f", totalNomina)).append("\n\n");
        sb.append("BALANCE:\n");
        if (balance >= 0) {
            sb.append("  Ganancia: $").append(String.format("%.2f", balance)).append("\n");
        } else {
            sb.append("  Pérdida: $").append(String.format("%.2f", Math.abs(balance))).append("\n");
        }
        sb.append("\n").append("=".repeat(50)).append("\n\n");
        
        sb.append("DETALLE DE NÓMINA:\n");
        if (empleados.isEmpty()) {
            sb.append("  No hay empleados registrados.\n");
        } else {
            for (Empleado emp : empleados) {
                String tipo = emp.getClass().getSimpleName();
                String cargo = tipo.toUpperCase();
                if (tipo.equals("EmpleadoOperativo")) {
                    cargo = "OPERATIVO";
                }
                sb.append("  [").append(cargo).append("] ")
                  .append(emp.getNombre()).append(": $")
                  .append(String.format("%.2f", emp.getSalario())).append("\n");
            }
        }
        
        sb.append("\nDETALLE DE PRODUCTOS:\n");
        if (productos.isEmpty()) {
            sb.append("  No hay productos registrados.\n");
        } else {
            for (Producto producto : productos) {
                sb.append("  • ").append(producto.getNombre()).append(": $")
                  .append(String.format("%.2f", producto.getPrecio())).append("\n");
            }
        }
        
        areaResultados.setText(sb.toString());
    }
    
    public static void main(String[] args) {
        // Configurar Look and Feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
