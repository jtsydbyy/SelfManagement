package com.finalproject.exception;

public class LoginException extends Exception{
    public LoginException(String message)
    {
        super("LoginException-"+message);
    }

    public LoginException(String message, Throwable cause)
    {
        super("LoginException-"+message,cause);
    }
}
