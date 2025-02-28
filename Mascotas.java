/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosphere;

/**
 *
 * @author sarag
 */
public abstract class Mascotas extends Tripulacion {
    
    //Atributos
    private static int ncod=0;
    public Mascotas(String nombre, String codigo) {
        super(nombre, codigo);
    }
     
    //Constructor
    
    public abstract String Comunican();
    
    public abstract String Duermen();
    
    public abstract String Comen();
    
    public String generaCodigo(){
        return "mas-"+String.format("%04d",ncod++);
    }

}
