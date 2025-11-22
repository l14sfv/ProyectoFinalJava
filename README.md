# TECHSOLUTIONS - Sistema de Gestión Empresarial

**TECHSOLUTIONS** es una aplicación de escritorio desarrollada en Java con interfaz gráfica usando **Swing**. Está diseñada para gestionar información completa de una empresa, incluyendo empleados, clientes, proveedores, productos, inventario, sucursales y regiones, con fundamentos sólidos de **Programación Orientada a Objetos (POO)**.

## 🧠 Características del proyecto

### Gestión de Personal
- **Registro y visualización de empleados** con distintos cargos:
  - Presidente
  - Director
  - Gerente
  - Coordinador
  - Empleado Operativo
- Visualización de información completa: nombre, ID y salario

### Gestión de Clientes y Proveedores
- Registro de clientes con información de contacto (email)
- Registro de proveedores con productos que suministran
- Visualización completa de registros

### Gestión de Productos e Inventario
- Registro de productos con nombre y precio
- Control de inventario automático
- Visualización de productos disponibles

### Gestión de Ubicaciones
- Registro de sucursales por ciudad
- Registro de regiones
- Visualización de ubicaciones

### Reportes Financieros
- **Reporte financiero completo** que incluye:
  - Ingresos totales (ventas de productos)
  - Egresos totales (nómina de empleados)
  - Balance (ganancia o pérdida)
  - Detalle de nómina por empleado
  - Detalle de productos con precios

### Interfaz Gráfica
- Interfaz gráfica moderna y amigable
- Diálogos modales para registro de datos
- Área de resultados con scroll
- Botones estilizados con colores diferenciados
- Validación de campos en tiempo real
- Mensajes de confirmación y error

### Principios POO Aplicados
- ✅ **Herencia**: Clases empleado heredan de `Empleado`, que hereda de `ActorEmpresa`
- ✅ **Abstracción**: Clases abstractas `ActorEmpresa` y `Empleado`
- ✅ **Polimorfismo**: Métodos `mostrarResumen()` y `realizarTarea()` implementados diferentemente
- ✅ **Encapsulamiento**: Atributos privados con métodos getter y setter

## 📂 Estructura del Proyecto

```
TECHSOLUTIONS/
├── src/
│   └── techsolutions/
│       ├── Main.java                    # Clase principal con interfaz gráfica
│       ├── ActorEmpresa.java            # Clase abstracta base
│       ├── Empleado.java                # Clase abstracta de empleados
│       ├── Presidente.java              # Clase de presidente
│       ├── Director.java                # Clase de director
│       ├── Gerente.java                 # Clase de gerente
│       ├── Coordinador.java             # Clase de coordinador
│       ├── EmpleadoOperativo.java       # Clase de empleado operativo
│       ├── Cliente.java                 # Clase de cliente
│       ├── Proveedor.java               # Clase de proveedor
│       ├── Producto.java                # Clase de producto
│       ├── Inventario.java              # Clase de inventario
│       ├── Nomina.java                   # Clase de nómina
│       ├── ReporteFinanciero.java       # Clase de reporte financiero
│       ├── Sucursal.java                # Clase de sucursal
│       ├── Region.java                  # Clase de región
│       ├── Departamento.java            # Clase de departamento
│       ├── Proyecto.java                # Clase de proyecto
│       ├── Contrato.java                # Clase de contrato
│       ├── Factura.java                 # Clase de factura
│       └── Oficina.java                # Clase de oficina
├── bin/                                 # Archivos compilados (.class)
└── README.md                           # Este archivo
```

## 🛠️ Tecnologías usadas

- **Java 11+** (compatible con Java 8+)
- **Swing** para la interfaz gráfica de usuario (GUI)
- **IDE sugerido**: IntelliJ IDEA, Eclipse o VS Code

## 🚀 Cómo ejecutar el proyecto

### Opción 1: Desde la línea de comandos

1. **Compilar el proyecto:**
   ```bash
   javac -d bin src/techsolutions/*.java
   ```
   git clone https://github.com/l14sfv/ProyectoFinalJava.git
2. Abre el proyecto con tu IDE favorito.

2. **Ejecutar la aplicación:**
   ```bash
   java -cp bin techsolutions.Main
   ```

<<<<<<< HEAD
### Opción 2: Desde un IDE

1. Abre el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, NetBeans, VS Code)
2. Asegúrate de que el directorio `src` esté marcado como carpeta de fuentes
3. Ejecuta la clase `techsolutions.Main`

### Requisitos

- Java JDK 8 o superior instalado
- Sistema operativo: Windows, Linux o macOS

## 📋 Funcionalidades de la Interfaz

### Menú Principal

La aplicación cuenta con los siguientes botones:

**Registros:**
- 🔵 Registrar Empleado
- 🟢 Registrar Cliente
- 🟣 Registrar Proveedor
- 🔷 Registrar Producto
- 🟪 Registrar Sucursal
- 🟩 Registrar Región

**Visualización:**
- 🟡 Ver Empleados
- 🟠 Ver Clientes
- 🔴 Ver Proveedores
- ⚫ Ver Productos
- ⚪ Ver Inventario
- 🔴 Ver Sucursales
- ⚪ Ver Regiones
- 🟠 Reporte Financiero

### Características de los Diálogos

- **Validación de campos**: Los campos requeridos deben completarse
- **Validación de números**: Los campos numéricos (salario, precio) validan formato
- **Mensajes informativos**: Confirmación al guardar exitosamente
- **Mensajes de error**: Alertas cuando hay problemas con los datos

## 📊 Ejemplo de Uso

1. **Registrar un empleado:**
   - Click en "Registrar Empleado"
   - Completa: Nombre, ID, Cargo (selecciona del dropdown), Salario
   - Click en "Guardar"

2. **Registrar un producto:**
   - Click en "Registrar Producto"
   - Completa: Nombre, Precio
   - Click en "Guardar"
   - El inventario se actualiza automáticamente

3. **Ver reporte financiero:**
   - Click en "Reporte Financiero"
   - Se muestra un resumen completo con ingresos, egresos y balance

## 🎨 Diseño de la Interfaz

- **Tema moderno** con colores diferenciados por tipo de operación
- **Área de resultados** con scroll para visualizar información extensa

## 📝 Notas

- Los datos se almacenan en memoria durante la ejecución (no se persisten en archivos)
- El inventario se actualiza automáticamente al registrar productos
- El reporte financiero calcula ingresos y egresos en tiempo real

## 👨‍💻 Desarrollo

Desarrollado como proyecto académico para demostrar conocimientos de:
- Java y Programación Orientada a Objetos (POO)
- Interfaz gráfica con Swing
- Diseño de software con principios SOLID
- Arquitectura de clases bien estructurada

---

**TECHSOLUTIONS** - Sistema de Gestión Empresarial
=======
Desarrollado como proyecto académico para demostrar conocimientos de Java y Programación Orientada a Objetos (POO).
