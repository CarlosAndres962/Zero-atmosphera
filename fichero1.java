
package beta;

package binarios;
import java.io.Serializable;

public class CiberExcavadora implements Serializable{
    //declaramos los atributos 
    private static final long serialVersionUID = 1L; //RECOMENDADO PARA LA VERSION DEL OBJETO.
    private final String nombre;
    private int consumo;
    private String traccion;
    private double proteccion;

    public CiberExcavadora(String nombre, int consumo, String traccion, double proteccion) {
        this.nombre = nombre;
        setConsumo(consumo);//VALIDAMOS EL RANGO DEL CONSUMO.
        setTraccion(traccion); // VALIDAMOS ENTRE RUEDAS U ORUGAS.
        setProteccion(proteccion); //VALIDAMOS EL RANGO DE PROTECCION ENTRE 0 Y 1.
    }

    //METODOS GETTERS Y SETTERS CON VALIDACIONES
    public String getNombre() {
        return nombre;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        if (consumo >= 1 && consumo <= 5) {
            this.consumo = consumo;
        } else {
            throw new IllegalArgumentException("Consumo debe estar entre 1 y 5");
        }
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        if (traccion.equals("ruedas") || traccion.equals("oruga")) {
            this.traccion = traccion;

        } else {
            throw new IllegalArgumentException("Traccion debe ser 'ruedas' u 'oruga'.");
        }
    }

    public double getProteccion() {
        return proteccion;
    }
//METODO PARA VALIDAR PROTECCION
    public void setProteccion(double proteccion) {
        if (proteccion >= 0 && proteccion <= 1) {
            this.proteccion = proteccion;

        } else {
            throw new IllegalArgumentException("Proteccion debe estar entre 0 y 1 ");
        }

    }
//METODO PARA MOSTRAR INFORMACION DE LA MAQUINA CIBEREXCAVADORA
    public void mostrarInfo() {
        System.out.println("Maquina: "+ nombre);
        System.out.println("Consumo: "+consumo);
        System.out.println("Traccion: "+traccion);
        System.out.println("Proteccion: "+proteccion);
        
    }

}
