package Estructuras;

import Modelo.ComprobantePago;
import Modelo.ItemVentaCarrito;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Carrito {

    private ArrayList<ItemVentaCarrito> items;

    public Carrito() {
        this.items = new ArrayList<>();
    }

    // Busca si un producto ya está en la lista del comprobante por su nombre
    public ItemVentaCarrito buscarPorNombre(String nombre) {
        if (nombre == null) {
            return null;
        }
        for (ItemVentaCarrito item : items) {
            if (item.getNombreProducto().equalsIgnoreCase(nombre)) {
                return item;
            }
        }
        return null;
    }

    // RF2 (Create): Agrega un producto al comprobante (si ya existe, acumula cantidad)
    public void agregar(ItemVentaCarrito nuevo) {
        if (nuevo == null) {
            return;
        }

        ItemVentaCarrito existente = buscarPorNombre(nuevo.getNombreProducto());
        if (existente != null) {
            existente.setCantidad(existente.getCantidad() + nuevo.getCantidad());
        } else {
            items.add(nuevo);
        }
    }

    // RF2 (Update): Modifica la cantidad de unidades de un producto ingresado
    public void modificarCantidad(int indice, int nuevaCantidad) {
        if (indice >= 0 && indice < items.size()) {
            if (nuevaCantidad <= 0) {
                eliminar(indice);
            } else {
                items.get(indice).setCantidad(nuevaCantidad);
            }
        }
    }

    // RF2 (Delete): Elimina un producto por su posición en la tabla del comprobante
    public void eliminar(int indice) {
        if (indice >= 0 && indice < items.size()) {
            items.remove(indice);
        }
    }

    // Calcula el total sumando los subtotales de cada producto
    public double calcularSubtotal() {
        double subtotal = 0.0;
        for (ItemVentaCarrito item : items) {
            subtotal += item.getSubtotal();
        }
        return subtotal;
    }

    // Calcula el vuelto a entregar al cliente
    public double calcularVuelto(double montoRecibido) {
        return montoRecibido - calcularSubtotal();
    }

    // RF3 (Create / Update): Registra la modalidad de pago y el monto recibido (Estructura: HashMap<String, Object>)
    public HashMap<String, Object> registrarPago(String metodoPago, double montoRecibido) {
        double total = calcularSubtotal();
        double vuelto = (metodoPago != null && metodoPago.equalsIgnoreCase("Efectivo")) 
                        ? calcularVuelto(montoRecibido) : 0.0;

        HashMap<String, Object> datosPago = new HashMap<>();
        datosPago.put("modalidad", metodoPago);
        datosPago.put("montoRecibido", montoRecibido);
        datosPago.put("totalPagar", total);
        datosPago.put("vuelto", vuelto);
        return datosPago;
    }

    // RF4 (Create): Genera el comprobante de pago oficial con los productos actuales del comprobante
    public ComprobantePago generarComprobante(String numero, String metodoPago, double recibido, double vuelto) {
        String fechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        double total = calcularSubtotal();
        return new ComprobantePago(
            numero, 
            fechaHora, 
            metodoPago, 
            total, 
            recibido, 
            vuelto, 
            new ArrayList<>(items)
        );
    }

    // Limpia los productos al cancelar la venta o al finalizar
    public void vaciar() {
        items.clear();
    }

    public boolean estaVacio() {
        return items.isEmpty();
    }

    public ArrayList<ItemVentaCarrito> getItems() {
        return items;
    }
}
