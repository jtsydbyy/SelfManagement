package com.finalproject.exception;

public class FundException extends Exception{
    public FundException(String message)
    {
        super("FundException-"+message);
    }

    public FundException(String message, Throwable cause)
    {
        super("FundException-"+message,cause);
    }
}
