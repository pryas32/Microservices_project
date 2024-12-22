package com.Icwd.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    //we know how to make custiom exception that can extend the peroperties of existing exception


    public ResourceNotFoundException(){
        super("Resource not foubd on server");
    }


    //kya pata apna msg user pass kar de in that case we pass user message in parent.
    public ResourceNotFoundException(String message){
        super(message);
    }


}
