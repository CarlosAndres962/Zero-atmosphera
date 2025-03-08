
package zeroatmospher;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ZeroAtmosphere {
    static int alienigenas = 0;
    static String confirmacion="";
   
    static int cantidadSoldados = 0; //Inicialmente en 0, se actualizará dinámicamente
    static int cantidadMineros = 0;// Inicialmente en 0, se actualizará dinámicamente
    static ArrayList<Alienigena>alienArray = new ArrayList<>(); // Vector (array) de trabajos inicializado vacío.
    static ArrayList<Soldados> solArray = new ArrayList<>();
    static ArrayList<Mineros> minArray = new ArrayList<>();
    static Validador val=new Validador();
    
    static Scanner sc = new Scanner(System.in);

    static boolean operacionEnCurso = false;
    
    public static void main(String[] args) {
   
        String op="";
            do{
                try{
                    System.out.println("\n--- Menú Principal ---");
                    System.out.println("1.Estado completo de la BlueStar-IV");
                    System.out.println("2.Modificar tripulación o vehículos");
                    System.out.println("3.Iniciar nueva operación");
                    System.out.println("4.Finalizar operación");
                    System.out.println("5.Salir");
                    op = sc.nextLine();
                    val.validarnumero(op);
                }catch(Excepciones e){
                    System.out.println(e.getMessage());
                }
            switch (op) {
                case "1":
                    mostrarEstadoNave();
                    break;
                case "2":
                    break;
                case "3":
                    if (operacionEnCurso) {
                        System.out.println("No puedes iniciar una nueva operación mientras hay una en curso.");
                    } else {
                        iniciarOperacion();
                       break;
                    }
                    break;
                case "4":
                    finalizarOperacion();
                    break;
                case "5":
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }while(!op.equals("5"));
        
        
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
            System.out.println("Número de mineros: " + cantidadMineros+"\n");
            
            mostrarCostesOperacion();

        // Mostrar tripulación
            System.out.println("Soldados:");
            listaCompletaSoldados(solArray);
            System.out.println("\nMineros:");
            listaCompletaMineros(minArray);
            System.out.println("\nalienigenas:");
            listaCompletaAliens(alienArray);
        
        } else {
            System.out.println("\n--- Estado Actual de la Nave ---");
            System.out.println("No hay operación en curso.");
        }
    }

public static void iniciarOperacion(){
    System.out.println("Introduce el número de alienígenas:");
    String ali=sc.nextLine();
      
    try{
        val.validarnumero(ali);
        alienigenas = Integer.parseInt(ali);
        }catch (InputMismatchException e) {
           System.out.println(e.getMessage());
        }catch (Excepciones e) {
            System.out.println(e.getMessage());
        } 
    while(alienigenas!=0 && alienigenas>0){
        cantidadSoldados = alienigenas * 2; // El número de soldados es el doble de alienígenas
        cantidadMineros = alienigenas * 2;  // El número de mineros es el doble de alienígenas
      
        crearSoldados(); 
        crearMineros();  
        crearAlienigenas();
    
        System.out.println("\n--- Información genérica de la operación ---");
        nombresSoldados(solArray);
        nombresMineros(minArray);
        System.out.println("alienígenas esperados: "+ alienigenas);
        System.out.println("LAURA, A LA ESPERA DE CREAR TRIPULACION");
        System.out.println("AEROCARS, A LA ESPERA DE CREAR TRIPULACION");
    
        System.out.println("\n--- Códigos  ---");
        codigosAlienigenas();
        codigosMineros();
        codigosSoldados();
        operacionEnCurso = false; // Ahora no hay operación en curso
        System.out.println("\n--- Costes de la operación ---");
        mostrarCostesOperacion();
        
        try{
            System.out.println("¿Deseas llevar a cabo la operación con estos costes? (S/N): ");
            confirmacion = sc.nextLine().toLowerCase();
            val.validaChar(confirmacion);
        }catch (Excepciones e){
            System.out.println(e.getMessage());
        }
    
        if (confirmacion.equals("s")) {
            operacionEnCurso = true;
            Codigo.reiniciarContadores();
            System.out.println("Operación iniciada.");
        } else {
            System.out.println("Operación cancelada.");
            Codigo.reiniciarContadores();
            
        } 
    break;
        }     
    }
public static void finalizarOperacion() {
    if (operacionEnCurso) {
        operacionEnCurso = false; // Marcar que la operación ha finalizado
        Codigo.reiniciarContadores(); // Reiniciar los contadores de códigos
        System.out.println("Operación finalizada");
    } else {
        System.out.println("No hay ninguna operación en curso para finalizar.");
    }
}
private static void mostrarCostesOperacion() {
    final int COSTE_MINERO = 20;
    final int COSTE_SOLDADO = 22;
    final int PENALIZACION_ALIEN = 4;
    final int DIAS_OPERACION = 3;
    
    int numeroAerocars = 2; // Suponiendo que estás usando 2 aerocars
    int consumoPorDia = 50;
        
    int costeTripulacion = ((cantidadMineros * COSTE_MINERO) + (cantidadSoldados * COSTE_SOLDADO) + (alienigenas * PENALIZACION_ALIEN)) * DIAS_OPERACION;
    int costeCombustible = numeroAerocars * consumoPorDia * DIAS_OPERACION;
    int costeTotal = costeTripulacion + costeCombustible;

    System.out.println("Duración de la misión: " + DIAS_OPERACION + " días");
    System.out.println("Coste total tripulación: " + costeTripulacion + " yurs");
    System.out.println("Coste total combustible: " + costeCombustible + " yurs");
    System.out.println("Coste final de la operación: " + costeTotal + " yurs\n");
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
        solArray.add(soldado); //Almacenar el objeto en el array
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
        Mineros minero = new Mineros((int) (Math.random() * (65 - 18 + 1)) + 18, nombreMinero, sexoMinero);
        minArray.add(minero); 
    }        
 }
