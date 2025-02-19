/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.macota;

/**
 *
 * @author Administrador
 */
public abstract class Alienigena {
    String tipo;

    public Alienigena(String tipo) {
        this.tipo = tipo;
    }
    
    public abstract void Duermen();
    public abstract void Comen();
    public abstract void Atacan();
    
    
    
}
