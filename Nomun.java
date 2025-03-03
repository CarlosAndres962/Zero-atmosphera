package zeroatmospher;


public class Nomun extends Alienigena {
// Atriutos
    private double autotraslacion;  
 //constructor   
    public Nomun(double autotraslacion) {
        this.autotraslacion=autotraslacion;
    }
// Metodos

    public double getAutotraslacion() {
        return autotraslacion;
    }

    public void setAutotraslacion(double autotraslacion) {
        this.autotraslacion = autotraslacion;
    }
    
    public int randomCome(){
        int c = (int) (Math.random() * 2);
        return c;
    }
    
    @Override
    public int Duermen() {
        return 15;
    }

    @Override
    public String Comen() {
        if (randomCome() == 0) {
            return "El alienigena esta comiendo";
        } else {
            return "El alienigena no esta comiendo";
        }
    }

    @Override
    public String Atacan() {
        int numeroAleatorio = (int) (Math.random() * 2); // Genera 0 o 1
        if (randomCome()!=0) {
            if (numeroAleatorio == 0) {
            return "El alienigena esta atacando";
            }
        }
        return "El alienigena no esta atacando";
    }
    
    
     @Override
    public String toString() {
        String detalles= "";
        detalles += "Información del Alienígena:\n";
        detalles += "Tipo: Nomun\n";
        detalles += "Código " + getCodigo()+ "\n";
        detalles += "Autotraslación " + String.format("%.2f", getAutotraslacion())+ "\n";
        detalles += "Duermen " + Duermen() + "horas\n";
        detalles += Comen()+"\n";
        detalles += Atacan()+"\n";
        detalles += ("----------------------");
        return detalles;
      
    }
}
   
