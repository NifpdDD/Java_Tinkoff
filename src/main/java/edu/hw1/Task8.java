package edu.hw1;

public class Task8 {

    public int rotateLeft(int n, int shift) {
        if (n < 0) {
            return -1;
        }
        if (shift < 0) {
            return -1;
        }
        int shiftLength = shift % Integer.toBinaryString(n).length();
        return (n << shiftLength) & ((int) Math.pow(2, Integer.toBinaryString(n).length()) - 1)
            | (n >>> (Integer.toBinaryString(n).length() - shiftLength));
    }

    public int rotateRight(int n, int shift) {
        if (n < 0) {
            return -1;
        }
        if (shift < 0) {
            return -1;
        }
        int shiftLength = shift % Integer.toBinaryString(n).length();
        return (n >>> shiftLength) | (n << (Integer.toBinaryString(n).length() - shiftLength))
            & ((int) Math.pow(2, Integer.toBinaryString(n).length()) - 1);
    }

}
