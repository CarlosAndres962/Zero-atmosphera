
package com.mycompany.zeroatmosphera;


public abstract class Vehiculos{
    //Atributos
    protected int numper;
    protected double velocidad;
    protected int nturbo;
   //Constructores 
    public Vehiculos(){
    }
    public Vehiculos(int numper,double velocidad,int nturbo){
        this.numper=numper;
        this.velocidad=velocidad;
        this.nturbo=nturbo;
    }
   //Metodos
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
