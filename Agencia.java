import java.io.*;
import java.util.ArrayList;

public class Agencia {
    private ArrayList<Destino> destinos;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;

    public Agencia() {
        this.destinos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        guardarUsuarios();
    }

    public void agregarDestino(Destino destino) {
        destinos.add(destino);
        guardarDestinos();
    }

    public void realizarReserva(Reserva reserva) {
        reservas.add(reserva);
        guardarReservas();
    }

    public ArrayList<Destino> getDestinosDisponibles() {
        ArrayList<Destino> disponibles = new ArrayList<>();
        for (Destino d : destinos) {
            if (d.isDisponibilidad()) {
                disponibles.add(d);
            }
        }
        return disponibles;
    }

    public void cargarUsuarios() {
        usuarios.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                usuarios.add(Usuario.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDestinos() {
        destinos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("destinos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(";").length == 6) {
                    destinos.add(Planeta.fromString(line));
                } else {
                    destinos.add(Destino.fromString(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarReservas() {
        reservas.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("reservas.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                reservas.add(Reserva.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.txt"))) {
            for (Usuario u : usuarios) {
                bw.write(u.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarDestinos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("destinos.txt"))) {
            for (Destino d : destinos) {
                bw.write(d.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarReservas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("reservas.txt"))) {
            for (Reserva r : reservas) {
                bw.write(r.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
