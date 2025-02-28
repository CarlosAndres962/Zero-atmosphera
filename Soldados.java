/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosf;

/**
 *
 * @author ivand
 */
public class Soldados extends Tripulacion {
    private static int ncod=0;
    public int graduacion;

    public Soldados() {
    }

    public Soldados(int graduacion, String nombre, char sexo, String codigo) {
        super(nombre, sexo, codigo);
        this.graduacion = graduacion;
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
    

    public int getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(int graduacion) {
        this.graduacion = graduacion;
    }

    public String generaCodigo(){
        return "sol-"+String.format("%04d",ncod++);
    }

}
