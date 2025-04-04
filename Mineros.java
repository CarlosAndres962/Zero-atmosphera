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
    private Codigo codigo=new Codigo();
    public int edad;

    public Mineros(int edad, String nombre, char sexo) {
        super(nombre, sexo);
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String getCodigo(){
        return codigo.codMin();
    }
    
    @Override
    public String toString() {
        return String.format("%-10s %-5s %-10s %-12d",
                             this.getNombre(),
                             this.getSexo(),
                             this.getCodigo(),
                             this.getEdad(),
                                  
    }
  
}
