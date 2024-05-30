public class main {
    // Secuencias de escape ANSI para colores
    public static final String RESET = "\033[0m";
    public static final String CYAN = "\033[0;36m";
    public static final String YELLOW = "\033[0;33m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String BLUE = "\033[0;34m";

    public static void main(String[] args) {
        // Imprime un mensaje de bienvenida grande
        String welcomeMessage =
                "  ____              _ _               _     _               \n" +
                        " |  _ \\            (_) |             | |   (_)              \n" +
                        " | |_) | ___  _ __  _| |_ _   _  __ _| |__  _ _ __   __ _   \n" +
                        " |  _ < / _ \\| '_ \\| | __| | | |/ _` | '_ \\| | '_ \\ / _` |  \n" +
                        " | |_) | (_) | | | | | |_| |_| | (_| | | | | | | | | (_| |  \n" +
                        " |____/ \\___/|_| |_|_|\\__|\\__,_|\\__, |_| |_|_|_| |_|\\__, |  \n" +
                        "                                   __/ |             __/ |  \n" +
                        "                                  |___/             |___/   \n";

        System.out.println(CYAN + welcomeMessage + RESET);

        // Dibujo de estrellas
        String stars =
                "           .         .       .   .     . .    .  .   . .  .  \n" +
                        "       .      .  . .  *  .  .  '      .    '      *  .   .   \n" +
                        "  .       .  .   '  .    .  '    .     .     .   .  *  .   . \n" +
                        "       *    . .   .  *   . ' .  .  * '  .    .   .    *   .  \n" +
                        "   .  .  .  .  *  .  .   . ' .    .  .    .  *  .  *  .  *   \n" +
                        "    .      .    . .  . .  . .  *  .   *  . . .  .  ' .   .   \n" +
                        "      .      .  .  .    *  .  .  .  .   .   .  .  .  .       \n" +
                        "   *  .  .   .  *   .   . .  .  . '     *  .  . .   .  .     \n" +
                        "       .     .  .  *  .  . . .  * .   .   .   . .  *  .   .  \n" +
                        " .      .  * .    .  * . .  .   .   .  . . *  .   . *        \n" +
                        "     .   *  .  *  .  .   .  . .   . .  .  *  .  * .   .   .  \n" +
                        "   .    .  .  .   . .   .  . *   .  . .  .    .  *   .  .    \n";

        System.out.println(YELLOW + stars + RESET);

        // Dibujo de un cohete espacial
        String rocket =
                "        _\n" +
                        "       /^\\\n" +
                        "      /   \\\n" +
                        "     /  |  \\\n" +
                        "    /  / \\  \\\n" +
                        "   /  /   \\  \\\n" +
                        "  /  /_____\\  \\\n" +
                        " /  /       \\  \\\n" +
                        "/  /         \\  \\\n" +
                        "|  |         |  |\n" +
                        "|  |         |  |\n" +
                        "|  |         |  |\n" +
                        "|  |         |  |\n" +
                        "|  |         |  |\n" +
                        "|  |         |  |\n" +
                        "|  |         |  |\n" +
                        "|  |         |  |\n" +
                        "|  |         |  |\n" +
                        "|  |         |  |\n" +
                        "|  |         |  |\n" +
                        "|__|         |__|\n";

        System.out.println(RED + rocket + RESET);

        // Mensaje de despedida
        System.out.println(GREEN + "¡Listo para explorar el espacio!" + RESET);
    }
}


