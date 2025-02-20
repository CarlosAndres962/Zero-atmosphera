/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zeroatmosphera;

/**
 *
 * @author mendo
 */
public class Aerocars extends Vehiculos{
    private final double precio=12;
    private double distancia;
    private String codigo;
    private String tipo;
    private ResponsableVehiculo nombre;

    public Aerocars(double distancia, String tipo, int numper, double velocidad, double largo, double ancho) {
        super(numper, velocidad, largo, ancho);
        this.distancia = distancia;
        this.tipo = tipo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia() {
        this.distancia = distancia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setMatricula() {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String generaCodigo(){
        int num=0;
        return "car-"+String.format("%04d"+num);
    }
    
    public double calculaCarburante(){
        double raiz= Math.sqrt(distancia);
        return raiz*precio;
    }
    public String Transmicion(){
        if (distancia<1) {
            return "Economico";
        }else{return "Estelar";}
    }
    @Override
    public String detalles(){
        return "Detalles Aerocar:"+
                "\nCodigo: "+generaCodigo()+
                "\nTipo: "+tipo+
                "\nLas medidas del aerocar es: "+
                "\nLargo: "+largo+
                "\nAncho: "+ancho+
                "\n----------------";
    }
}
