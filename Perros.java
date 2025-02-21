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

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }
    
    public Perros(String nombre, String propietario, String codigo, int edad, String raza) {
        super(nombre, propietario, codigo,edad);
        this.raza=raza;
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
