package com.underhill.hyperskill;

abstract public class Algorithm {

    protected String msg;
    protected String operation;
    protected int key;

    public Algorithm(String msg, int key, String operation) {
        this.msg = msg;
        this.key = key;
        this.operation = operation;

    }

    public String process() {
        if ("dec".equals(operation.toLowerCase())) {
            return decrypt();
        }
        return encrypt();
    }

    abstract String encrypt();
    abstract String decrypt();
}

