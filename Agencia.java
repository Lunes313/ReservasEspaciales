import  java.util.Scanner;

public class Agencia {

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a la agencia de viajes");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. reservar");
        System.out.println("4. cancelar reserva");
        System.out.println("5. Mostrar reservas");
        System.out.println("6. Mostrar destinos disponibles");
        System.out.println("7. Mostrar destinos recomendados");
        System.out.println("8. Salir");
        System.out.println("Ingrese una opción: ");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                registrarUsuario();
                break;
            case 2:
                iniciarSesion();
                break;
            case 3:
                reservar();
                break;
            case 4:
                cancelarReserva();
                break;
            case 5:
                mostrarReservas();
                break;
            case 6:
                mostrarDestinos();
                break;
            case 7:
                mostrarDestinosRecomendados();
                break;
            case 8:
                System.out.println("Gracias por visitarnos");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }



}

