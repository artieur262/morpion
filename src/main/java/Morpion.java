class Morpion {

    public static void main(String[] args) {
        System.out.println("Bienvenue au jeu du Morpion !");
        // Initialisation du jeu, des joueurs, etc.
    }

    public static boolean checkToInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}