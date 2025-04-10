package zeroatmospher;


public class Nomun extends Alienigena {
// Atriutos
    private double autotraslacion; 
    int nrandom;
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
        if (randomCome() == 1) {
            nrandom=1;
            return "El alienigena esta comiendo";
        } else {
            nrandom=0;
            return "El alienigena no esta comiendo";
        }
    }

    @Override
    public String Atacan() {
        if (nrandom==0) {
            return "El alienigena esta atacando";
            }
        return "El alienigena no esta atacando";
    }

    @Override
    public String tipoAtaque(){
        return "El aliegnigena ataca con su cola que tiene como punta de cuchillo";
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
        detalles += tipoAtaque()+"\n";
        detalles += ("----------------------");
        return detalles;
      
    }
}
   
