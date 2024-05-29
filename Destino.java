public class Destino extends Planeta {

    //Atributos de destino
    private Planeta planeta;
    private String recomendaciones;


    //Constructor
    public Destino(String nombre, int costo, boolean disponibilidad,String itinerario, String equipo,String tipo, Planeta planeta, String recomendaciones) {
        super(nombre, costo, disponibilidad, itinerario, equipo, tipo);
        this.planeta = planeta;
        this.recomendaciones = recomendaciones;
    }
}
