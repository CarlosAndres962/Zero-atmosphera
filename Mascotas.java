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
    public String nombre;
    public String propietario;
    public String codigo;
    public int edad;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getEdad() {
        return edad;
    }

    //Constructor
    public Mascotas( String nombre, String propietario, String codigo, int edad) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.codigo = codigo;
        this.edad = edad;
    }
    
    public abstract String Comunican();
    
    public abstract String Duermen();
    
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
