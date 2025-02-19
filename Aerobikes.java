/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zeroatmosphera;

/**
 *
 * @author mendo
 */
public class Aerobikes extends Vehiculos{
    private String color;
    private String modelo;
    private String tipo;

    public Aerobikes(String color, String modelo, String tipo, int numper, double velocidad, double largo, double ancho) {
        super(numper, velocidad, largo, ancho);
        this.color = color;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   @Override
    public String detalles(){
        return "Detalles Aerobike:"+
                "\nModelo: "+modelo+
                "\nColor: "+color+
                "\nTipo: "+tipo+
                "\nLas medidas del aerocar es: "+
                "\nLargo: "+largo+
                "\nAncho: "+ancho+
                "\n----------------";
    }
    
}
