
package beta;

import java.io.Serializable;

public class Pala implements Serializable {

    private static final long serialVersionUID = 1L;

    //DECLARAMOS LOS ATRIBUTOS EN PRIVADO
    private String nombre; //NOMBRE DE LA MAQUINA 
    private int lonmango; //VARIABLE DE 1 A 5 METROS
    private String metal; //VALORES PURO / ALEACION
    private String proteccion; // PVC / VINILO

    public Pala(String nombre, int lonmango, String metal, String proteccion) {
        this.nombre = nombre;
        setLonmango(lonmango); // VALIDAMOS QUE LONMANGO ESTE ENTRE 1 Y 5
        setMetal(metal); //VALIDAMOS VALORES PURO / ALEACION
        setProteccion(proteccion);//VALIDAMOS PROTECCION ENTRE 0 Y 1
    }

    public String getNombre() {
        return nombre;
    }

    public int getLonmango() {
        return lonmango;
    }

    public void setLonmango(int lonmango) {
        if (lonmango >= 1 && lonmango <= 5) {
            this.lonmango = lonmango;
        } else {
            throw new IllegalArgumentException("Lonmango debe estar entre 1 y 5");
        }

    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        if (metal.equals("puro") || metal.equals("aleacion")) {
            this.metal = metal;
        } else {
            throw new IllegalArgumentException("metal debe ser puro o de aleacion");
        }
        {

        }

    }

    public String getProteccion() {
        return proteccion;
    }

    public void setProteccion(String proteccion) {
        if (proteccion.equals("pvc") || proteccion.equals("vinilo")) {
            this.proteccion = proteccion;

        } else {
            throw new IllegalArgumentException("proteccion debe ser 'pvc' o 'vinilo'");
        }
    }
//METODO PARA MOSTRAR INFORMACION DE LA MAQUINARIA PALA

    public void mostrarInfo() {
        System.out.println("Pala: " + nombre);
        System.out.println("Longitud del mango: " + lonmango + "metros");
        System.out.println("Material del Metal: " + metal);
        System.out.println("Proteccion: " + proteccion);
    }

}
