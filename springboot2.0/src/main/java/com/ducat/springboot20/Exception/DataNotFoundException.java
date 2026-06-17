package com.ducat.springboot20.Exception;

public class DataNotFoundException extends RuntimeException {
    //Default Constuctor 
    public DataNotFoundException(){
        super();
    }
    //Parameterised Constructor ! ,Exception with message ! 
    public DataNotFoundException(String message){
        super(message);
    }
}
