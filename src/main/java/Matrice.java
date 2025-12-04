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

}
