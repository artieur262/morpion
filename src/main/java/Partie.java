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
        while (true) {
            Playbol currentPlayer = joueurs[currentPlayerIndex];
            currentPlayer.play(this);
            char winner = mat.victoire();
            if (winner != ' ') {
                System.out.println("Le joueur avec le symbole " + winner + " a gagné !");
                mat.print();
                break;
            } else if (mat.isFull()) {
                System.out.println("Match nul !");
                mat.print();
                break;
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % joueurs.length;
        }
    }
}