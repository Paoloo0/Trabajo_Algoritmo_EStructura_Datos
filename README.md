# Minimarket El Ahorro — Sistema de Emisión de Comprobantes de Pago

Proyecto académico de **Algoritmos y Estructuras de Datos** / **Ingeniería de Sistemas**.

---

## 📌 Descripción del Sistema
Sistema de punto de venta (POS) y control de caja para el proceso de **Emisión de Comprobantes de Pago**, desarrollado en **Java (Swing / JFrame)** con **Apache NetBeans**.

### Requisitos Funcionales Implementados:
1. **RF1 - Control de Acceso (Login):** Autenticación de cajeros en tiempo $O(1)$ con `HashMap<String, Usuario>`. Credenciales de prueba: `cajero` / `123`.
2. **RF2 - Mantenimiento del Detalle del Comprobante (CRUD):** Búsqueda interactiva en catálogo (`ArrayList<Producto>`), adición a la canasta (`agregar()`), edición de cantidades en celda (`modificarCantidad()`), retiro de ítems (`eliminar()`) o vaciado de venta (`vaciar()`).
3. **RF3 - Liquidación de Cobro y Vuelto:** Modalidades de pago en Efectivo (cálculo automático de vuelto en tiempo real) y Billeteras Digitales (Yape / Plin).
4. **RF4 - Emisión de Boleta Oficial:** Asignación de serie y número correlativo único (`B001-XXXXXX`) y buffer de impresión secuencial con cola FIFO (`Queue<ComprobantePago>`).
5. **RF5 - Historial y Reimpresión de Comprobantes:** Búsqueda indexada en tiempo $O(1)$ por correlativo mediante `HashMap<String, ComprobantePago>` y visor para reemisión de copias oficiales.
6. **RF6 - Cierre de Turno y Cuadre de Caja (Arqueo):** Consolidación en tiempo $O(1)$ con `HashMap<String, Double>` por modalidad de pago (Efectivo vs Billeteras Digitales) y balance total sin errores manuales.

---

## 🚀 Cómo Abrir y Ejecutar en Apache NetBeans

1. **Requisitos:**
   * Java JDK 17 o superior.
   * Apache NetBeans IDE (versión 12, 17, 18, 19, 20 o superior).

2. **Pasos para Abrir el Proyecto:**
   * En Apache NetBeans, ir al menú: **`File`** -> **`Open Project...`** (o `Archivo` -> `Abrir proyecto...`).
   * Navegar hasta la carpeta donde se descargó o clonó este repositorio.
   * Seleccionar el proyecto (se identificará con el icono de taza de café de NetBeans y el nombre **`Minimarket`**).
   * Hacer clic en **`Open Project`**.

3. **Ejecutar el Proyecto:**
   * Presionar la tecla **`F6`** o hacer clic derecho sobre el proyecto y seleccionar **`Run`** (Ejecutar).
   * La clase principal configurada es: `Modelo.Main` (abre la pantalla de Login).
   * **Credenciales de inicio de sesión:**
     * **Usuario:** `cajero`
     * **Contraseña:** `123`

---

## 📂 Estructura del Proyecto

```text
├── nbproject/                 # Configuración del proyecto Apache NetBeans
│   ├── build-impl.xml
│   ├── genfiles.properties
│   ├── project.properties
│   └── project.xml
├── src/                       # Código fuente organizado en paquetes
│   ├── Estructuras/           # Clases con Estructuras de Datos
│   │   ├── Carrito.java       # ArrayList de ítems y operaciones CRUD
│   │   └── ColaImpresion.java # Queue FIFO y HashMap de comprobantes/arqueo
│   ├── Modelo/                # Entidades de dominio
│   │   ├── ArqueoCaja.java
│   │   ├── ComprobantePago.java
│   │   ├── ItemVentaCarrito.java
│   │   ├── Main.java          # Punto de entrada principal
│   │   ├── Pago.java
│   │   ├── Producto.java
│   │   └── Usuario.java
│   └── Visual/                # Formularios gráficos (JFrame y .form)
│       ├── CierreCaja.java / .form
│       ├── Cobro.java / .form
│       ├── HistorialBoletas.java / .form
│       ├── Login.java / .form
│       ├── Principal.java / .form
│       ├── VentanaEmisionComprobante.java / .form
│       └── VisorBoleta.java / .form
├── build.xml                  # Script de construcción Ant de NetBeans
├── manifest.mf                # Manifiesto de ejecución
├── .gitignore                 # Exclusión de binarios y temporales
└── README.md                  # Guía de apertura y ejecución
```
