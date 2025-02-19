/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zeroatmosphera;

/**
 *
 * @author mendo
 */
public abstract class Vehiculos {
    protected int numper;
    protected double velocidad;
    protected double largo;
    protected double ancho;
    
    public Vehiculos(int numper,double velocidad,double largo,double ancho){
        this.numper=numper;
        this.velocidad=velocidad;
        this.largo=largo;
        this.ancho=ancho;
    }

    public int getNumper() {
        return numper;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getLargo() {
        return largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setNumper(int numper) {
        this.numper = numper;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    public abstract String detalles();

}
