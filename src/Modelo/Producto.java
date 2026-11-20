package Modelo;

import java.util.ArrayList;

/**
 * RF2 (Read): Entidad del catálogo de productos y precios disponibles para consulta en caja.
 */
public class Producto {

    private String codigo;
    private String nombre;
    private double precioUnitario;
    private String categoria;

    public Producto() {
    }

    public Producto(String codigo, String nombre, double precioUnitario, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.categoria = categoria;
    }

    // Catálogo oficial de productos para consulta en el proceso de emisión
    public static ArrayList<Producto> obtenerCatalogo() {
        ArrayList<Producto> lista = new ArrayList<>();
        lista.add(new Producto("PROD-001", "Arroz Costeño 1kg", 4.80, "Abarrotes"));
        lista.add(new Producto("PROD-002", "Azúcar Rubia 1kg", 3.50, "Abarrotes"));
        lista.add(new Producto("PROD-003", "Aceite Primor 1L", 8.50, "Abarrotes"));
        lista.add(new Producto("PROD-004", "Leche Gloria Azul 400g", 4.20, "Lácteos"));
        lista.add(new Producto("PROD-005", "Fideos Don Vittorio 500g", 2.80, "Abarrotes"));
        lista.add(new Producto("PROD-006", "Atún Florida 170g", 5.50, "Conservas"));
        lista.add(new Producto("PROD-007", "Galletas Casino Paquete", 1.20, "Golosinas"));
        lista.add(new Producto("PROD-008", "Gaseosa Inka Kola 500ml", 3.00, "Bebidas"));
        return lista;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " (S/ " + String.format(java.util.Locale.US, "%.2f", precioUnitario) + ")";
    }
}
