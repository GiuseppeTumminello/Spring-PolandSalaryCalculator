package com.acoustic.SpringPolandSalaryCalculator.exception;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



public class NotValidSalaryException extends RuntimeException{

    public NotValidSalaryException() {
    }

    public NotValidSalaryException(final String message) {
        super(message);
    }

    public NotValidSalaryException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NotValidSalaryException(final Throwable cause) {
        super(cause);
    }

    public NotValidSalaryException(
            final String message,
            final Throwable cause,
            final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
