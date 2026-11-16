package Modelo;

/**
 * Modelo para las credenciales de acceso del cajero.
 */
public class Usuario {
    
    private String username;
    private String password;
    private String rol;

    public Usuario() {
    }

    public Usuario(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Valida que el usuario y contrasena coincidan con los registrados
    public boolean autenticar(String user, String pass) {
        if (this.username == null || this.password == null) {
            return false;
        }
        return this.username.equals(user) && this.password.equals(pass);
    }
}
