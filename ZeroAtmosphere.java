
package zeroatmosphere;
import java.util.Scanner;
public class ZeroAtmosphere {
   static int alienigenas = 0;
   
    static int cantidadSoldados = 0; //Inicialmente en 0, se actualizará dinámicamente
    static int cantidadMineros = 0;// Inicialmente en 0, se actualizará dinámicamente
    static Alienigena[] alienigenasArray = new Alienigena[0]; // Vector (array) de trabajos inicializado vacío.
    static Soldados[] sol = new Soldados[cantidadSoldados];// Inicialmente vacío
    static Mineros[] min = new Mineros[cantidadMineros];
    static Validador val=new Validador();
    
    static Scanner sc = new Scanner(System.in);

    static boolean operacionEnCurso = false;
    
    public static void main(String[] args) {
   
        int opcion = 0;
        
        do{
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1.Estado completo de la BlueStar-IV");
            System.out.println("2.Modificar tripulación o vehículos");
            System.out.println("3.Iniciar nueva operación");
            System.out.println("4.Finalizar operación");
            System.out.println("5.Salir");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    mostrarEstadoNave();
                    break;
                case 2:
                    break;
                case 3:
                    if (operacionEnCurso) {
                        System.out.println("No puedes iniciar una nueva operación mientras hay una en curso.");
                    } else {
                        costes(); 
                       break;
                    }
                break;
                case 4:
                    if (operacionEnCurso) {
                        operacionEnCurso = false; // Marca que la operación ha finalizado
                        System.out.println("Operación finalizada.");
                    } else {
                        System.out.println("No hay ninguna operación en curso para finalizar.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }while(opcion != 5);
        
        
      }  
  

   public static void costes(){
     
      
      //try{
          
     // sc.nextLine();
      System.out.println("Introduce el número de alienígenas:");
      alienigenas = sc.nextInt();
     /* Validador val=new Validador();
        val.validarnumero(alienigenas);
       num = Integer.parseInt(alienigenas);
    }catch (Excepciones e) {
            System.out.println(e.getMessage());
            }*/ 
      
      if (alienigenas == 0) {
        System.out.println("No se puede iniciar la operación con 0 alienígenas. Operación cancelada.");
        return; // Salir del método
      }else{
      
      cantidadSoldados = alienigenas * 2; // El número de soldados es el doble de alienígenas
      cantidadMineros = alienigenas * 2;  // El número de mineros es el doble de alienígenas
      
       
      
      sol = new Soldados[cantidadSoldados]; // Redimensionar el array de soldados
      min = new Mineros[cantidadMineros];   // Redimensionar el array de mineros
      
      crearSoldados(); // Llenar el array de soldados
      crearMineros();  // Llenar el array de mineros
      crearAlienigenas();
 
       // Costes unitarios por día
    int costeMinero = 20;
    int costeSoldado = 22;
    int penalizacionAlien = 4;
    int diasOperacion = 3;
    
    // Coste de combustible
    int numeroAerocars = 2; // Puedes cambiar esto si hay más Aerocars
    int consumoPorDia = 50; // Consumo de cada Aerocar en yurs
    int costeCombustible = numeroAerocars * consumoPorDia * diasOperacion;
    
    // Cálculo de costes
    int costeTripulacion = ((cantidadMineros * costeMinero) + (cantidadSoldados * costeSoldado) + (alienigenas * penalizacionAlien)) * diasOperacion;
    int costeTotal = costeTripulacion + costeCombustible;
    
    System.out.println("\n--- Información genérica de la operación ---");
    nombresSoldados(sol);
    nombresMineros(min);
    System.out.println("alienígenas esperados: "+ alienigenas);
    System.out.println("LAURA, A LA ESPERA DE CREAR TRIPULACION");
    System.out.println("AEROCARS, A LA ESPERA DE CREAR TRIPULACION");
    
    // Imprimir detalles
    System.out.println("\n--- Costes de la operación ---");
    System.out.println("Duración de la misión: " + diasOperacion + " días");
    System.out.println("Coste total tripulación: " + costeTripulacion + " yurs");
    System.out.println("Coste total combustible: " + costeCombustible + " yurs");
    System.out.println("Coste final de la operación: " + costeTotal + " yurs");
        
    System.out.println("\n--- Códigos  ---");
    
    codigosAlienigenas();
    codigosMineros();
    codigosSoldados();
    operacionEnCurso = false; // Ahora no hay operación en curso
    
    System.out.println("¿Deseas llevar a cabo la operación con estos costes? (S/N): ");
    char confirmacion = sc.next().charAt(0);

    if (confirmacion == 'S' || confirmacion == 's') {
    operacionEnCurso = true; // Marca que hay una operación en curso
    System.out.println("Operación iniciada.");
    } else {
    System.out.println("Operación cancelada.");
    }
                         
      
}

    
   }

public static char asignarSexoAleatorio(){
    int aleatorio = (int) (Math.random() * 2); // Asignar sexo aleatorio (0: Hombre, 1: Mujer)
    char sexo;
    if (aleatorio == 0) { 
        sexo = 'H';
    } else {
        sexo = 'M';
    }
    return sexo;
}
   
public static void crearSoldados(){
    String[] nombresMasculinos = {"Juan", "Carlos", "Miguel", "Luis", "Pedro", "José", "Antonio"};
    String[] nombresFemeninos = {"María", "Ana", "Laura", "Carmen", "Sofía", "Isabel", "Elena"};
        
    int contadorMasculinos = 0; 
    int contadorFemeninos = 0; //actua como índice para acceder a un elemento específico del array nombresFemeninos
    String nombreSoldado;
    
          
    for (int i = 0; i < cantidadSoldados; i++) { // bucle se ejecuta una vez por cada soldado en el array sol
        char sexoSoldado = asignarSexoAleatorio();
        if (sexoSoldado == 'H') {       
            nombreSoldado = nombresMasculinos[contadorMasculinos]+ contadorMasculinos;//accede al elemento del array nombresMasculinos en la posición indicada por contador y se asigna a nombreSoldado
            contadorMasculinos++; 
           if (contadorMasculinos >= nombresMasculinos.length) { // Verifica si el valor de contadorMasculinos es mayor o igual al tamaño del array.
            contadorMasculinos = 0; // Reiniciar el contador si se llega al final de la lista
            }
        }else{   
            nombreSoldado = nombresFemeninos[contadorFemeninos]+ contadorFemeninos;
            contadorFemeninos++;
            if (contadorFemeninos >= nombresFemeninos.length) {
            contadorFemeninos = 0; 
            }
        }
     
        // Generar código único para el soldado
        Soldados soldado = new Soldados((int) (Math.random() * 10) + 1, nombreSoldado, sexoSoldado);
        sol[i] = soldado; //Almacenar el objeto en el array
    }
 }      
public static void crearMineros(){
    String[] nombresMasculinos = {"Alejandro", "Andrés", "Diego", "Fernando", "Gabriel","Héctor", "Javier"};
    String[] nombresFemeninos = {"Adriana", "Beatriz", "Clara", "Diana", "Elena","Gabriela","Inés"};
        
    int contadorMasculinos = 0; 
    int contadorFemeninos = 0; //actua como índice para acceder a un elemento específico del array nombresFemeninos
    String nombreMinero;
    
        
    for (int i = 0; i < cantidadMineros; i++) { // bucle se ejecuta una vez por cada soldado en el array min
        char sexoMinero = asignarSexoAleatorio();
        if (sexoMinero == 'H') {
            nombreMinero = nombresMasculinos[contadorMasculinos]+contadorMasculinos;//accede al elemento del array nombresMasculinos en la posición indicada por contador y se asigna a nombreSoldado
            contadorMasculinos++; 
            if (contadorMasculinos >= nombresMasculinos.length) { // Verifica si el valor de contadorMasculinos es mayor o igual al tamaño del array.
            contadorMasculinos = 0; // Reiniciar el contador si se llega al final de la lista
            }
        } else {    
            nombreMinero = nombresFemeninos[contadorFemeninos]+contadorFemeninos;
            contadorFemeninos++;
            if (contadorFemeninos >= nombresFemeninos.length) {
            contadorFemeninos = 0; 
            }
        }
           
   // Generar código único para el minero
        Mineros minero = new Mineros((int) (Math.random() * 10) + 1, nombreMinero, sexoMinero);
        min[i] = minero; //Almacenar el objeto en el array
    }        
 }
 
public static void listaCompletaSoldados(Soldados[] soldados) {
    if (soldados != null && soldados.length > 0) { // Verifica que el array no sea nulo y tenga elementos
        // Imprimir encabezados
        System.out.println(String.format("%-10s %-5s %-10s %-12s", "Nombre", "Sexo", "Código", "Graduación"));

        // Imprimir cada soldado
        for (int i = 0; i < soldados.length; i++) {
            Soldados soldado = soldados[i];
            if (soldado != null) { // Verifica que el objeto no sea nulo
                System.out.println(soldado.toString()); 
            } else {
                System.out.println("Error: Soldado nulo en la posición " + i);
            }
        }
    } else {
        System.out.println("No hay soldados para mostrar.");
    }
}
 
public static void listaCompletaMineros(Mineros[] mineros) {
    if (mineros != null && mineros.length > 0) { // Verifica que el array no sea nulo y tenga elementos
        // Imprimir encabezados
        System.out.println(String.format("%-10s %-5s %-10s %-12s", "Nombre", "Sexo", "Código", "Edad"));

        // Imprimir cada minero
        for (int i = 0; i < mineros.length; i++) {
            Mineros minero = mineros[i];
            if (minero != null) { // Verifica que el objeto no sea nulo
                System.out.println(minero.toString());
            } else {
                System.out.println("Error: Minero nulo en la posición " + i);
            }
        }
    } else {
        System.out.println("No hay mineros para mostrar.");
    }
}

public static void nombresSoldados(Soldados[] soldados) {
    if (soldados != null && soldados.length > 0) { // Verifica que el array no sea nulo y tenga elementos
        System.out.println("Listado de nombres de soldados:");
        for (int i = 0; i < soldados.length; i++) {
            Soldados soldado = soldados[i];
            if (soldado != null) { // Verifica que el objeto no sea nulo
                System.out.println(soldado.getNombre());
                // Solo imprime el nombre
            } else {
                System.out.println("Error: Soldado nulo en la posición " + i);
            }
        }
    } else {
        System.out.println("No hay soldados para mostrar.");
    }
}

public static void nombresMineros(Mineros[] mineros) {
    if (mineros != null && mineros.length > 0) { // Verifica que el array no sea nulo y tenga elementos
        System.out.println("Listado de nombres de mineros:");
        for (int i = 0; i < mineros.length; i++) {
            Mineros minero = mineros[i];
            if (minero != null) { // Verifica que el objeto no sea nulo
                System.out.println(minero.getNombre()); // Solo imprime el nombre
            } else {
                System.out.println("Error: Minero nulo en la posición " + i);
            }
        }
    } else {
        System.out.println("No hay mineros para mostrar.");
    }
}

public static void mostrarEstadoNave() {
    
    // Mostrar tripulación (comentado hasta que sea creada)

        if (operacionEnCurso) {
            // Mostrar detalles de la operación en curso
            System.out.println("\n--- Estado Actual de la Nave ---");
            System.out.println("Operación en curso...");
            
            System.out.println("Detalles de la operación...");
            System.out.println("Número de alienígenas: " + alienigenas);
            System.out.println("Número de soldados: " + cantidadSoldados);
            System.out.println("Número de mineros: " + cantidadMineros);
            
             
        // Definir los costos fijos
        final int COSTE_MINERO = 20;
        final int COSTE_SOLDADO = 22;
        final int PENALIZACION_ALIEN = 4;
        final int DIAS_OPERACION = 3;

        // Cálculo de costes
        int costeTripulacion = ((cantidadMineros * COSTE_MINERO) + (cantidadSoldados * COSTE_SOLDADO) + (alienigenas * PENALIZACION_ALIEN)) * DIAS_OPERACION;
        int numeroAerocars = 2; // Suponiendo que estás usando 2 aerocars
        int consumoPorDia = 50; // Consumo de cada Aerocar en yurs
        int costeCombustible = numeroAerocars * consumoPorDia * DIAS_OPERACION;

        // Cálculo total
        int costeTotal = costeTripulacion + costeCombustible;

        // Mostrar los detalles del coste
        System.out.println("Coste total tripulación: " + costeTripulacion + " yurs");
        System.out.println("Coste total combustible: " + costeCombustible + " yurs");
        System.out.println("Coste final de la operación: " + costeTotal + " yurs");

        // Mostrar tripulación
        System.out.println("Soldados:");
        listaCompletaSoldados(sol);
        System.out.println("\nMineros:");
        listaCompletaMineros(min);
        System.out.println("\nalienigenas:");
        listaCompletaAliens(alienigenasArray);
        
        } else {
            System.out.println("\n--- Estado Actual de la Nave ---");
            System.out.println("No hay operación en curso.");
        }
    }
public static void codigosAlienigenas(){
    System.out.println("\nCódigos de los Alienígenas:");
        if (alienigenasArray.length > 0) {
            for (Alienigena alien : alienigenasArray) {
                if (alien != null) { // Asegúrate de que el objeto no es null
                    System.out.println(alien.getCodigo()); // Mostrar código del alienígena
                }
            }
        } else {
            System.out.println("No hay alienígenas asignados.");
        }
}

public static void codigosSoldados(){
     System.out.println("\nCódigos de los Soldados:");
        if (sol.length > 0) {
            for (Soldados soldado : sol) {
                if (soldado != null) { // Asegúrate de que el objeto no es null
                    System.out.println(soldado.getCodigo()); // Mostrar código del soldado
                }
            }
        } else {
            System.out.println("No hay soldados asignados.");
        }
}

public static void codigosMineros(){
    // Mostrar códigos de los mineros
        System.out.println("\nCódigos de los Mineros:");
        if (min.length > 0) {
            for (Mineros minero : min) {
                if (minero != null) { 
                    System.out.println(minero.getCodigo()); // Mostrar código del minero
                }
            }
        } else {
            System.out.println("No hay mineros asignados.");
        }
}


public static void crearAlienigenas() {
     Alienigena[] temporal = new Alienigena[alienigenas]; // // Copiar los elementos del array original al array temporal
    for (int i = 0; i < alienigenas; i++) {
        
        double autotraslacion = 0;
        int invisibilidad = 0;
        String tipo;
        
        if (Math.random() > 0.5) {
            tipo = "Nomun";
            autotraslacion = Math.random() * 100;
        } else {
            tipo = "Raiser";
            invisibilidad = (int) (Math.random() * 101);
        }

        // Crear el alienígena basado en el tipo y agregarlo al array temporal
        if (tipo.equals("Nomun")) {
            temporal[i] = new Nomun(autotraslacion);
        } else if (tipo.equals("Raiser")) {
            temporal[i] = new Raiser(invisibilidad);
        }

        // Asignar el array temporal al array original
        alienigenasArray = temporal;
    }
   }

public static void listaCompletaAliens(Alienigena[] alienigena){
 
    for (int i = 0; i < alienigenasArray.length; i++) {
           Alienigena alien = alienigenasArray[i];
            if (alien != null) { // Verifica que el objeto no sea nulo
                System.out.println(alien.toString());
            } else {
                System.out.println("Error: Alien nulo en la posición " + i);
            }
        }
}


}
    
        
       
        
         
    

