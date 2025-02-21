/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosphere;

/**
 *
 * @author sarag
 */
public class PropietarioMascota extends Mascotas {

    public PropietarioMascota(String nombre, String codigo) {
        super(nombre, codigo);
    }

    @Override
    public String Comunican() {
        return "Se esta comunicando";
    }

    @Override
    public String Duermen() {
        return "esta durmiendo";
    }

    @Override
    public String Comen() {
        return "esta comiendo";
    }
    
}
