/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosphere;

/**
 *
 * @author sarag
 */
public class perros extends mascotas {
    
    public String raza;
    
    public perros(String nombre, String propietario, String codigo, int edad, String raza) {
        super(nombre, propietario, codigo,edad);
        this.raza=raza;
    }

    @Override
    public String Comunican() {
         return "ladran";
    }

    @Override
    public int Duermen() {
        return 12;
    }

    @Override
    public String Comen() {
        return "pienso";
    }
    
}
