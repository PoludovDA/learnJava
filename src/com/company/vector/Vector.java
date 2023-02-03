package com.company.vector;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public double scalar(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public double getCos(Vector vector) {
        return this.scalar(vector) / (this.getLength() * vector.getLength());
    }

    public Vector sum(Vector vector) {
        return new Vector(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }

    public Vector min(Vector vector) {
        return new Vector(this.x - vector.x, this.y - vector.y, this.z - vector.z);
    }

    public static Vector[] getRandomVectors(int N) {
        double x = N, y = N, z = N;
        Vector[] resultArray = new Vector[N];
        for (Vector v : resultArray) {
            v = new Vector(x * Math.random(), y * Math.random(), z * Math.random());
        }
        return resultArray;
    }
}
