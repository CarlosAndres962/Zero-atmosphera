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

    public Gatos(String nombre, String codigo, String raza) {
    super(nombre, codigo);
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
