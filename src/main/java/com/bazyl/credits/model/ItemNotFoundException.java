package com.bazyl.credits.model;

public class ItemNotFoundException extends Exception {
    ItemNotFoundException(){

    }

    ItemNotFoundException(String message){
        super(message);
    }
}
