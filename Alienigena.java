/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmospher;

/**
 *
 * @author Leydi
 */
public abstract class Alienigena {
    private Codigo codigo=new Codigo();
    String tipo;

    public Alienigena(String tipo) {
        this.tipo = tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() { // Corrección del error en el getter
        return tipo;
    }

    public String getCodigo() {
        return codigo.codAli();
    }
    
    public abstract int Duermen();
    public abstract String Comen();
    public abstract String Atacan();
    
    
}
