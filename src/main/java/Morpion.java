import java.util.Scanner;

class Morpion {

    public static void main(String[] args) {
        System.out.println("Bienvenue au jeu du Morpion !");
        // Initialisation du jeu, des joueurs, etc.
        Scanner scanner = new Scanner(System.in);
        GameSettings settings = initSettings();
        Matrice mat = new Matrice(settings.line, settings.row);
        Partie partie = new Partie(mat, settings.playbols, settings.extention, settings.triche);
        partie.start();

        scanner.close();

    }

    public static boolean checkToInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean AskYesNo(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question + " (yes/no)");
        String response = scanner.nextLine().trim().toLowerCase();
        while (!response.equals("yes") && !response.equals("no") &&
                !response.equals("oui") && !response.equals("non") &&
                !response.equals("y") && !response.equals("n") && !response.equals("o")) {
            System.out.println("Réponse invalide. Veuillez répondre par 'yes' ou 'no'.");
            System.out.println(question + " (yes/no)");
            response = scanner.nextLine().trim().toLowerCase();
        }
        scanner.close();
        return response.equals("yes") || response.equals("oui") || response.equals("y") || response.equals("o");

    }

    public static int AskIntPositive(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        String response = scanner.nextLine().trim();
        while (!checkToInt(response) || Integer.parseInt(response) <= 0) {
            System.out.println("Entrée invalide. Veuillez entrer un entier positif.");
            System.out.println(question);
            response = scanner.nextLine().trim();
        }
        scanner.close();
        return Integer.parseInt(response);
    }

    public static GameSettings initSettings() {
        Scanner scanner = new Scanner(System.in);
        GameSettings settings = new GameSettings();
        System.out.println("Initialisation des paramètres du jeu...");
        settings.extention = AskYesNo("Voulez-vous activer les extensions ? ");
        settings.triche = AskYesNo("Voulez-vous activer le mode triche ? ");
        if (settings.extention) {
            settings.row = AskIntPositive("Combien de colonnes pour la matrice ? ");
            settings.line = AskIntPositive("Combien de lignes pour la matrice ? ");
            int nbPlayers = AskIntPositive("Combien de joueurs vont participer ? ");
            settings.playbols = new Playbol[nbPlayers];
            for (int i = 0; i < nbPlayers; i++) {
                settings.playbols[i] = createPlaybol(i + 1);
            }

        } else {
            settings.row = 3;
            settings.line = 3;
            settings.playbols = new Playbol[] {
                    new joueur('X', 1),
                    new joueur('O', 2)
            };
        }

        scanner.close();
        return settings;
    }

    public static Playbol createPlaybol(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Création du joueur " + id);
        System.out.println("Veuillez entrer le symbole du joueur " + id + " (un seul caractère) : ");
        String symbolInput = scanner.nextLine().trim();
        while (symbolInput.length() != 1 && symbolInput.isEmpty() && symbolInput.length() > 1
                && symbolInput.equals(" ")) {
            System.out.println("Symbole invalide. Veuillez entrer un seul caractère : ");
            symbolInput = scanner.nextLine().trim();
        }
        char symbol = symbolInput.charAt(0);
        scanner.close();
        return new joueur(symbol, id);
    }
}
