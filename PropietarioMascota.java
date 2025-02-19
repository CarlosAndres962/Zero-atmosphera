/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosphere;

/**
 *
 * @author sarag
 */
public class PropietarioMascota extends mascotas {

    public PropietarioMascota(String nombre, String propietario, String codigo, int edad) {
        super(nombre, propietario, codigo, edad);
    }

    @Override
    public String Comunican() {
        return "hablan";
    }

    @Override
    public int Duermen() {
        return 8;
    }

    @Override
    public String Comen() {
        return "ingieren";
    }
    
}
