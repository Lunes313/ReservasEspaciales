import java.io.*;

public class Reserva {
        private String fecha;
        private String hora;
        private String tipoBoleto;
        private Destino destino;
        private Usuario usuario;


    public Reserva(Destino destino, String fecha, String tipoBoleto) {
        this.destino = destino;
        this.fecha = fecha;
        this.tipoBoleto = tipoBoleto;
        }

        public Destino getDestino() {
            return destino;
        }

        public void setDestino(Destino destino) {
            this.destino = destino;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getTipoBoleto() {
            return tipoBoleto;
        }

        public void setTipoBoleto(String tipoBoleto) {
            this.tipoBoleto = tipoBoleto;
        }

        @Override
        public String toString() {
            return destino.toString() + ";" + fecha + ";" + tipoBoleto;
        }

        public static Reserva fromString(String str) {
            String[] parts = str.split(";");
            Destino destino = (parts.length == 8) ? Planeta.fromString(String.join(";", parts[0], parts[1], parts[2], parts[3], parts[4], parts[5])) : Destino.fromString(String.join(";", parts[0], parts[1], parts[2], parts[3]));
            return new Reserva(destino, parts[parts.length - 2], parts[parts.length - 1]);
        }
}
