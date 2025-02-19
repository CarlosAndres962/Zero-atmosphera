/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosphere;

/**
 *
 * @author sarag
 */
public class Gatos extends Mascotas {
    
    public String raza;
    
    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }
    
    public Gatos(String nombre, String propietario, String codigo, int edad, String raza) {
        super( nombre, propietario, codigo, edad);
        this.raza=raza;
    }

    @Override
    public String Comunican() {
       return "estan maullando";
    }
    
    @Override
    public String Duermen() {
        return "estan durmiendo hace 4 horas";
    }

    @Override
    public String Comen() {
        return "estan comiendo pienso";
    }
    
}
