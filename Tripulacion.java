
package zeroatmosf;


public abstract class Tripulacion {
    //Atributos
    protected String nombre;
    protected char sexo;
    
    //Construtores
    public Tripulacion() {
    }

    public Tripulacion(String nombre,char sexo) {
        this.nombre = nombre;
        this.sexo=sexo;
    }
    

    public Tripulacion(String nombre, String codigo) {
        this.nombre = nombre;
    }
    

    public Tripulacion(String nombre, char sexo, String codigo) {
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
