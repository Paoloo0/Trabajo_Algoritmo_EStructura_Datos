package Estructuras;

import Modelo.ComprobantePago;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * RF4 (Create): Buffer y Cola de Impresion FIFO (Queue<ComprobantePago>).
 * RF5 (Read): Registro indexado en tiempo O(1) con HashMap<String, ComprobantePago>.
 * RF6 (Read): Consolidacion de cierre de turno y arqueo de caja.
 */
public class ColaImpresion {

    private static ColaImpresion instancia;

    public static synchronized ColaImpresion getInstancia() {
        if (instancia == null) {
            instancia = new ColaImpresion();
        }
        return instancia;
    }

    private Queue<ComprobantePago> cola;
    private HashMap<String, ComprobantePago> registro;

    public ColaImpresion() {
        this.cola = new LinkedList<>();
        this.registro = new HashMap<>();
    }

    // RF4: Encola el comprobante en orden FIFO y lo indexa por su correlativo
    public void encolar(ComprobantePago comprobante) {
        if (comprobante != null) {
            cola.offer(comprobante);
            registro.put(comprobante.getNumeroComprobante(), comprobante);
        }
    }

    // RF4: Desencola el siguiente comprobante listo para imprimir
    public ComprobantePago procesarSiguiente() {
        return cola.poll();
    }

    // RF5: Búsqueda indexada en O(1) por número de boleta (ej. B001-000001)
    public ComprobantePago buscarPorNumero(String numero) {
        if (numero == null) return null;
        return registro.get(numero.trim());
    }

    // RF5: Lista completa de comprobantes emitidos en el turno
    public ArrayList<ComprobantePago> obtenerTodos() {
        return new ArrayList<>(registro.values());
    }

    // RF6: Consolidación del arqueo de caja mediante HashMap<String, Double>
    // Estructura de Datos: Tabla Hash de Acumulación por Medio de Pago (O(1) por inserción/acumulación)
    public HashMap<String, Double> consolidarArqueoPorMetodo() {
        HashMap<String, Double> balanceArqueo = new HashMap<>();
        balanceArqueo.put("Efectivo", 0.0);
        balanceArqueo.put("Digital", 0.0);
        for (ComprobantePago c : registro.values()) {
            if ("Efectivo".equalsIgnoreCase(c.getMetodoPago())) {
                balanceArqueo.put("Efectivo", balanceArqueo.get("Efectivo") + c.getTotal());
            } else {
                balanceArqueo.put("Digital", balanceArqueo.get("Digital") + c.getTotal());
            }
        }
        balanceArqueo.put("Total", balanceArqueo.get("Efectivo") + balanceArqueo.get("Digital"));
        return balanceArqueo;
    }

    // RF6: Total recaudado en efectivo
    public double calcularTotalEfectivo() {
        return consolidarArqueoPorMetodo().get("Efectivo");
    }

    // RF6: Total recaudado en billeteras digitales
    public double calcularTotalDigital() {
        return consolidarArqueoPorMetodo().get("Digital");
    }

    // RF6: Gran total de ingresos del turno
    public double calcularGranTotal() {
        return consolidarArqueoPorMetodo().get("Total");
    }

    public int totalComprobantesEmitidos() {
        return registro.size();
    }

    public ComprobantePago verProximo() {
        return cola.peek();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public int cantidadPendiente() {
        return cola.size();
    }

    public HashMap<String, ComprobantePago> getRegistro() {
        return registro;
    }
}