public static void crearAlienigenas() {
    for (int i = 0; i < alienigenas ; i++) {
        
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

        Alienigena alien; //declaramos una variable llamada alien que puede almacenar un objeto de tipo Alienigena.
            if (tipo.equals("Nomun")) {
                alien = new Nomun(autotraslacion);
            } else {
                alien = new Raiser(invisibilidad);
            }
        alienArray.add(alien);
    }
   }
 
public static void listaCompletaSoldados(ArrayList<Soldados> soldados) {
    if (soldados == null || soldados.isEmpty()) {
        System.out.println("No hay soldados para mostrar.");
        return; // Salir del método si no hay soldados o si la lista es nula
    }

    // Imprimir encabezados
    System.out.println(String.format("%-10s %-5s %-10s %-12s", "Nombre", "Sexo", "Código", "Graduación"));

    // Imprimir cada soldado
    for (Soldados soldado : soldados) {
        if (soldado != null) { // Verifica que el objeto no sea nulo
            System.out.println(soldado.toString());
        } else {
            System.out.println("Error: Soldado nulo encontrado.");
        }
    }
}
 
public static void listaCompletaMineros(ArrayList<Mineros> mineros) {
    if (mineros == null || mineros.isEmpty()) {
        System.out.println("No hay soldados para mostrar.");
        return; // Salir del método si no hay soldados o si la lista es nula
    }

    // Imprimir encabezados
    System.out.println(String.format("%-10s %-5s %-10s %-12s", "Nombre", "Sexo", "Código", "Graduación"));

    // Imprimir cada soldado
    for (Mineros minero : mineros) {
        if (minero != null) { // Verifica que el objeto no sea nulo
            System.out.println(minero.toString());
        } else {
            System.out.println("Error: Soldado nulo encontrado.");
        }
    }
}

public static void listaCompletaAliens(ArrayList<Alienigena> alienigenasArray){
     if (alienigenasArray == null || alienigenasArray.isEmpty()) {
        System.out.println("No hay alienígenas para mostrar.");
        return;
    }

    for (Alienigena alien : alienigenasArray) {
        if (alien != null) {
            System.out.println(alien.toString());
        } else {
            System.out.println("Error: Alien nulo encontrado.");
        }
    }
}

public static void nombresSoldados(ArrayList<Soldados> soldados) {
     if (soldados == null || soldados.isEmpty()) {
        System.out.println("No hay soldados para mostrar.");
        return;
    }

    System.out.println("\nListado de nombres de soldados:");
    
    for (Soldados soldado : soldados) {
        if (soldado != null) {
            System.out.println(soldado.getNombre());
        } else {
            System.out.println("Error: Soldado nulo encontrado.");
        }
    }
}

public static void nombresMineros(ArrayList<Mineros> mineros) {
      if (mineros == null || mineros.isEmpty()) {
        System.out.println("No hay soldados para mostrar.");
        return;
    }

    System.out.println("\nListado de nombres de soldados:");
    
    for (Mineros minero : mineros) {
        if (minero != null) {
            System.out.println(minero.getNombre());
        } else {
            System.out.println("Error: Soldado nulo encontrado.");
        }
    }
}

public static void codigosAlienigenas(){
    System.out.println("\nCódigos de los Alienígenas:");
     if(alienArray == null || alienArray.isEmpty()){
         System.out.println("No hay alienígenas asignados.");
        return; // Salir del método si la lista es nula o está vacía
     }
     for (Alienigena alien : alienArray) {
        if (alien != null) {
            System.out.println(alien.getCodigo()); // Mostrar código del minero
        }
    } 
}

public static void codigosSoldados(){
     System.out.println("\nCódigos de los Soldados:");
     
     if(solArray == null || solArray.isEmpty()){
         System.out.println("No hay soldados asignados.");
        return; // Salir del método si la lista es nula o está vacía
     }
     for (Soldados soldado : solArray) {
        if (soldado != null) {
            System.out.println(soldado.getCodigo()); // Mostrar código del minero
        }
    } 
}

public static void codigosMineros(){
    System.out.println("\nCódigos de los Mineros:");
    
    if (minArray == null || minArray.isEmpty()) {
        System.out.println("No hay mineros asignados.");
        return; // Salir del método si la lista es nula o está vacía
    }

    for (Mineros minero : minArray) {
        if (minero != null) {
            System.out.println(minero.getCodigo()); // Mostrar código del minero
        }
    }
   }
}

         
    

