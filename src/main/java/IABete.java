public class IABete implements Playbol {
    private char symbol;
    private int id;

    public IABete(char symbol, int id) {
        this.symbol = symbol;
        this.id = id;
    }

    @Override
    public void play(Partie partie) {
        int position = getRandomPosition(getAvailablePositions(partie.getMatrice()));
        partie.getMatrice().placeSymbol(position / partie.getMatrice().getSize(),
                position % partie.getMatrice().getSize(), symbol);
    }

    private int[] getAvailablePositions(Matrice mat) {
        int totalPositions = mat.getSize() * mat.getSize() + 1;
        int[] tempPositions = new int[totalPositions];
        int count = 0;
        for (int i = 0; i < mat.getSize(); i++) {
            for (int j = 0; j < mat.getSize(); j++) {
                if (mat.isCellEmpty(i, j)) {
                    tempPositions[count] = i * mat.getSize() + j;
                    count++;
                }
            }
        }
        int[] availablePositions = new int[count];
        System.arraycopy(tempPositions, 0, availablePositions, 0, count);
        return availablePositions;
    }

    private int getRandomPosition(int[] positions) {
        int randomIndex = (int) (Math.random() * positions.length);
        return positions[randomIndex];
    }

    public char getSymbol() {
        return symbol;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "IA Bête " + id + " (symbole: " + symbol + ")";
    }

}