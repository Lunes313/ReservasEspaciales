import java.util.Scanner;
public class menu {

    // colores: estos colores fueron generados a base de inteligencia articial, pero sus codigos pueden encontrarse en internet
    public static String RESET = "\033[0m";
    public static String CYAN = "\033[0;36m";
    public static String YELLOW = "\033[0;33m";
    public static String RED = "\033[0;31m";
    public static String GREEN = "\033[0;32m";
    public static String BLUE = "\033[0;34m";

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Dibujo de estrellas para el inico del programa
        String stars =
                "   .   ,      .      ✨ .   .         🌟 .  .  \n" +
                        "       .      .  . .  *  .      .   \n" +
                        "  .    ✨ .    ⭐    .  .   '  .    ⭐  .  ' \n" +
                        "   ,  ⭐ *    . .   .  *   .  .    .    *   \n" +
                        "   .  .  .  .     *   *  . ✨  * \n" +
                        "   .    .  .  .   . 🌟.   .  . *   .      . \n"+
            "   *   ⭐    .  🌟      ,   .    ⭐  .   ✨  .     \n" +
            "   ✨        *       ⭐     ,   *      ✨     \n";

        System.out.println(YELLOW + stars + RESET);

        // Mensaje de bienvenida
        System.out.println(GREEN + "¡Listo para explorar el espacio! \uD83D\uDC7D" + RESET);
        menu();
    }

    //metodo menu
    public static void menu() {
        // Menú principal
        System.out.println(CYAN + "Menú principal" + RESET);
        System.out.println("1. iniciar sesión");
        System.out.println("2. Registrarse");
        System.out.println("3. reservar destino");
        System.out.println("4. ver destinos disponibles");
        System.out.println("5. ver reservas");
        System.out.println("6. ver destinos reservados");
        System.out.println("7. ver destinos recomendados");
        System.out.println("8. ver destinos por tipo");
        System.out.println("9. Salir");
        System.out.print("Ingrese una opción: ");
        try {
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    registrarse();
                    break;
                case 3:
                    reservarDestino();
                    break;
                case 4:
                    verDestinosDisponibles();
                    break;
                case 5:
                    verReservas();
                    break;
                case 6:
                    verDestinosReservados();
                    break;
                case 7:
                    verDestinosRecomendados();
                    break;
                case 8:
                    verDestinosPorTipo();
                    break;
                case 9:
                    System.out.println(CYAN +"¡Hasta luego!");
                    break;
                default:
                    System.out.println(RED + "Opción inválida" + RESET);
                    menu();
            }
        } catch (Exception e) {
            System.out.println(RED + "Ingresa un numero entero" + RESET);
            sc.next();
            menu();
        }
    }

    private static void registrarse() {
    }

    private static void iniciarSesion() {
    }

    private static void reservarDestino() {
    }

    private static void verDestinosDisponibles() {
    }

    private static void verReservas() {
    }

    private static void verDestinosReservados() {
    }

    private static void verDestinosRecomendados() {
    }

    private static void verDestinosPorTipo() {
    }

}


