public class Partie {

    private Matrice mat;
    private Playbol[] joueurs;
    private int currentPlayerIndex;
    private boolean extention;
    private boolean triche;

    public Partie(Matrice mat, Playbol[] joueurs, boolean extention, boolean triche) {
        this.mat = mat;
        this.joueurs = joueurs;
        this.currentPlayerIndex = 0;
        this.extention = extention;
        this.triche = triche;
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
            Playbol currentPlayer = joueurs[currentPlayerIndex];
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
            currentPlayerIndex = (currentPlayerIndex + 1) % joueurs.length;
        }
    }
}