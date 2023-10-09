package edu.hw1;

public class Task9 {
    public Task9() {

    }

    @SuppressWarnings("MagicNumber")
    public boolean knightBoardCapture(int[][] board) {
        if (isValidBoard(board)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] == 1) {
                        int[][] moves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
                        for (int[] move : moves) {
                            int x = i + move[0];
                            int y = j + move[1];
                            if (x >= 0 && x < 8 && y >= 0 && y < 8 && board[x][y] == 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
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
