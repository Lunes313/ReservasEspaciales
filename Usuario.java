public class Usuario {
    private String nombre;
    private String correo;
    private String preferencias;
    private String contrasena;


    //constructor
    public Usuario(String nombre, String correo, String preferencias, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.preferencias = preferencias;
        this.contrasena = contrasena;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
