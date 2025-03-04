
package beta;


public class Persona extends Tripulacion {
    //Atributos
   private double peso;
   private double altura;
   private int edad;
   Codigo codigo=new Codigo();
//constructor
   public Persona(){
       
   }

    public Persona(double peso, double altura, int edad, String nombre, char sexo) {
        super(nombre, sexo);
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
    }

   
   //metodos

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    @Override
    public String getCodigo() {
        return codigo.codPer();
    }
  
}
