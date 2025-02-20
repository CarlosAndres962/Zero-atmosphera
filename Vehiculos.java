/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zeroatmosphera;

/**
 *
 * @author mendo
 */
public abstract class Vehiculos{
    protected int numper;
    protected double velocidad;
    protected int nturbo;
    
    public Vehiculos(int numper,double velocidad,int nturbo){
        this.numper=numper;
        this.velocidad=velocidad;
        this.nturbo=nturbo;
    }

    public int getNumper() {
        return numper;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public int getNturbo(){
        return nturbo;
    }

    public void setNumper(int numper) {
        this.numper = numper;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void setNturbo(){
        this.nturbo=nturbo;
    }
    public abstract String detalles();
    
}
