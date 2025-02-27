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
    }

    public int getInvisibilidad() {
        return invisibilidad;
    }

    public void setInvisibilidad(int invisibilidad) {
        this.invisibilidad = invisibilidad;
    }
    
    public int random(){
        int d=(int)(Math.random()*2)+1;
        return d;
    } 
    
    @Override
    public String Duermen() {
        if (random()==1) {
            return "El alienigena esta durmiendo";
        }else return "El alienigena esta despierto";
    }

    @Override
    public String Comen() {
        int c = (int)(Math.random()*2)+1;
        if (random()!=1) {
            if (c==1) {
                return "El alienigena esta comiendo";
            }
        }return "El alienigena no esta comiendo";
    }

    @Override
    public String Atacan() {
        int a = (int)(Math.random()*2)+1;
        if (random()!=1) {
            if (a==1) {
                return "El alienigena esta atacando";
            }
        }return "El alienigena no esta atacando";
    }
     
}
