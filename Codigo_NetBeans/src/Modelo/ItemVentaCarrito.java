package Modelo;

import java.util.ArrayList;

/**
 * Representa un producto dentro del carrito de compra.
 */
public class ItemVentaCarrito {
    
    private String nombreProducto;   
    private int cantidad;            
    private double precioUnitario;   
    private double subtotal;         

    public ItemVentaCarrito() {
    }

    public ItemVentaCarrito(String nombreProducto, int cantidad, double precioUnitario) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = cantidad * precioUnitario;
    }

    // Datos iniciales de productos disponibles en el minimarket
    public static ArrayList<ItemVentaCarrito> obtenerProductosDisponibles() {
        ArrayList<ItemVentaCarrito> lista = new ArrayList<>();
        lista.add(new ItemVentaCarrito("Arroz Costeño 1kg", 1, 4.80));
        lista.add(new ItemVentaCarrito("Azúcar Rubia 1kg", 1, 3.50));
        lista.add(new ItemVentaCarrito("Aceite Primor 1L", 1, 8.50));
        lista.add(new ItemVentaCarrito("Leche Gloria Azul 400g", 1, 4.20));
        lista.add(new ItemVentaCarrito("Fideos Don Vittorio 500g", 1, 2.80));
        lista.add(new ItemVentaCarrito("Atún Florida 170g", 1, 5.50));
        lista.add(new ItemVentaCarrito("Galletas Casino Paquete", 1, 1.20));
        lista.add(new ItemVentaCarrito("Gaseosa Inka Kola 500ml", 1, 3.00));
        return lista;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.subtotal = cantidad * this.precioUnitario;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
        this.subtotal = this.cantidad * precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return nombreProducto + " (S/ " + String.format("%.2f", precioUnitario) + ")";
    }
}
