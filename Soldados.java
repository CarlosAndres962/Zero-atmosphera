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
    static Codigo generadorCodigos = new Codigo();
    private static int ncod=0;
    public int graduacion;

    public Soldados() {
    }

    public Soldados(int graduacion, String nombre, char sexo) {
        super(nombre,sexo);
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
        return generadorCodigos.codSol();
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
    
    @Override
    public String toString() {
        return String.format("%-10s %-5s %-10s %-12d",
                             this.getNombre(),
                             this.getSexo(),
                             this.getCodigo(),
                             this.getGraduacion(),
                             this.armamento());
    }
}
