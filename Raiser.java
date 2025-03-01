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
        int numeroAleatorio = (int) (Math.random() * 2); // Genera 0 o 1
        if (numeroAleatorio == 0) {
            return "El alienígena está comiendo";
        } else {
            return "El alienígena no está comiendo";
        }
    }

    @Override
    public String Atacan() {
        int numeroAleatorio = (int) (Math.random() * 2); // Genera 0 o 1
        if (numeroAleatorio == 0) {
            return "El alienígena está atacando";
        } else {
            return "El alienígena no está atacando";
        }
    }
    

    @Override
    public String toString() {
        return "Raiser{" +
               "tipo='" + getTipo() + '\'' +
               ", invisivilidad=" + invisibilidad +
               '}';
    }

    @Override
    public int Duermen() {
        return 15;
    }
     
}
