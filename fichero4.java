
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
        try{
            setLonmango(lonmango); // VALIDAMOS QUE LONMANGO ESTE ENTRE 1 Y 5
            setMetal(metal); //VALIDAMOS VALORES PURO / ALEACION
            setProteccion(proteccion);//VALIDAMOS PROTECCION ENTRE 0 Y 1
        }catch (Excepciones e)
        {System.err.println("Error: "+e);}
    }

    public String getNombre() {
        return nombre;
    }

    public int getLonmango() {
        return lonmango;
    }

    public void setLonmango(int lonmango) throws Excepciones{
        if (lonmango >= 1 && lonmango <= 5) {
            this.lonmango = lonmango;
        } else {
            throw new Excepciones("Lonmango debe estar entre 1 y 5");
        }
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) throws Excepciones{
        if (metal.equals("puro") || metal.equals("aleacion")) {
            this.metal = metal;
        } else {
            throw new Excepciones("metal debe ser puro o de aleacion");
        }
    }

    public String getProteccion() {
        return proteccion;
    }

    public void setProteccion(String proteccion) throws Excepciones{
        if (proteccion.equals("pvc") || proteccion.equals("vinilo")) {
            this.proteccion = proteccion;
        } else {
            throw new Excepciones("proteccion debe ser 'pvc' o 'vinilo'");
        }
    }
//METODO PARA MOSTRAR INFORMACION DE LA MAQUINARIA PALA

    @Override
    public String toString() {
        return "Pala{"
                + "nombre='" + nombre + '\''
                + ", lonmango=" + lonmango
                + ", metal='" + metal + '\''
                + ", proteccion='" + proteccion + '\''
                + '}';
    }

}
