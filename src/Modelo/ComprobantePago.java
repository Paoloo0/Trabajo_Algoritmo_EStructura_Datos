package Modelo;

import java.util.ArrayList;

/**
 * Representa el comprobante de pago (boleta de venta) emitido en caja.
 */
public class ComprobantePago {
    
    private String numeroComprobante;
    private String fechaHora;
    private String metodoPago; 
    private double total;
    private double montoRecibido;
    private double vuelto;
    private ArrayList<ItemVentaCarrito> items;

    public ComprobantePago() {
        this.items = new ArrayList<>();
    }

    public ComprobantePago(String numeroComprobante, String fechaHora, String metodoPago, 
                           double total, double montoRecibido, double vuelto, 
                           ArrayList<ItemVentaCarrito> items) {
        this.numeroComprobante = numeroComprobante;
        this.fechaHora = fechaHora;
        this.metodoPago = metodoPago;
        this.total = total;
        this.montoRecibido = montoRecibido;
        this.vuelto = vuelto;
        this.items = items;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPagar() {
        return total;
    }

    public void setTotalPagar(double totalPagar) {
        this.total = totalPagar;
    }

    public double getMontoRecibido() {
        return montoRecibido;
    }

    public void setMontoRecibido(double montoRecibido) {
        this.montoRecibido = montoRecibido;
    }

    public double getVuelto() {
        return vuelto;
    }

    public void setVuelto(double vuelto) {
        this.vuelto = vuelto;
    }

    public ArrayList<ItemVentaCarrito> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemVentaCarrito> items) {
        this.items = items;
    }

    // Genera el texto formateado tipo ticket termico para la boleta
    public String generarBoleta() {
        StringBuilder sb = new StringBuilder();
        sb.append("=========================================\n");
        sb.append("          MINIMARKET EL AHORRO           \n");
        sb.append("       RUC: 20601234567 - LIMA, PERU      \n");
        sb.append("   COMPROBANTE DE PAGO ELECTRONICO       \n");
        sb.append("          BOLETA DE VENTA                \n");
        sb.append("=========================================\n");
        sb.append("Nro Comprobante: ").append(numeroComprobante).append("\n");
        sb.append("Fecha y Hora  : ").append(fechaHora).append("\n");
        sb.append("Forma de Pago : ").append(metodoPago).append("\n");
        sb.append("-----------------------------------------\n");
        sb.append(String.format("%-22s %4s %8s\n", "Producto", "Cant", "Subtotal"));
        sb.append("-----------------------------------------\n");
        for (ItemVentaCarrito item : items) {
            String nom = item.getNombreProducto();
            if (nom.length() > 22) {
                nom = nom.substring(0, 19) + "...";
            }
            sb.append(String.format("%-22s %4d  S/ %6.2f\n", nom, item.getCantidad(), item.getSubtotal()));
        }
        sb.append("-----------------------------------------\n");
        sb.append(String.format("TOTAL A PAGAR     : S/ %8.2f\n", total));
        sb.append(String.format("MONTO RECIBIDO    : S/ %8.2f\n", montoRecibido));
        sb.append(String.format("VUELTO ENTREGADO  : S/ %8.2f\n", vuelto));
        sb.append("=========================================\n");
        sb.append("     Boleta emitida con exito!           \n");
        sb.append("          Gracias por su compra!         \n");
        sb.append("=========================================");
        return sb.toString();
    }
}
