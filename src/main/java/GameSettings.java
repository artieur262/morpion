public class GameSettings {
    public int row;
    public int line;
    public boolean extention;
    public boolean triche;
    public Playbol[] playbols;
    int playerIndex;

    public GameSettings(int row, int line, boolean extention, boolean triche, Playbol[] playbols, int playerIndex) {
        this.row = row;
        this.line = line;
        this.extention = extention;
        this.triche = triche;
        this.playbols = playbols;
        this.playerIndex = playerIndex;
    }

    public GameSettings(int row, int line, boolean extention, boolean triche, Playbol[] playbols) {
        this.row = row;
        this.line = line;
        this.extention = extention;
        this.triche = triche;
        this.playbols = playbols;
        this.playerIndex = -1;
    }

    public GameSettings() {
        this.row = 0;
        this.line = 0;
        this.extention = false;
        this.triche = false;
        this.playbols = null;
        this.playerIndex = -1;
    }

    public static GameSettings defaultSettings() {
        return new GameSettings(3, 3, false, false, new Playbol[] {
                new joueur('X', 1),
                new joueur('O', 2)
        });
    }
}
