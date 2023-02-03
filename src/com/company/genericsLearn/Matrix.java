package com.company.genericsLearn;

public class Matrix <T extends Number> {
    private int m = 0;
    private int n = 0;
    private T[][] matrix = null;

    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public Matrix(T[][] matrix) {
        if (!checkMatrix(matrix)) {
            throw new IndexOutOfBoundsException("Строки матрицы разной длины");
        }
        this.matrix = matrix;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public T[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(T[][] matrix) {
        if (!checkMatrix(matrix)) {
            throw new IndexOutOfBoundsException("Строки матрицы разной длины");
        }
        this.matrix = matrix;
    }

    private boolean checkMatrix(T[][] matr) {
        int len = matr[0].length;
        for (T[] arr : matr) {
            if (arr.length != len)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Double[][] matr = new Double[][]{{3.0, 6.0, 2.0},
                                            {6.8, 2.5, 0.4},
                                            {4.3, 2.6, 3.3}};

        String[][] matS = new String[][] {{"хуй", "соси"},
                {"залупу", "лижи"}};
        Matrix<Double> matrix = new Matrix(matr);
    }
}
