package com.internshala.lattice.exceptionalHandling;

public class NoSuchPatientException extends RuntimeException{
    public NoSuchPatientException(String msg){
        super(msg);
    }
}
