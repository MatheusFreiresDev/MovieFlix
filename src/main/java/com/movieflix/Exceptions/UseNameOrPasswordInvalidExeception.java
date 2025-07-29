package com.movieflix.Exceptions;

public class UseNameOrPasswordInvalidExeception  extends RuntimeException{
    public UseNameOrPasswordInvalidExeception (String message) {
        super(message);
    }

}
