public class Planeta{

    private String nombre;
    private int costo; 
    private boolean disponibilidad; 
    private String itinerario;
    private String equipo;
    private String tipo;


    public Destino(String nombre, int costo, boolean disponibilidad,String itinerario, String equipo,String tipo) {
        this.nombre = nombre;
        this.costo = costo;
        this.disponibilidad=disponibilidad; 
        this.itinerario=itinerario; 
        this.equipo=equipo; 
        this.tipo=tipo; 
    
    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public int getCosto() {
        return costo;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public String getItinerario() {
        return usuario;
    }
    public String getEquipo() {
        return nombre;
    }
    public String getTipo() {
        return nombre;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

     public void setTipo(String tipo) {
        this.tipo = tipo;
    }



}

}
