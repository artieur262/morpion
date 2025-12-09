import java.util.Scanner;

public class joueur implements Playbol {
    public static Scanner scanner = new Scanner(System.in);
    private char symbol;
    private int id;

    public joueur(char symbol, int id) {
        this.symbol = symbol;
        this.id = id;
    }

    @Override
    public void play(Partie partie) {
        Matrice mat = partie.getMatrice();
        System.out.println("Joueur " + id + " joue avec le symbole " + symbol);
        System.out.println("État actuel de la matrice :");
        mat.print();
        boolean aJouer = false;
        while (!aJouer) {
            System.out.println("Veuillez entrer les coordonnées de votre coup :");
            String line = scanner.nextLine();
            line = line.trim(); // Supprimer les espaces avant et après
            line = line.toLowerCase(); // Convertir en minuscules pour la comparaison
            if (line == null || line.trim().isEmpty()) {
                System.out.println("Entrée invalide. Veuillez réessayer.");
            } else if (Morpion.checkToInt(line)) {
                if (Integer.parseInt(line) <= mat.nbCase()
                        && Integer.parseInt(line) > 0) {
                    int pos = Integer.parseInt(line) - 1;
                    int row = pos / mat.getNbCols();
                    int col = pos % mat.getNbCols();
                    if (mat.placeSymbol(row, col, symbol)) {
                        aJouer = true;
                    } else {
                        System.out.println("La case est déjà occupée. Veuillez réessayer.");
                    }
                } else {
                    System.out.println("Numéro de case invalide. Veuillez réessayer.");
                }
            } else if (line.equals("help") || line.equals("aide")) {
                help(partie);
            } else {
                System.out.println("Entrée invalide ou inconnu. Veuillez réessayer.");
            }
        }
    }

    public void help(Partie partie) {
        Matrice mat = partie.getMatrice();

        System.out.println("Joueur " + id + " utilise le symbole '" + symbol + "'.");
        System.out.println("Pour jouer, entrez un numéro de case entre 1 et " + (mat.nbCase()) + ".");
        System.out.println("Les cases sont numérotées de gauche à droite, de haut en bas.");

        Matrice helper = new Matrice(mat.getNbRows(), mat.getNbCols());
        int caseNumber = 1;
        for (int i = 0; i < mat.getNbRows(); i++) {
            for (int j = 0; j < mat.getNbCols(); j++) {
                if (mat.isCellEmpty(i, j)) {
                    helper.setCell(i, j, Character.forDigit(caseNumber, 10));
                } else {
                    helper.setCell(i, j, mat.getCell(i, j));
                }
                caseNumber++;
            }
        }
        helper.print();
    }


    public char getSymbol() {
        return symbol;
    }

}
