package Modelo;

/**
 * RF3 (Create / Update): Entidad que encapsula los atributos de la liquidación de cobro.
 */
public class Pago {

    private String metodoPago;
    private double montoRecibido;
    private double totalPagar;
    private double vuelto;

    public Pago() {
    }

    public Pago(String metodoPago, double montoRecibido, double totalPagar, double vuelto) {
        this.metodoPago = metodoPago;
        this.montoRecibido = montoRecibido;
        this.totalPagar = totalPagar;
        this.vuelto = vuelto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getMontoRecibido() {
        return montoRecibido;
    }

    public void setMontoRecibido(double montoRecibido) {
        this.montoRecibido = montoRecibido;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public double getVuelto() {
        return vuelto;
    }

    public void setVuelto(double vuelto) {
        this.vuelto = vuelto;
    }

    public void registrarPago(String metodo, double recibido, double total) {
        this.metodoPago = metodo;
        this.montoRecibido = recibido;
        this.totalPagar = total;
        this.vuelto = (recibido > total) ? (recibido - total) : 0.0;
    }
}
