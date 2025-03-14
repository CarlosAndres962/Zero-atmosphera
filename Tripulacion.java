
package beta;
import java.util.Scanner;


public abstract class tripulacion implements Armas {
      //Atributos
    protected String nombre;
    protected char sexo;
    
    //Construtores
    public tripulacion() {
   
    }

    public tripulacion(String nombre, char sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }
    //Metodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    } 
    public abstract String getCodigo();

   
    
}

