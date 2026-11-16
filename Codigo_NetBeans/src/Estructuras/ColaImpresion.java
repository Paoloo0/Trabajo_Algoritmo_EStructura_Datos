package Estructuras;

import Modelo.ComprobantePago;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * - RF6 (Create): Emitir comprobante de pago con correlativo único oficial (offer / poll).
 */
public class ColaImpresion {

    private Queue<ComprobantePago> cola;
    private HashMap<String, ComprobantePago> registro;

    public ColaImpresion() {
        this.cola = new LinkedList<>();
        this.registro = new HashMap<>();
    }

    // Encola el comprobante para emitirlo y lo guarda en el registro
    public void encolar(ComprobantePago comprobante) {
        if (comprobante != null) {
            cola.offer(comprobante);
            registro.put(comprobante.getNumeroComprobante(), comprobante);
        }
    }

    // Desencola el siguiente comprobante listo para imprimir
    public ComprobantePago procesarSiguiente() {
        return cola.poll();
    }

    // Busca un comprobante emitido por su numero de boleta (ej. B001-000001)
    public ComprobantePago buscarPorNumero(String numero) {
        return registro.get(numero);
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
