package ru.danka.nexing.exception;

public class UnknownUserException extends IllegalStateException {
    public UnknownUserException(String s) {
        super(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
