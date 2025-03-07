/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosphere;

/**
 *
 * @author sarag
 */
public class Pajaros extends Mascotas{
    
    public Pajaros(String nombre, char sexo) {
        super(nombre, sexo);
    }
    public String especie;

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }


    @Override
    public String Comunican() {
      return "estan cantando";
    }

    @Override
    public String Duermen() {
      return "estan durmiendo";
    }

    @Override
    public String Comen() {
        return "esatn comiendo semillas";
    }
    
}
