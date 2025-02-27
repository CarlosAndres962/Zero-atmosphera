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
    public String Duermen() {
    int n1 =(int) (Math.random()*2) +1;
    if (n1 == 1){
        return "Esta durmiendo";
    }
    else {
        return "Esta despierto";
    }
    }

    @Override
    public String Comen() {
       int n2 =(int) (Math.random()*2) +1;
    if (n2 == 1){
        return "Esta comiendo";
    }
    else {
        return "No esta comiendo";
    }
        
    }

    @Override
    public String Atacan() {
        int n3 =(int) (Math.random()*2) +1;
    if (n3 == 1){
        return "Esta atacando";
    }
    else {
        return "No esta atacando";
    }
    }
    
}
