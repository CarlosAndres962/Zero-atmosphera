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
    private Codigo codigo=new Codigo();
    public Mascotas(String nombre, String sexo) {
        super(nombre, sexo);
    }
     
    //Constructor
    
    public abstract String Comunican();
    
    public abstract String Duermen();
    
    public abstract String Comen();
    
    @Override
    public String getCodigo(){
        return codigo.codMas();
    }

}
