class EightQueens {
    public static void main(String[] args) {
        int[] chessboard = new int[8];
        boolean answerFound = false;
        answerFound = calculateSolution(chessboard, 0, false);
        System.out.println(answerFound);
    }

    public static void printChessboard(int[] chessboard) {
        System.out.println("---------------------------------");
        for (int column : chessboard) {
            String line = "|";
            for (int i = 0; i < column; i++) {
                line += "   |";
            }
            line += " X |";
            for (int i = column + 1; i < 8; i++) {
                line += "   |";
            }
            System.out.println(line);
            System.out.println("---------------------------------");
        }
    }

    public static boolean testRow(int[] chessboard, int row) {
        int column = chessboard[row];
        int used;
        for (int i = 0; i < row; i++) {
            used = chessboard[i];
            // Fail if there's another queen in this column
            if (used == column) {
                return false;
            // Fail if there's another queen on the diagonal
            } else if ((row - i) == (column - used) ||
                       (row - i) == (used - column)) {
                return false;
            }
        }
        return true;
    }

    public static boolean calculateSolution(int[] chessboard, int row, boolean accumulator) {
        if (row == 7) {
            if (testRow(chessboard, row)) {
                System.out.println("");
                printChessboard(chessboard);
                System.out.println("");
                return true;
            } else {
                return false;
            }
        }
        for (int i = 0; i < 8; i++) {
            chessboard[row] = i;
            if (testRow(chessboard, row)) {
                accumulator |= calculateSolution(chessboard, row + 1, accumulator);
            }
        }
        return accumulator;
    }
}
