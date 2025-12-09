public class Partie {

    private Matrice mat;
    private Playbol[] joueurs;
    private int currentPlayerIndex;

    public Partie(Matrice mat, Playbol[] joueurs) {
        this.mat = mat;
        this.joueurs = joueurs;
        this.currentPlayerIndex = 0;
    }

    public Matrice getMatrice() {
        return mat;
    }

}