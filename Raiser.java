/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zeroatmosphera;

/**
 *
 * @author mendo
 */
public class Raiser extends Alienigena{
     public int invisibilidad;

    public Raiser(String tipo,int invisivilidad) {
        super(tipo);
          this.invisibilidad = invisibilidad;
    }

    public int getInvisibilidad() {
        return invisibilidad;
    }

    public void setInvisibilidad(int invisibilidad) {
        this.invisibilidad = invisibilidad;
    }

    
    @Override
    public String Comen() {
        return (Math.random() < 0.5) ? "El alienígena está comiendo" : "El alienígena no está comiendo";
    }

    @Override
    public String Atacan() {
        return (Math.random() < 0.5) ? "El alienígena está atacando" : "El alienígena no está atacando";
    }


    @Override
    public String toString() {
        return "Raiser{" +
               "tipo='" + getTipo() + '\'' +
               ", invisibilidad=" + invisibilidad +
               '}';
    }

    @Override
    public int Duermen() {
        return 15;
    }
     
}
