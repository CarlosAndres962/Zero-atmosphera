
package com.mycompany.zeroatmosphera;


public class Aerocars extends Vehiculos implements Turbojets{
    //atributos
    private Codigo codigo=new Codigo();
    private final double precio=12;
    private double distancia;
    private ResponsableVehiculo responsable;
    //Constructores
    public Aerocars(double distancia,ResponsableVehiculo responsable, int numper, double velocidad, int nturbo) {
        super(numper, velocidad, nturbo);
        this.distancia = distancia;
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
        return codigo.codCars();
    }

    public ResponsableVehiculo getResponsable() {
        return responsable;
    }

    public void setResponsable(ResponsableVehiculo responsable) {
        this.responsable = responsable;
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
        if (nturbo>2) {
            System.out.println("Los aerocars no pueden tener mas de dos turbojets");
        }
    }
  @Override
    public String detalles() {
        String resumen;
        resumen="Detalles comunes.";
        resumen="-----------------------";        
        resumen="Velocidad :"+velocidad;
        resumen="Numero de ocupantes :"+numper;
        resumen="Detalles propios.";
        resumen="------------------------";
        resumen="Codigo: "+getCodigo();
        resumen="distancia: "+distancia;
        resumen="Responsable del vehiculo: "+responsable;
        resumen="Transmisión: "+transmicion();
        return resumen;
    }
}
