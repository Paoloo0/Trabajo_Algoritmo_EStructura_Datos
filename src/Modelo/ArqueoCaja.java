package Modelo;

import java.util.HashMap;

/**
 * RF6 (Read): Entidad que encapsula los atributos del cierre de turno y arqueo de caja,
 * utilizando HashMap<String, Double> como estructura de datos de acumulación por modalidad de pago.
 */
public class ArqueoCaja {

    private String fechaHora;
    private int totalBoletas;
    private HashMap<String, Double> totalesPorMetodo;

    public ArqueoCaja() {
        this.totalesPorMetodo = new HashMap<>();
    }

    public ArqueoCaja(String fechaHora, int totalBoletas, HashMap<String, Double> totalesPorMetodo) {
        this.fechaHora = fechaHora;
        this.totalBoletas = totalBoletas;
        this.totalesPorMetodo = (totalesPorMetodo != null) ? totalesPorMetodo : new HashMap<>();
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getTotalBoletas() {
        return totalBoletas;
    }

    public void setTotalBoletas(int totalBoletas) {
        this.totalBoletas = totalBoletas;
    }

    public HashMap<String, Double> getTotalesPorMetodo() {
        return totalesPorMetodo;
    }

    public void setTotalesPorMetodo(HashMap<String, Double> totalesPorMetodo) {
        this.totalesPorMetodo = totalesPorMetodo;
    }

    public double getTotalEfectivo() {
        return (totalesPorMetodo != null) ? totalesPorMetodo.getOrDefault("Efectivo", 0.0) : 0.0;
    }

    public double getTotalDigital() {
        return (totalesPorMetodo != null) ? totalesPorMetodo.getOrDefault("Digital", 0.0) : 0.0;
    }

    public double getBalanceTotal() {
        return (totalesPorMetodo != null) ? totalesPorMetodo.getOrDefault("Total", 0.0) : 0.0;
    }

    public String generarReporteCierre() {
        return "Fecha: " + fechaHora + " | Boletas: " + totalBoletas + " | Balance Total: S/ " + getBalanceTotal();
    }
}
