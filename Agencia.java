import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {

    // Atributos estáticos
    private static ArrayList<Destino> destinos = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    // Colores: (estos colores fueron geenerados por inteligencia artificial, pero sus codigos pueden ser encontrados en internet)
    public static String RESET = "\033[0m";
    public static String CYAN = "\033[0;36m";
    public static String YELLOW = "\033[0;33m";
    public static String RED = "\033[0;31m";
    public static String GREEN = "\033[0;32m";
    public static String BLUE = "\033[0;34m";
    public static Scanner sc = new Scanner(System.in);

    // Dibujo de estrellas para el inicio del programa
    public static String stars = "   .   ,      .      ✨ .   .         🌟 .  .  \n" +
            "       .      .  . .  *  .      .   \n" +
            "  .    ✨ .    ⭐    .  .   '  .    ⭐  .  ' \n" +
            "   ,  ⭐ *    . .   .  *   .  .    .    *   \n" +
            "   .  .  .  .     *   *  . ✨  * \n" +
            "   .    .  .  .   . 🌟.   .  . *   .      . \n"+
            "   *   ⭐    .  🌟      ,   .    ⭐  .   ✨  .     \n" +
            "   ✨        *       ⭐     ,   *      ✨     \n";

    public static void main(String[] args) {
        // Cargar datos de archivos
        cargarUsuarios();
        cargarDestinos();
        cargarReservas();



        System.out.println(YELLOW + stars + RESET);
        // Mensaje de bienvenida
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
                    System.out.println(YELLOW + stars + RESET);
                    break;
                default:
                    System.out.println(RED + "Opción no válida" + RESET);
                    menu();
            }
        } catch (Exception e) {
            System.out.println(RED + "no ha ingresado un numero" + RESET);
            sc.nextLine();
            menu();
        }
    }

    // Métodos

    //metodo para registrar un usuario
    public static void registrarse() {
        //se pide al usuario que ingrese sus datos
        System.out.println(CYAN + "Registrarse" + RESET);
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Preferencias: ");
        String preferencias = sc.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = sc.nextLine();

        //se crea un nuevo usuario con los datos ingresados
        Usuario nuevoUsuario = new Usuario(nombre, correo, preferencias, contrasena);
        //se agrega el usuario a la lista de usuarios
        usuarios.add(nuevoUsuario);
        //se guarda la lista de usuarios en el archivo usuarios.txt
        guardarUsuarios();
        //se muestra un mensaje de exito
        System.out.println(GREEN + "¡Usuario registrado con éxito!" + RESET);
        menu();
    }

    //metodo para reservar un destino
    public static void reservarDestino() {
        //se pide al usuario que ingrese los datos del destino que desea reservar
        System.out.println(CYAN + "Reservar destino" + RESET);
        System.out.print("Nombre del destino: ");
        String nombre = sc.nextLine();
        System.out.print("Fecha: ");
        String fecha = sc.nextLine();
        System.out.print("Tipo de boleto: ");
        String tipoBoleto = sc.nextLine();

        //se busca el destino en la lista de destinos
        for (Destino destino : destinos) {
            //si se encuentra el destino
            if (destino.getNombre().equals(nombre)) {
                //se verifica si el destino está disponible
                if (!destino.getDisponibilidad()) {
                    System.out.println(RED + "El destino no está disponible para reserva." + RESET);
                    menu();
                    return;
                }
                //se crea una nueva reserva con los datos ingresados
                Reserva nuevaReserva = new Reserva(destino, fecha, tipoBoleto);
                reservas.add(nuevaReserva);
                destino.setDisponibilidad(false);
                guardarReservas();
                guardarDestinos();
                System.out.println(GREEN + "¡Reserva realizada con éxito!" + RESET);
                menu();
                return;
            }
        }
        //si no se encuentra el destino se muestra un mensaje y se vuelve al menú
        System.out.println(RED + "Destino no encontrado" + RESET);
        menu();
    }

    //metodo para cargar los usuarios
    public static void cargarUsuarios() {
        //se lee el archivo usuarios.txt
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                //se separa cada línea del archivo en partes
                String[] partes = linea.split(";");
                //si la línea tiene 4 partes se añade el usuario a la lista de usuarios
                if (partes.length == 4) {
                    usuarios.add(new Usuario(partes[0], partes[1], partes[2], partes[3]));
                } else {
                    //si la línea no tiene 5 partes se muestra un mensaje de error
                    System.out.println(RED + "Formato incorrecto en una línea de usuarios: " + linea + RESET);
                }
            }
        } catch (IOException e) {
            //si hay un error al leer el archivo se muestra un mensaje de error
            System.out.println(RED + "Error al cargar los usuarios" + RESET);
        }
    }

    //metodo para guardar los usuarios
    public static void guardarUsuarios() {
        //se inicializa un BufferedWriter para escribir en el archivo usuarios.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.txt"))) {
            //se recorre la lista de usuarios
            for (Usuario usuario : usuarios) {
                //se escribe en el archivo los datos del usuario separados por ;
                bw.write(usuario.getNombre() + ";" + usuario.getCorreo() + ";" + usuario.getPreferencias() + ";" + usuario.getContrasena());
                bw.newLine();
            }
        } catch (IOException e) {
            //si hay un error al escribir en el archivo se muestra un mensaje de error
            System.out.println(RED + "Error al guardar los usuarios" + RESET);
        }
    }

    //metodo para cargar los destinos
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

    //metodo para guardar los destinos
    public static void guardarDestinos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("destinos.txt"))) {
            for (Destino destino : destinos) {
                bw.write(destino.getNombre() + ";" + destino.getDescripcion() + ";" + destino.getCosto() + ";" + destino.getDisponibilidad() + ";" + destino.getRecomendaciones() + ";" + destino.getEquipoNecesario());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(RED + "Error al guardar los destinos" + RESET);
        }
    }

    //metodo para guardar las reservas
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

    //metodo para ver los destinos disponibles
    public static void verDestinosDisponibles() {
        //se recorre la lista de destinos
        System.out.println(CYAN + "Destinos disponibles" + RESET);
        for (Destino destino : destinos) {
            //si el destino está disponible se muestra su información
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

    //metodo para ver los destinos
    public static void verDestinos() {
        //se recorre la lista de destinos y se muestra su información
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

    //metodo para ver las reservas
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

    //metodo para ver los usuarios
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

    //metodo para cargar las reservas
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

