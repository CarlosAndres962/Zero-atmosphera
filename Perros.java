/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosphere;

/**
 *
 * @author sarag
 */
public class Perros extends Mascotas {
    
    public String raza;
    
   public Perros(String nombre, char sexo, String raza) {
        super(nombre, sexo);
        this.raza = raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    @Override
    public String Comunican() {
         return "esta ladrando";
    }

    @Override
    public String Duermen() {
        return "esta durmiendo";
    }

    @Override
    public String Comen() {
        return "esta comiendo pienso";
    }
    
}
