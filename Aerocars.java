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
    private String matricula;
    private String tipo;
    private ResponsableVehiculo nombre;

    public Aerocars(double distancia, String matricula, String tipo, int numper, double velocidad, double largo, double ancho) {
        super(numper, velocidad, largo, ancho);
        this.distancia = distancia;
        this.matricula = matricula;
        this.tipo = tipo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia() {
        this.distancia = distancia;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula() {
        this.matricula = matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public double calculaCarburante(){
        double raiz= Math.sqrt(distancia);
        return raiz*precio;
    }
    public String Transmision(double elije){
        elije = distancia*9.461*2.718+12;      
      if(elije <1){
          return("Economico");
      }
      else{
          return("Estelar");
      }
    }
    @Override
    public String detalles(){
        return "Detalles Aerocar:"+
                "\nMatricula: "+matricula+
                "\nTipo: "+tipo+
                "\nLas medidas del aerocar es: "+
                "\nLargo: "+largo+
                "\nAncho: "+ancho+
                "\n----------------";
    }
}
