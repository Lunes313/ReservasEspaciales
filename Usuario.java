public class Usuario {
    private String nombre;
    private String correo;
    private String preferencias;

    public Usuario(String nombre, String correo, String preferencias) {
        this.nombre = nombre;
        this.correo = correo;
        this.preferencias = preferencias;
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

    @Override
    public String toString() {
        return nombre + ";" + correo + ";" + preferencias;
    }

    public static Usuario fromString(String str) {
        String[] parts = str.split(";");
        return new Usuario(parts[0], parts[1], parts[2]);
    }
}
