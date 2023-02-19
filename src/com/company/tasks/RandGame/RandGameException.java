package com.company.tasks.RandGame;

public class RandGameException extends Exception {
    private static final long serialVersionUID = 4750222540083171383L;
    private final int count;

    public RandGameException(String message, int count) {
        super(message + ": " + count);
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
