import java.io.*;

public class Destino {
    private String nombre;
    private String descripcion;
    private double costo;
    private boolean disponibilidad;

    public Destino(String nombre, String descripcion, double costo, boolean disponibilidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.disponibilidad = disponibilidad;
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

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return nombre + ";" + descripcion + ";" + costo + ";" + disponibilidad;
    }

    public static Destino fromString(String str) {
        String[] parts = str.split(";");
        return new Destino(parts[0], parts[1], Double.parseDouble(parts[2]), Boolean.parseBoolean(parts[3]));
    }
}
