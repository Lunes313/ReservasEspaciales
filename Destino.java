
public class Destino {

    //atributos
    private String nombre;
    private String descripcion;
    private double costo;
    private boolean disponibilidad;
    private String recomendaciones;
    private int equipoNecesario;

    //constructor
    public Destino(String nombre, String descripcion, double costo, boolean disponibilidad, String recomendaciones, int equipoNecesario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.disponibilidad = disponibilidad;
        this.recomendaciones = recomendaciones;
        this.equipoNecesario = equipoNecesario;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public int getEquipoNecesario() {

        return equipoNecesario;
    }

    public void setEquipoNecesario(int equipoNecesario) {
        this.equipoNecesario = equipoNecesario;
    }
}
