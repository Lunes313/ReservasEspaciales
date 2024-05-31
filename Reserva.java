import java.io.*;

public class Reserva {
        private String fecha;
        private String tipoBoleto;
        private Destino destino;


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

}
