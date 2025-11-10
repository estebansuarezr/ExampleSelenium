package com.arreglatech.project.exceptions.general;

public class BusinessException extends Exception
{
    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }


    protected BusinessException(String message, Throwable cause,
                                boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static class Runtime extends RuntimeException {

        public Runtime() {
            super();
        }

        public Runtime(String message) {
            super(message);
        }

        public Runtime(String message, Throwable cause) {
            super(message, cause);
        }

        public Runtime(Throwable cause) {
            super(cause);
        }

        protected Runtime(String message, Throwable cause,
                                   boolean enableSuppression,
                                   boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
