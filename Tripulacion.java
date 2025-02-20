/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosf;

/**
 *
 * @author ivand
 */
public abstract class Tripulacion {
    
    protected String nombre;
    protected char sexo;
    protected String codigo;
    

    public Tripulacion() {
    }

    public Tripulacion(String nombre) {
        this.nombre = nombre;
    }
    

    public Tripulacion(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    

    public Tripulacion(String nombre, char sexo, String codigo) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
    
}
