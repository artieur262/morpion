public class Matrice {
    char[][] grid;

    public Matrice(int size) {
        grid = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public Matrice() {
        this(3);
    }

    public Matrice(char[][] initialGrid) {
        grid = initialGrid;
    }

    public Matrice(Matrice other) {
        this.grid = copyGrid(other.getGrid());
    }

    public char getCell(int row, int col) {
        return grid[row][col];
    }

    public void setCell(int row, int col, char value) {
        grid[row][col] = value;
    }

    public int getSize() {
        return grid.length;
    }

    public void print() {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            System.out.println("Matrice es vide.");
            return;
        }
        System.out.print(" ");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(" ---");
            }
            System.out.println("| ");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " |");
            }

            System.out.println();
        }
        for (int j = 0; j < grid[0].length; j++) {
            System.out.print(" ---");
        }
    }

    public boolean isFull() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public char victoire() {
        // ligne
        if (grid.length == 0 || grid[0].length == 0) {
            return ' ';
        }
        for (int i = 0; i < grid.length; i++) {
            char car = grid[i][0];
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j] != car) {
                    car = ' ';
                    break; // break pour optimiser. ça marche sans aussi
                }
            }
            if (car != ' ') {
                return car;
            }
        }

        // colonnes
        for (int j = 0; j < grid[0].length; j++) {
            char car = grid[0][j];
            for (int i = 1; i < grid.length; i++) {
                if (grid[i][j] != car) {
                    car = ' ';
                    break; // break pour optimiser. ça marche sans aussi
                }
            }
            if (car != ' ') {
                return car;
            }
        }

        // diagonales haut-gauche à bas-droite
        char car = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][i] != car) {
                car = ' ';
                break; // break pour optimiser. ça marche sans aussi
            }
        }
        if (car != ' ') {
            return car;
        }

        // diagonales haut-droite à bas-gauche
        car = grid[0][grid.length - 1];
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][grid.length - 1 - i] != car) {
                car = ' ';
                break; // break pour optimiser. ça marche sans aussi
            }
        }
        if (car != ' ') {
            return car;
        }
        return ' ';
    }

    public char[][] getGrid() {
        return grid;
    }

    public char[][][] getRotatedGrids() {
        char[][] firstRotation = tourneGrid(this.grid);
        char[][] secondRotation = tourneGrid(firstRotation);
        char[][] thirdRotation = tourneGrid(secondRotation);
        return new char[][][] { this.getGrid(), firstRotation, secondRotation, thirdRotation };
    }

    public int[][] getCasesEmpty() {
        int count = 0;
        int[][] emptyPositionsTemp = new int[grid.length * grid[0].length][2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ' ') {
                    emptyPositionsTemp[count][0] = i;
                    emptyPositionsTemp[count][1] = j;
                    count++;
                }
            }
        }
        int[][] emptyPositions = new int[count][2];
        System.arraycopy(emptyPositionsTemp, 0, emptyPositions, 0, count);
        return emptyPositions;
    }

    public static char[][] tourneGrid(char[][] original) {
        int n = original.length;
        char[][] rotated = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = original[i][j];
            }
        }
        return rotated;
    }

    public static char[][] copyGrid(char[][] original) {
        int n = original.length;
        char[][] copy = new char[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, n);
        }
        return copy;
    }

}