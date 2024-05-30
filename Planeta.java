public class Planeta extends Destino {
    private double tamaño;
    private double distancia;

    public Planeta(String nombre, String descripcion, double costo, boolean disponibilidad, double tamaño, double distancia) {
        super(nombre, descripcion, costo, disponibilidad);
        this.tamaño = tamaño;
        this.distancia = distancia;
    }

    // Getters y setters
    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + tamaño + ";" + distancia;
    }

    public static Planeta fromString(String str) {
        String[] parts = str.split(";");
        Destino destino = Destino.fromString(String.join(";", parts[0], parts[1], parts[2], parts[3]));
        return new Planeta(destino.getNombre(), destino.getDescripcion(), destino.getCosto(), destino.isDisponibilidad(), Double.parseDouble(parts[4]), Double.parseDouble(parts[5]));
    }
}
