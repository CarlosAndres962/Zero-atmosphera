
package zeroatmosphere;
import java.util.Scanner;
import java.util.ArrayList;

public class ZeroAtmosphere {
    
    static Tripulacion[] trabajos = new Tripulacion[0]; // Vector (array) de trabajos inicializado vacío.
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
   
        int opcion = 0;
        
        do{
            System.out.println("1. Consulta tripulación completa y vehículos");
            System.out.println("2. Modifica tripulación o vehículos ");
            System.out.println("3. Calcular coste por operación ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                //Consula total
                case 2:
                //modificar
                case 3:
                //coste total
            }
        }while(opcion != 4);
        
        
      }  
    
   public void submenu(){
       int opcion = 0;
       do{
            System.out.println("1.Tripulación");
            System.out.println("2.Vehículos");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                //Consula total
                case 2:
                //modificar
            }
        }while(opcion != 4);
   }   
   
   
   
   public void Agregar(){
       
   }
   
   public void Borrar(){
       
   }
   
   public void Consultar(){
       
   }
   
  }

          
    
        
       
        
         
    

