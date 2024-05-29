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

}
