package com.mycompany.zeroatmosphera;

public class Nomun extends Alienigena {
    //Atributos 
    public double autotraslacion;
    
public Nomun(double autotraslacion,String tipo){
    super(tipo);
    this.autotraslacion= autotraslacion;    
}
public void setAutotraslacion(double autotraslacion ){
   this.autotraslacion=autotraslacion;
}

public Double gerAutotraslacion(){
   return autotraslacion;
}

@Override
public String Duermen(){
    return "Duermen alrededor de 15 horas";
 }

@Override
public String Comen(){
    return "Estan comiendo";
 }
 
 @Override
 public String Atacan(){
    return "Estan atacando";
 }
}