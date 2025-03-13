/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    package zeroatmospher;

/**
 *
 * @author mendo
 */
public class Raiser extends Alienigena{
     public int invisibilidad;

     public Raiser(int invisibilidad) {
        this.invisibilidad = invisibilidad;
    }

    public int getInvisibilidad() {
        return invisibilidad;
    }

    public void setInvisibilidad(int invisibilidad) {
        this.invisibilidad = invisibilidad;
    }
    
    public int randomCome(){
        int c = (int) (Math.random() * 2);
        return c;
    }
    
    @Override
    public String Comen() {
        if (randomCome() == 0) {
            return "El alienigena esta comiendo";
        } else {
            return "El alienigena no esta comiendo";
        }
    }

    @Override
    public String Atacan() {
        int numeroAleatorio = (int) (Math.random() * 2); // Genera 0 o 1
        if (randomCome()!=0) {
            if (numeroAleatorio == 0) {
            return "El alienigena esta atacando";
            }
        }
        return "El alienigena no esta atacando";
    }

    @Override
    public int Duermen() {
        return 15;
    }

    @Override
    public String tipoAtaque(){
        return "El aliegnigena ataca con sus garras por la espalda";
    }
    
    @Override
    public String toString() {
        String detalles= "";
        detalles += "Información del Alienígena:\n";
        detalles += "Tipo: Raiser\n";
        detalles += "Código " + getCodigo()+ "\n";
        detalles += "Invisibilidad " + invisibilidad+ "\n";
        detalles += "Duermen " + Duermen() + "horas\n";
        detalles += Comen()+"\n";
        detalles += Atacan()+"\n";
        detalles += tipoAtaque()+"\n";
        detalles += ("----------------------");
        return detalles;
    }
     
}
