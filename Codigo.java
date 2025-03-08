/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmospher;

/**
 *
 * @author Pochado
 */
public class Codigo {
    //contadores estaticos 
    private static int contper = 0;
    private static int contcars = 0;
    private static int contali = 0;
    private static int contmas = 0;
    private static int contmin = 0;
    private static int contsol = 0;
    
    //constructor vacio
    public Codigo() {
    }

    public static void reiniciarContadores() {
        contper = 0;
        contcars = 0;
        contali = 0;
        contmas = 0;
        contmin = 0;
        contsol = 0;
    }
    
    //metodos con incremento de contador y retorno de string con codigo unico
    public String codPer() {
        contper++;
        return "per-"+String.format("%04d", contper);
    }
    public String codCars(){
        contcars++;
        return "car-"+String.format("%04d", contcars);
    }
    public String codAli(){
        contali++;
        return "ali-"+String.format("%04d", contali);
    }
    public String codMas(){
        contmas++;
        return "car-"+String.format("%04d", contmas);
    }
    public String codMin() {
        contmin++;
        return "min-"+String.format("%04d", contmin);
    }
    public String codSol() {
        contsol++;
        return "sol-"+String.format("%04d", contsol);
    }
}
