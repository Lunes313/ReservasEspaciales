public class Usuario {

    //Atributos de usuario
    private String nombre;
    private String correo;
    private String telefono;

    private String preferencias;

    //Constructor
    public Usuario(String nombre, String correo, String telefono, String preferencias) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.preferencias = preferencias;
    }

    //Métodos de usuario
    public void reservar() {
        System.out.println("Reserva realizada");
    }


    public void cancelarReserva() {
        System.out.println("Reserva cancelada");
    }


    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
