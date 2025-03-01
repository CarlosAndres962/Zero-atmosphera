package beta;


public class Nomun extends alienigena {
// Atriutos
    private double autotraslacion;  
 //constructor   
    public Nomun(String tipo, double autotraslacion) {
        super(tipo);
        this.autotraslacion=autotraslacion;
    }
// Metodos

    public double getAutotraslacion() {
        return autotraslacion;
    }

    public void setAutotraslacion(double autotraslacion) {
        this.autotraslacion = autotraslacion;
    }
      @Override
    public int Duermen() {
        return 15;
    }

    @Override
    public String Comen() {
        return (Math.random() < 0.5) ? "El alienígena está comiendo" : "El alienígena no está comiendo";
    }

    @Override
    public String Atacan() {
        return (Math.random() < 0.5) ? "El alienígena está atacando" : "El alienígena no está atacando";
    }
    
     @Override
    public String toString() {
        return "Nomun{" +
               "tipo='" + getTipo() + '\'' +
               ", autotraslacion=" + autotraslacion +
               '}';
    }
}
   
