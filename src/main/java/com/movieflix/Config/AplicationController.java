package com.movieflix.Config;

import com.movieflix.Exceptions.UseNameOrPasswordInvalidExeception;
import com.movieflix.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AplicationController {
    @ExceptionHandler(UseNameOrPasswordInvalidExeception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String naotemUsuario(UseNameOrPasswordInvalidExeception ex){
        return ex.getMessage();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> notvalid(MethodArgumentNotValidException exception){
        Map<String,String> erros = new HashMap<>();
            exception.getBindingResult().getAllErrors().forEach((error) ->{
                erros.put(((FieldError) error).getField(),error.getDefaultMessage());
            });
            return erros;
    }
}

