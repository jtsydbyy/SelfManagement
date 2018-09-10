package com.finalproject.exception;

public class SalesException extends Exception{
    public SalesException(String message)
    {
        super("SalesException-"+message);
    }

    public SalesException(String message, Throwable cause)
    {
        super("SalesException-"+message,cause);
    }
}
