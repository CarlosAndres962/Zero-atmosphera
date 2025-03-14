
package beta;

import java.io.Serializable;

public class Martillo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre; //NOMBRE DE LA MAQUINA
    private int consumo; //VARIABLE DE 200 A 300KW
    private String sujeccion; // MANUAL/CORREA
    private double proteccion; //VARIABLE DE 0 A 1 

    public Martillo(String nombre, int consumo, String sujeccion, double proteccion) {
        this.nombre = nombre;
        setConsumo(consumo);  //VALIDAMOS EL RANGO(200-300)
        setSujeccion(sujeccion);//VALIDAMOS QUE SEA "MANUAL O "CORREA"
        setProteccion(proteccion);//VALIDAMOS EL RANGO(0-1)
    }

    public String getNombre() {
        return nombre;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        if (consumo >= 200 && consumo <= 300) {
            this.consumo = consumo;

        } else {
            throw new IllegalArgumentException("Consumo debe estar entre 200 y 300 kw");
        }
    }

    public String getSujeccion() {
        return sujeccion;
    }

    public void setSujeccion(String sujeccion) {
        if (sujeccion.equals("manual") || sujeccion.equals("correa")) {
            this.sujeccion = sujeccion;
        } else {
            throw new IllegalArgumentException("Sujeccion debe ser 'manual' o 'correa'");

        }
    }

    public double getProteccion() {
        return proteccion;
    }

    public void setProteccion(double proteccion) {
        if (proteccion >= 0 && proteccion <= 1) {
            this.proteccion = proteccion;
        } else {
            throw new IllegalArgumentException("Proteccion debe estar entre 0 y 1. ");
        }
    }

    //METODO PARA MOSTRAR INFORMACION DEL MARTILLO
    @Override
    public String toString() {
        return "Martillo{"
                + "nombre='" + nombre + '\''
                + ", consumo=" + consumo
                + ", sujeccion='" + sujeccion + '\''
                + ", proteccion=" + proteccion
                + '}';
    }

}
