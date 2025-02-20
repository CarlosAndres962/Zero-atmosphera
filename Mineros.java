/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosf;

/**
 *
 * @author ivand
 */
public class Mineros extends Tripulacion {

    public int edad;

    public Mineros(int edad, String nombre, char sexo, String codigo) {
        super(nombre, sexo, codigo);
        this.edad = edad;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public char getSexo() {
        return sexo;
    }

    @Override
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    

  
    
}