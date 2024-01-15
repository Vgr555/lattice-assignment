package com.internshala.lattice.exceptionalHandling;

public class NoSuchDoctorException extends RuntimeException{
    public NoSuchDoctorException(String msg){
        super(msg);
    }
}
