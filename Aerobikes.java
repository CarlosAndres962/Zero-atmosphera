
package com.mycompany.zeroatmosphera;

//atributos
public class Aerobikes extends Vehiculos implements Turbojets{
    private String color;
    private String modelo;
    private String tipo;
//constructores
    public Aerobikes(String color, String modelo, String tipo, int numper, double velocidad, int nturbo) {
        super(numper, velocidad, nturbo);
        this.color = color;
        this.modelo = modelo;
        this.tipo = tipo;
    }
//metodos
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
    public void maxTurboJets(){
        if (nturbo>2) {
            System.out.println("Los aerobikes no pueden tener mas de dos turbojets");
        }
    }
    
    @Override
    public String detalles(){
        return "Detalles Aerobike:"+
                "\nModelo: "+modelo+
                "\nColor: "+color+
                "\nTipo: "+tipo+
                "\nNumero de turbojets: "+nturbo+
                "\nVelocidad: "+velocidad+
                "\nLargo: "+largo+
                "\nAncho: "+ancho+
                "\nNumERO de personas: "+numper+
                "\n----------------";
    }
}
