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
        int numeroAleatorio = (int) (Math.random() * 2); // Genera 0 o 1
        if (numeroAleatorio == 0) {
            return "El alienígena está comiendo";
        } else {
            return "El alienígena no está comiendo";
        }
    }

    @Override
    public String Atacan() {
        int numeroAleatorio = (int) (Math.random() * 2); // Genera 0 o 1
        if (numeroAleatorio == 0) {
            return "El alienígena está atacando";
        } else {
            return "El alienígena no está atacando";
        }
    }
    
     @Override
    public String toString() {
        return "Nomun{" +
               "tipo='" + getTipo() + '\'' +
               ", autotraslacion=" + autotraslacion +
               '}';
    }
}
   
