
package zeroatmosf;


public abstract class Tripulacion {
    //Atributos
    protected String nombre;
    protected char sexo;
    protected String codigo;
    
    //Construtores
    public Tripulacion() {
    }

    public Tripulacion(String nombre) {
        this.nombre = nombre;
    }
    

    public Tripulacion(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    

    public Tripulacion(String nombre, char sexo, String codigo) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.codigo = codigo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public abstract String generaCodigo();
    
    
}
