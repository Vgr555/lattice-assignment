package com.internshala.lattice.exceptionalHandling;

public class LocationUnAvailable extends RuntimeException{
    public LocationUnAvailable(String msg){
        super(msg);
    }
}
