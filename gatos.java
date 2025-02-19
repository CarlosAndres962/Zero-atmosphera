/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosphere;

/**
 *
 * @author sarag
 */
public class gatos extends mascotas {
    
    public String raza;
    
    public gatos(String nombre, String propietario, String codigo, int edad, String raza) {
        super( nombre, propietario, codigo, edad);
        this.raza=raza;
    }

    @Override
    public String Comunican() {
       return "maullan";
    }

    @Override
    public int Duermen() {
        return 14;
    }

    @Override
    public String Comen() {
        return "pienso";
    }
    
}
