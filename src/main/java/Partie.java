import java.util.Random;

public class Partie {

    private Matrice mat;
    private Playbol[] joueurs;
    private int currentPlayerIndex;
    private boolean extention;
    private boolean triche;

    public Partie(Matrice mat, Playbol[] joueurs, int playerIndex, boolean extention, boolean triche) {
        this.mat = mat;
        this.joueurs = joueurs;
        this.currentPlayerIndex = playerIndex;
        this.extention = extention;
        this.triche = triche;
    }

    public Partie(Matrice mat, Playbol[] joueurs, boolean extention, boolean triche) {
        this(mat, joueurs, -1, extention, triche);
    }

    public Partie(Matrice mat, Playbol[] joueurs) {
        this(mat, joueurs, false, false);
    }

    public Matrice getMatrice() {
        return mat;
    }

    public boolean isExtention() {
        return extention;
    }

    public boolean isTriche() {
        return triche;
    }

    public void start() {
        boolean encour = true;
        while (encour) {
            randomPlayer();
            int ancienPlayerIndex = currentPlayerIndex;
            nextPlayer();
            Playbol currentPlayer = joueurs[ancienPlayerIndex];
            currentPlayer.play(this);
            char winner = mat.victoire();
            if (winner != ' ') {
                mat.print();
                System.out.println("Le joueur avec le symbole " + winner + " a gagné !");
                encour = false;
            } else if (mat.isFull()) {
                mat.print();
                System.out.println("Match nul !");
                encour = false;
            }

        }
    }

    public Playbol getCurrentPlayer() {
        return joueurs[currentPlayerIndex];
    }

    public void setCurrentPlayerIndex(int index) {
        if (index >= -1 && index < joueurs.length) {
            currentPlayerIndex = index;
        } else {
            throw new IllegalArgumentException("Index de joueur invalide.");
        }
    }

    public void nextPlayer() {
        if (joueurs.length == 0) {
            throw new IllegalStateException("Aucun joueur dans la partie.");
        }
        if (randomPlayer()) {
            return;
        }
        currentPlayerIndex = (currentPlayerIndex + 1) % joueurs.length;
    }

    public boolean randomPlayer() {
        if (currentPlayerIndex == -1) {
            Random rand = new Random();
            currentPlayerIndex = rand.nextInt(joueurs.length);
            return true;
        }
        return false;
    }

    public void precedingPlayer() {
        if (joueurs.length == 0) {
            throw new IllegalStateException("Aucun joueur dans la partie.");
        }
        currentPlayerIndex = (currentPlayerIndex - 1 + joueurs.length) % joueurs.length;
    }

    public boolean getExtention() {
        return extention;
    }

    public boolean getTriche() {
        return triche;
    }
}