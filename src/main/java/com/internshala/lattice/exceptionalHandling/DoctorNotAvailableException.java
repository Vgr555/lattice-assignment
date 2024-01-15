package com.internshala.lattice.exceptionalHandling;

public class DoctorNotAvailableException extends RuntimeException{
    public DoctorNotAvailableException(String msg){
        super(msg);
    }
}
