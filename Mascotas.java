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

    public Soldados(int graduacion, String nombre, char sexo, String codigo) {
        super(nombre, sexo, codigo);
        this.nombre = nombre;
        this.propietario = propietario;
        this.codigo = codigo;
        this.edad = edad;
    }

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
    
    public abstract String Comunican();
    
    public abstract String Duermen();
    
    public abstract String Comen();
    
    public String generaCodigo(){
        int num=0;
        return "mas-"+String.format("%04d"+num);
    }

}
