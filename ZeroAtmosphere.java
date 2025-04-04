package zeroatmosphere;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//1 ganando se cierra y perdiendo
/**
 *
 * @author fani
 */
public class ZeroAtmosphere {
    static Scanner sc = new Scanner(System.in);
    
    static int alienigenas = 0;
    static String confirmacion="";
    static int cantidadSoldados = 0; //Inicialmente en 0, se actualizará dinámicamente
    static int cantidadMineros = 0;// Inicialmente en 0, se actualizará dinámicamente
    static boolean operacionEnCurso = false;
    
    static ArrayList<Alienigena>alienArray = new ArrayList<>();
    static ArrayList<Soldados> solArray = new ArrayList<>();
    static ArrayList<Mineros> minArray = new ArrayList<>();
    
    static Validador val=new Validador();
    
    
    //FALTA ORDERNAR BIEN EL MENU INCLUIR FICHEROS Y OPCION 2 DEL MAIN 
    
    public static void main(String[] args) {
   
        String op="";
            do{
                try{
                    System.out.println("\n--- Menú Principal ---");
                    System.out.println("1.Estado completo de la BlueStar-IV");
                    System.out.println("2.Modificar tripulación o vehículos");
                    System.out.println("3.Iniciar nueva operación");
                    System.out.println("4.Finalizar operación");
                    System.out.println("6.Ficheros");
                    System.out.println("7.Desafíos con recompensas");
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
                case "6":
                    System.out.println("Información de ficheros");
                    creacionFicheros();
                    lecturaFicheros();
                    break;
                case "7":
                    menuJuegos();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }while(!op.equals("6"));
        
        
      }  
    
    public static void menuJuegos(){
 //utiliza la biblioteca Swing para crear una interfaz gráfica de usuario (GUI)
 System.out.println("Si logras superar alguna de las pruebas, recibirás 2 soldados y mineros extras a tu misión. SUERTE!!");
 System.out.println("1. Adivina el número\n2. Tres en raya\n3. Seguir secuencia\n4. Volver al menú principal");
 String opcionMinijuegostr = sc.nextLine(); 
  int opcionMinijuego = Integer.parseInt(opcionMinijuegostr);                       
  switch (opcionMinijuego) {
    case 1:
        iniciarAdivinaNumero();
        break;
    case 2:
        iniciarTresEnRaya();
        break;
    case 3:
        iniciarSeguirSecuencia();
        break;
    case 4:
        break;
    default:
        System.out.println("Opción no válida. Intente de nuevo.");
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
    
   
    int soldadosACrear; // Declaramos la variable primero
    if (operacionEnCurso) {
        soldadosACrear = 2;
    } else {
        soldadosACrear = 2;
    }
          
    for (int i = 0; i < soldadosACrear; i++) { // bucle se ejecuta una vez por cada soldado en el array sol
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
    cantidadSoldados += soldadosACrear; // Actualizar la cantidad total de soldados

 }      
    public static void crearMineros(){
    String[] nombresMasculinos = {"Alejandro", "Andrés", "Diego", "Fernando", "Gabriel","Héctor", "Javier"};
    String[] nombresFemeninos = {"Adriana", "Beatriz", "Clara", "Diana", "Elena","Gabriela","Inés"};
        
    int contadorMasculinos = 0; 
    int contadorFemeninos = 0; //actua como índice para acceder a un elemento específico del array nombresFemeninos
    String nombreMinero;
    
    
    int minerosACrear; // Declaramos la variable primero
    if (operacionEnCurso) {
        minerosACrear = 2;
    } else {
        minerosACrear = 2;
    }
        
    for (int i = 0; i < minerosACrear; i++) { // bucle se ejecuta una vez por cada soldado en el array min
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
    cantidadMineros += minerosACrear; // Actualizar la cantidad total de soldados
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
    System.out.println(String.format("%-10s %-5s %-10s %-12s", "Nombre", "Sexo", "Código", "Edad"));

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


    public static void creacionFicheros() {
        /*
    try {
            //CREAMOS OBJETOS DE CADA CLASE 
            CiberExcavadora ciberexcavadora = new CiberExcavadora("CiberExcavadora-PZK", 4, "ruedas", 0.9);
            Martillo martillo = new Martillo("Martillo Hidraulico", 230, "manual", 0.3);
            Pala pala = new Pala("Pala de Excavacion", 3, "aleacion", "pvc");
            CiberCompresor cibercompresor = new CiberCompresor("Compresor Industrial", 3, "ruedas", 0.6);

            //crear los archivos binarios para cada maquina
            
            ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("/Users/fani/Desktop/Binarios/mov_tierra.dat"));
            oos1.writeObject(ciberexcavadora);
            oos1.close();

            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("/Users/fani/Desktop/Binarios/martillo.dat"));
            oos2.writeObject(martillo);
            oos2.close();

            ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("/Users/fani/Desktop/Binarios/manual_pala.dat"));
            oos3.writeObject(pala);
            oos3.close();

            ObjectOutputStream oos4 = new ObjectOutputStream(new FileOutputStream("/Users/fani/Desktop/Binarios/cibercompresor.dat"));
            oos4.writeObject(cibercompresor);
            oos4.close();

            System.out.println("Archivos binarios creados exitosamente.");

        } catch (IOException e) {
            e.printStackTrace();

        }
*/  Random random = new Random();

        try {
            //CREAMOS OBJETOS DE CADA CLASE 

            //crear los archivos binarios para cada maquina
            ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("/Users/fani/Desktop/Binarios/mov_tierra.dat"));
            for (int i = 0; i < 10; i++) {
                CiberExcavadora ciberexcavadora = new CiberExcavadora(
                        "CiberExcavadora" + (i + 1),
                        random.nextInt(5) + 1,
                        random.nextBoolean() ? "ruedas" : "oruga",
                        random.nextDouble()
                );

                oos1.writeObject(ciberexcavadora);
            }
            oos1.close();

            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("/Users/fani/Desktop/Binarios/martillo.dat"));
            for (int i = 0; i < 10; i++) {
                Martillo martillo = new Martillo(
                        "Martillo" + (i + 1),
                        random.nextInt(101) + 200,
                        random.nextBoolean() ? "manual" : "correa",
                        random.nextDouble()
                );

                oos2.writeObject(martillo);
            }
            oos2.close();

            ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("/Users/fani/Desktop/Binarios/manual_pala.dat"));
            for (int i = 0; i < 10; i++) {
                Pala pala = new Pala(
                        "CiberExcavadora" + (i + 1),
                        random.nextInt(5) + 1,
                        random.nextBoolean() ? "puro" : "aleacion",
                        random.nextBoolean() ? "pvc" : "vinilo"
                );

                oos3.writeObject(pala);
            }
            oos1.close();

            ObjectOutputStream oos4 = new ObjectOutputStream(new FileOutputStream("/Users/fani/Desktop/Binarios/cibercompresor.dat"));
            for (int i = 0; i < 10; i++) {
                CiberCompresor cibercompresor = new CiberCompresor(
                        "CiberCompresor" + (i + 1),
                        random.nextInt(5) + 1,
                        random.nextBoolean() ? "ruedas" : "oruga",
                        random.nextDouble()
                );

                oos4.writeObject(cibercompresor);
            }
            oos4.close();

            System.out.println("Archivos binarios creados exitosamente.");

        } catch (IOException e) {
            e.printStackTrace();

        }

    
    }
    public static void lecturaFicheros(){
        try {
            // Leer los arichvos binarios deserializar los objetos

            //Ciberexcavadora
            ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("/Users/fani/Desktop/Binarios/mov_tierra.dat"));
            CiberExcavadora ciberexcavadora = (CiberExcavadora) ois1.readObject();
            ois1.close();
            ciberexcavadora.toString();

            //Martillo
            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("/Users/fani/Desktop/Binarios/martillo.dat"));
            Martillo martillo = (Martillo) ois2.readObject();
            ois2.close();
            martillo.toString();
            
            //Pala
            ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream("/Users/fani/Desktop/Binarios/Manual_pala.dat"));
            Pala pala = (Pala) ois3.readObject();
            ois3.close();
            pala.toString();
            
            //Cibercompresor
            ObjectInputStream ois4 = new ObjectInputStream(new FileInputStream("/Users/fani/Desktop/Binarios/cibercompresor.dat"));
            CiberCompresor cibercompresor = (CiberCompresor) ois4.readObject();
            ois4.close();
            cibercompresor.toString();
            
            System.out.println("Archivos binarios leidos y objetos restaurados correctamente.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            }
    }
    
    
    
    public static void iniciarAdivinaNumero() {
    AdivinaNumero adivinaNumero = new AdivinaNumero(); // Crea una nueva instancia del juego AdivinaNumero.
    adivinaNumero.setVisible(true); // Hace visible la ventana del juego.

    // Esperar a que el juego termine
    while (adivinaNumero.isVisible()) { // Bucle que se ejecuta mientras la ventana del juego esté visible.
        try {
            Thread.sleep(100); // Pausa la ejecución del hilo durante 100 milisegundos.
        } catch (InterruptedException e) {
            e.printStackTrace(); // Imprime la traza de la excepción si el hilo es interrumpido.
        }
    }

    // Verificar si el jugador ganó
    if (adivinaNumero.juegoGanado) { // Si el jugador ganó el juego.
        crearSoldados(); // Llama a un método para crear soldados
        crearMineros();
        System.out.println("¡Ganaste! Ahora tienes 2 soldados y 2 mineros adicionales"); // Imprime un mensaje de victoria.
    } else { // Si el jugador perdió el juego.
        System.out.println("¡Perdiste! Inténtalo de nuevo."); // Imprime un mensaje de derrota.
    }
}
    public static void iniciarTresEnRaya() {
    TresEnRayaSwing tresEnRaya = new TresEnRayaSwing(); // Crea una nueva instancia del juego TresEnRayaSwing.
    tresEnRaya.setVisible(true); // Hace visible la ventana del juego.

    while (!tresEnRaya.juegoTerminado) { // Bucle que se ejecuta mientras el juego no haya terminado.
        try {
            Thread.sleep(100); // Pausa la ejecución del hilo durante 100 milisegundos.
        } catch (InterruptedException e) {
            e.printStackTrace(); // Imprime la traza de la excepción si el hilo es interrumpido.
        }
    }

    // Verificar si el jugador ganó
    if (tresEnRaya.juegoGanado) { // Si el jugador ganó el juego.
        crearSoldados();
        crearMineros();
        System.out.println("¡Ganaste! Ahora tienes 2 soldados y 2 mineros adicionales"); // Imprime un mensaje de victoria.
    } else { // Si el jugador perdió el juego.
        System.out.println("¡Perdiste! Inténtalo de nuevo."); // Imprime un mensaje de derrota.
    }
}
    public static void iniciarSeguirSecuencia() {
    SeguirSecuencia seguirSecuencia = new SeguirSecuencia(); // Crea una nueva instancia del juego SeguirSecuencia.
    seguirSecuencia.setVisible(true); // Hace visible la ventana del juego.

    while (!seguirSecuencia.juegoTerminado) { // Bucle que se ejecuta mientras el juego no haya terminado.
        try {
            Thread.sleep(100); // Pausa la ejecución del hilo durante 100 milisegundos.
        } catch (InterruptedException e) {
            e.printStackTrace(); // Imprime la traza de la excepción si el hilo es interrumpido.
        }
    }

    if (seguirSecuencia.juegoGanado) { // Si el jugador ganó el juego.
        crearSoldados(); // Llama a un método para crear soldados
        crearMineros();
        System.out.println("¡Ganaste! Ahora tienes 2 soldados y 2 mineros adicionales"); // Imprime un mensaje de victoria.
    } else { // Si el jugador perdió el juego.
        System.out.println("¡Perdiste! Inténtalo de nuevo."); // Imprime un mensaje de derrota.
    }
}
}
  

