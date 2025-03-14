
package beta;
import java.io.Serializable;

public class CiberCompresor implements Serializable {

    private static final long serialVersionUID = 1L;

    //DECLARAMOS LOS ATRIBUTOS
    private String nombre; //NOMBRE DE LA MAQUINA
    private int consumo;  //VARIABLE DE 1 A 5 LITROS
    private String traccion; //VALORES RUEDAS O ORUGA
    private double proteccion; //VARIABLE DE 0 A 1

    public CiberCompresor(String nombre, int consumo, String traccion, double proteccion) {
        this.nombre = nombre;
        this.consumo = consumo;
        this.traccion = traccion;
        this.proteccion = proteccion;
    }

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
            throw new IllegalArgumentException("consumo debe estar entre 1 y 5 litros.");
        }

    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        if (traccion.equals("ruedas") || traccion.equals("oruga")) {
            this.traccion = traccion;
        } else {
            throw new IllegalArgumentException("Traccion debe ser ruedas o oruga");
        }

    }

    public double getProteccion() {
        return proteccion;
    }

    public void setProteccion(double proteccion) {
        if (proteccion >= 0 || proteccion <= 1) {
            this.proteccion = proteccion;
        } else {
            throw new IllegalArgumentException("Proteccion debe estar entre 0 y 1");
        }
    }

    //METODO PARA MOSTRAR INFORMACION DEL CIBERCOMPRESOR
    @Override
    public String toString() {
        return "CiberCompresor{"
                + "nombre='" + nombre + '\''
                + ", consumo=" + consumo
                + ", traccion='" + traccion + '\''
                + ", proteccion=" + proteccion
                + '}';
    }

}
