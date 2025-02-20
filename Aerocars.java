/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zeroatmosphera;

/**
 *
 * @author mendo
 */
public class Aerocars extends Vehiculos implements Turbojets{
    private final double precio=12;
    private double distancia;
    private String codigo;
    private ResponsableVehiculo responsable;

    public Aerocars(double distancia, String tipo,ResponsableVehiculo responsable, int numper, double velocidad, int nturbo) {
        super(numper, velocidad, nturbo);
        this.distancia = distancia;
        this.codigo=codigo;
        this.responsable=responsable;
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

    public void setCodigo() {
        this.codigo = codigo;
    }

    public ResponsableVehiculo getResponsable() {
        return responsable;
    }

    public void setResponsable(ResponsableVehiculo responsable) {
        this.responsable = responsable;
    }
    
    public String generaCodigo(){
        int num=0;
        return "car-"+String.format("%04d"+num);
    }
    
    public double calculaCarburante(){
        double raiz= Math.sqrt(distancia);
        return raiz*precio;
    }
    public String transmicion(){
        if (distancia<1) {
            return "Economico";
        }else{return "Estelar";}
    }
    @Override
    public void maxTurboJets(){
        if (nturbo>4) {
            System.out.println("Los aerobikes no pueden tener mas de dos turbojets");
        }
    }
    @Override
    public String detalles(){
        return "Detalles Aerocar:"+
                "\nResponsable: "+responsable+
                "\nCodigo: "+generaCodigo()+
                "\nDistancia a recorrer:"+distancia+
                "\nGasto de Carburante: "+calculaCarburante()+
                "\nTransmision: "+transmicion()+
                "\nNumero de turbojets: "+nturbo+
                "\n-----------------------";
    }
}
