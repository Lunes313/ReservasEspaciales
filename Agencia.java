import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {

    // Atributos estáticos
    private static ArrayList<Destino> destinos = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    // Colores
    public static String RESET = "\033[0m";
    public static String CYAN = "\033[0;36m";
    public static String YELLOW = "\033[0;33m";
    public static String RED = "\033[0;31m";
    public static String GREEN = "\033[0;32m";
    public static String BLUE = "\033[0;34m";

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Cargar datos de archivos
        cargarUsuarios();
        cargarDestinos();
        cargarReservas();

        // Dibujo de estrellas para el inicio del programa
        String stars = "   .   ,      .      ✨ .   .         🌟 .  .  \n" +
                "       .      .  . .  *  .      .   \n" +
                "  .    ✨ .    ⭐    .  .   '  .    ⭐  .  ' \n" +
                "   ,  ⭐ *    . .   .  *   .  .    .    *   \n" +
                "   .  .  .  .     *   *  . ✨  * \n" +
                "   .    .  .  .   . 🌟.   .  . *   .      . \n"+
                "   *   ⭐    .  🌟      ,   .    ⭐  .   ✨  .     \n" +
                "   ✨        *       ⭐     ,   *      ✨     \n";

        System.out.println(YELLOW + stars + RESET);
        System.out.println(GREEN + "¡Listo para explorar el espacio! \uD83D\uDC7D" + RESET);
        menu();
    }

    public static void menu() {
        // Menú principal
        System.out.println(CYAN + "Menú principal" + RESET);
        System.out.println("1. Registrarse");
        System.out.println("2. Reservar destino");
        System.out.println("3. Ver destinos disponibles");
        System.out.println("4. Ver destinos");
        System.out.println("5. Ver reservas");
        System.out.println("6. Ver usuarios");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opción: ");

        try {
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    registrarse();
                    break;
                case 2:
                    reservarDestino();
                    break;
                case 3:
                    verDestinosDisponibles();
                    break;
                case 4:
                    verDestinos();
                    break;
                case 5:
                    verReservas();
                    break;
                case 6:
                    verUsuarios();
                    break;
                case 7:
                    System.out.println(GREEN + "¡Hasta luego!" + RESET);
                    break;
                default:
                    System.out.println(RED + "Opción no válida" + RESET);
                    menu();
            }
        } catch (Exception e) {
            System.out.println(RED + "Opción no válida" + RESET);
            sc.nextLine();
            menu();
        }
    }


    public static void registrarse() {
        System.out.println(CYAN + "Registrarse" + RESET);
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Preferencias: ");
        String preferencias = sc.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = sc.nextLine();
        int id = usuarios.size() + 1;

        Usuario nuevoUsuario = new Usuario(nombre, correo, preferencias, contrasena);
        usuarios.add(nuevoUsuario);
        guardarUsuarios();

        System.out.println(GREEN + "¡Usuario registrado con éxito!" + RESET);
        menu();
    }

    public static void reservarDestino() {
        System.out.println(CYAN + "Reservar destino" + RESET);
        System.out.print("Nombre del destino: ");
        String nombre = sc.nextLine();
        System.out.print("Fecha: ");
        String fecha = sc.nextLine();
        System.out.print("Tipo de boleto: ");
        String tipoBoleto = sc.nextLine();

        for (Destino destino : destinos) {
            if (destino.getNombre().equals(nombre)) {
                if (!destino.getDisponibilidad()) {
                    System.out.println(RED + "El destino no está disponible para reserva." + RESET);
                    menu();
                    return;
                }
                Reserva nuevaReserva = new Reserva(destino, fecha, tipoBoleto);
                reservas.add(nuevaReserva);
                destino.setDisponibilidad(false);
                guardarReservas();
                System.out.println(GREEN + "¡Reserva realizada con éxito!" + RESET);
                menu();
                return;
            }
        }
        System.out.println(RED + "Destino no encontrado" + RESET);
        menu();
    }

    public static void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 5) {
                    usuarios.add(new Usuario(partes[0], partes[1], partes[2], partes[3]));
                } else {
                    System.out.println(RED + "Formato incorrecto en una línea de usuarios: " + linea + RESET);
                }
            }
        } catch (IOException e) {
            System.out.println(RED + "Error al cargar los usuarios" + RESET);
        }
    }


    public static void guardarUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.txt"))) {
            for (Usuario usuario : usuarios) {
                bw.write(usuario.getNombre() + ";" + usuario.getCorreo() + ";" + usuario.getPreferencias() + ";" + usuario.getContrasena());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(RED + "Error al guardar los usuarios" + RESET);
        }
    }

    public static void cargarDestinos() {
        try (BufferedReader br = new BufferedReader(new FileReader("destinos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                    destinos.add(new Destino(partes[0], partes[1], Double.parseDouble(partes[2]), Boolean.parseBoolean(partes[3]), partes[4], Integer.parseInt(partes[5])));
            }
        } catch (IOException e) {
            System.out.println(RED + "Error al cargar los destinos" + RESET);
        }
    }


    public static void guardarReservas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("reservas.txt"))) {
            for (Reserva reserva : reservas) {
                bw.write(reserva.getDestino().getNombre() + ";" + reserva.getDestino().getCosto() + ";" + reserva.getDestino().getDisponibilidad() + ";" + reserva.getFecha() + ";" + reserva.getTipoBoleto());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(RED + "Error al guardar las reservas" + RESET);
        }
    }

    public static void verDestinosDisponibles() {
        System.out.println(CYAN + "Destinos disponibles" + RESET);
        for (Destino destino : destinos) {
            if (destino.getDisponibilidad()) {
                System.out.println("Nombre: " + destino.getNombre());
                System.out.println("Descripción: " + destino.getDescripcion());
                System.out.println("Costo: " + destino.getCosto());
                System.out.println("Disponibilidad: " + destino.getDisponibilidad());
                System.out.println("Recomendaciones: " + destino.getRecomendaciones());
                System.out.println("Equipo necesario: " + destino.getEquipoNecesario());
                System.out.println();
            }
        }
        menu();
    }

    public static void verDestinos() {
        System.out.println(CYAN + "Destinos" + RESET);
        for (Destino destino : destinos) {
            System.out.println("Nombre: " + destino.getNombre());
            System.out.println("Descripción: " + destino.getDescripcion());
            System.out.println("Costo: " + destino.getCosto());
            System.out.println("Disponibilidad: " + destino.getDisponibilidad());
            System.out.println("Recomendaciones: " + destino.getRecomendaciones());
            System.out.println("Equipo necesario: " + destino.getEquipoNecesario());
            System.out.println();
        }
        menu();
    }

    public static void verReservas() {
        System.out.println(CYAN + "Reservas" + RESET);
        for (Reserva reserva : reservas) {
            System.out.println("Destino: " + reserva.getDestino().getNombre());
            System.out.println("Fecha: " + reserva.getFecha());
            System.out.println("Tipo de boleto: " + reserva.getTipoBoleto());
            System.out.println();
        }
        menu();
    }

    public static void verUsuarios() {
        System.out.println(CYAN + "Usuarios" + RESET);
        for (Usuario usuario : usuarios) {
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Correo: " + usuario.getCorreo());
            System.out.println("Preferencias: " + usuario.getPreferencias());
            System.out.println("Contraseña: " + usuario.getContrasena());
            System.out.println();
        }
        menu();
    }

    public static void cargarReservas() {
        try (BufferedReader br = new BufferedReader(new FileReader("reservas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                for (Destino destino : destinos) {
                    if (destino.getNombre().equals(partes[0])) {
                        reservas.add(new Reserva(destino, partes[3], partes[4]));
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(RED + "Error al cargar las reservas" + RESET);
        }
    }

}

