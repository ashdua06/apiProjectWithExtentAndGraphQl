package com.test.exceptions;

public class SpacexException extends RuntimeException{
    public SpacexException() {
    }

    private SpacexException(String var1) {
        super(var1);
    }

    public SpacexException(Object var1) {
        this(String.valueOf(var1));
        if (var1 instanceof Throwable) {
            this.initCause((Throwable) var1);
        }

    }

    public SpacexException(boolean var1) {
        this(String.valueOf(var1));
    }

    public SpacexException(char var1) {
        this(String.valueOf(var1));
    }

    public SpacexException(int var1) {
        this(String.valueOf(var1));
    }

    public SpacexException(long var1) {
        this(String.valueOf(var1));
    }

    public SpacexException(float var1) {
        this(String.valueOf(var1));
    }

    public SpacexException(double var1) {
        this(String.valueOf(var1));
    }

    public SpacexException(String var1, Throwable var2) {
        super(var1, var2);
    }

}
