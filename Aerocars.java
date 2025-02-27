
package com.mycompany.zeroatmosphera;


public class Aerocars extends Vehiculos implements Turbojets{
    //atributos
    private static int ncod=0;
    private final double precio=12;
    private double distancia;
    private String codigo;
    private ResponsableVehiculo responsable;
    //Constructores
    public Aerocars(double distancia, String tipo,ResponsableVehiculo responsable, int numper, double velocidad, int nturbo) {
        super(numper, velocidad, nturbo);
        this.distancia = distancia;
        this.codigo=codigo;
        this.responsable=responsable;
    }
    //Metodos
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
        return "car-"+String.format("%04d"+ncod++);
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
    public void maxTurboJets(){
        if (nturbo>2) {
            System.out.println("Los aerocars no pueden tener mas de dos turbojets");
        }
    }
  @Override
    public String detalle() {
        String resumen;
        resumen="Detalles comunes.";
        resumen="-----------------------";        
        resumen="Velocidad :"+velocidad;
        resumen="Numero de ocupantes :"+numeroper;
        resumen="Detalles propios.";
        resumen="------------------------";
        resumen="Tipo: "+tipo;
        resumen="Codigo: "+generaCodigo();
        resumen="distancia: "+distancia;
        resumen="Responsable del vehiculo: "+nombre;
        resumen="Transmisión: "+Transmision();
        return resumen;
    }
}
