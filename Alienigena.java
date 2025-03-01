/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.macota;

/**
 *
 * @author Leydi
 */
public abstract class Alienigena {
    private static int ncod=0;
    String tipo;

    public Alienigena(String tipo) {
        this.tipo = tipo;
    }
    public void setTipo(double tipo) {
        this.tipo = tipo;
    }

    public String getTipo() { // Corrección del error en el getter
        return tipo;
    }
    public abstract int Duermen();
    public abstract String Comen();
    public abstract String Atacan();
    
    public String generaCodigo(){
        return "ali-"+String.format("%04d",ncod++);
    }
    
}
