package com.reasonable.calendar.exception;

public class ReasonableException extends RuntimeException {
    public ReasonableException(String msg) {
        super(msg);
    }

    public ReasonableException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
