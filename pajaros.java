/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosphere;

/**
 *
 * @author sarag
 */
public class pajaros extends mascotas{
    
    public String especie;
    
    public pajaros(String nombre, String propietario, String codigo, int edad, String especie) {
        super( nombre, propietario, codigo, edad);
        this.especie=especie;
    }

    @Override
    public String Comunican() {
      return "cantan";
    }

    @Override
    public int Duermen() {
      return 8;
    }

    @Override
    public String Comen() {
        return "semillas";
    }
    
}
