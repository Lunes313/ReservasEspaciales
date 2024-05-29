public class Reserva {

    //Atributos de reserva
    private String fecha;
    private String hora;
    private Destino destino;
    private Usuario usuario;


    //Constructor
    public Reserva(String fecha, String hora, Destino destino, Usuario usuario) {
        this.fecha = fecha;
        this.hora = hora;
        this.destino = destino;
        this.usuario = usuario;
    }

    //Métodos de reserva
    public void mostrarReserva() {
        System.out.println("Reserva:");
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
        System.out.println("Destino: " + destino.getNombre());
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("Teléfono: " + usuario.getTelefono());
    }

    //Getters y setters
    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public Destino getDestino() {
        return destino;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}
