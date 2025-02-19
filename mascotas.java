/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosphere;

/**
 *
 * @author sarag
 */
public abstract class mascotas {
    
    //Atributos
    public String nombre;
    public String propietario;
    public String codigo;
    public int edad;

    //Constructor
    public mascotas( String nombre, String propietario, String codigo, int edad) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.codigo = codigo;
        this.edad = edad;
    }
    
    public abstract String Comunican();
    
    public abstract int Duermen();
    
    public abstract String Comen();
    
    public boolean codigo(String codigo){
        if (codigo.length()!=7)
            return false;
        for (int i=0; i<4; i++){
            char c = (char) i;
            if (c<'a' || c>'z')
                return true;
            
        }
        return true;
    }

}
