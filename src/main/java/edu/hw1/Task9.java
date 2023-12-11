package edu.hw1;

public class Task9 {

    @SuppressWarnings("MagicNumber")
    public boolean knightBoardCapture(int[][] board) {
        isValidBoard(board);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1 && hasCapture(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    @SuppressWarnings("MagicNumber")
    private boolean hasCapture(int[][] board, int row, int col) {
        int[][] moves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
        for (int[] move : moves) {
            int x = row + move[0];
            int y = col + move[1];
            if (isValidMove(x, y) && board[x][y] == 1) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("MagicNumber")
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isValidBoard(int[][] board) {
        if (board == null) {
            throw new IllegalArgumentException();
        }
        int totalElements = 0;
        for (int[] ints : board) {
            totalElements += ints.length;
        }
        if (totalElements != 64) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != 0 && board[i][j] != 1) {
                    throw new IllegalArgumentException();
                }
            }
        }
        return true;
    }

}
