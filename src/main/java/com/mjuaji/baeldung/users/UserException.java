package com.mjuaji.baeldung.users;


public class UserException extends Exception{

    public UserException(){
        super();
    }

    public UserException(String message){
        super(message);
    }
}