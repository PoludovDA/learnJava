package com.company.networkLearn.ticTacToe;

import java.io.Serializable;
import java.util.Arrays;

public class TicField implements Serializable {
    private static final long serialVersionUID = 1880899292471613906L;
    private char[][] field = new char[3][3];
    private boolean isEnd = false;
    private String winner = null;

    public TicField() {
        for(char[] column : field)
            Arrays.fill(column, 'f');
    }

    public void setTic(int row, int column, String playAs) {
        if (playAs.equals("krestik"))
            field[row - 1][column - 1] = 'X';
        else if (playAs.equals("nolik")) {
            field[row - 1][column - 1] = '0';
        }
        else
            new AssertionError("Неправильная роль").printStackTrace();
    }

    public void checkEndGame() {
        char[] winArrayX = new char[field.length];
        Arrays.fill(winArrayX, 'X');
        char[] winArray0 = new char[field.length];
        Arrays.fill(winArray0, '0');
        char[] mainDiag = new char[field.length];
        char[] secondDiag = new char[field.length];

        if (checkRowsColumns(winArrayX, winArray0, field)) return;

        char[][] transposeField = new char[field.length][field.length];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                transposeField[i][j] = field[j][i];
            }
        }

        if (checkRowsColumns(winArrayX, winArray0, transposeField)) return;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (i == j) {
                    mainDiag[i] = field[i][j];
                }

                if ((i == 2 && j == 2) || Math.abs(i - j) == 2) {
                    secondDiag[i] = field[i][j];
                }
            }
        }
        if (Arrays.equals(mainDiag, winArrayX) || Arrays.equals(secondDiag, winArrayX)) {
            isEnd = true;
            winner = "krestik";
            return;
        }

        if (Arrays.equals(mainDiag, winArray0) || Arrays.equals(secondDiag, winArray0)) {
            isEnd = true;
            winner = "nolik";
        }
    }

    private boolean checkRowsColumns(char[] winArrayX, char[] winArray0, char[][] transposeField) {
        for (char[] raw : transposeField) {
            if (Arrays.equals(raw, winArrayX)) {
                isEnd = true;
                winner = "krestik";
                return true;
            }
            if (Arrays.equals(raw, winArray0)) {
                isEnd = true;
                winner = "nolik";
                return true;
            }
        }
        return false;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public String getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (char[] chars : field) {
            for (char aChar : chars) {
                s.append(aChar).append(", ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
