package com.szzrain;

public class NameException extends RuntimeException {
    private String cause;

    public NameException(String s) {
        cause = s;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }


    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public String toString() {
        return "名称不合法" + cause;
    }
}
