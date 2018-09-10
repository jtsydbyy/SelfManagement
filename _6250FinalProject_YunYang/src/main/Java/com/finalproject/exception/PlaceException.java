package com.finalproject.exception;

public class PlaceException extends Exception{
    public PlaceException(String message)
    {
        super("PlaceException-"+message);
    }

    public PlaceException(String message, Throwable cause)
    {
        super("PlaceException-"+message,cause);
    }
}
