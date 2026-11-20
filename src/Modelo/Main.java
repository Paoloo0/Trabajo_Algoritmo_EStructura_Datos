package Modelo;

import Visual.Login;

/**
 * Punto de entrada principal del sistema de Minimarket El Ahorro.
 */
public class Main {

    public static void main(String[] args) {
        // Inicia el sistema mostrando la ventana de autenticacion (Login)
        Login login = new Login();
        login.setVisible(true);
    }
}
