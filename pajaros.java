/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosphere;

/**
 *
 * @author sarag
 */
//comentario de prueba por ivan diaz
public class pajaros extends mascotas{
    
    public String especie;
    
    public pajaros(String nombre, String propietario, String codigo, int edad, String especie) {
        super( nombre, propietario, codigo, edad);
        this.especie=especie;
    }

    @Override
    public String Comunican() {
      return "Esta cantando";
    }

    @Override
    public int Duermen() {
      return "Esta durmiendo";
    }

    @Override
    public String Comen() {
        return "Esta comiendo semillas";
    }
    
}
