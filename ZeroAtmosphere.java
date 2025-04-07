package zeroatmosphere;

package zeroatmosphere;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
    
    static ArrayList<Mascotas> mascotas = new ArrayList<>();
    static ArrayList<Persona> personas = new ArrayList<>();
    static ArrayList<Aerobikes> aerobikes = new ArrayList<>();
    static ArrayList<Aerocars> aerocars = new ArrayList<>();
  
    static Validador val=new Validador();
    
    
    public static void main(String[] args) {
   
        String op="";
            do{
                try{
                    System.out.println("\n--- Menú Principal ---");
                    System.out.println("1.Estado completo de la BlueStar-IV");
                    System.out.println("2.Modificar tripulación o vehículos");
                    System.out.println("3.Iniciar nueva operación");
                    System.out.println("4.Finalizar operación");
                    System.out.println("6.Acceso a ficheros binarios");
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
                    opcion2();
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
                    mostrarEstadoMemoriaBob();
                    
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
      
        crearSoldados(cantidadSoldados); 
        crearMineros(cantidadMineros);  
        crearAlienigenas();
    
        System.out.println("\n--- Información genérica de la operación ---");
        nombresSoldados(solArray);
        nombresMineros(minArray);
        System.out.println("alienígenas esperados: "+ alienigenas);

    
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
   
    public static void crearSoldados(int cantidad){
    String[] nombresMasculinos = {"Juan", "Carlos", "Miguel", "Luis", "Pedro", "José", "Antonio"};
    String[] nombresFemeninos = {"María", "Ana", "Laura", "Carmen", "Sofía", "Isabel", "Elena"};
        
    int contadorMasculinos = 0; 
    int contadorFemeninos = 0; //actua como índice para acceder a un elemento específico del array nombresFemeninos
    String nombreSoldado;
    
          
    for (int i = 0; i < cantidad; i++) { // bucle se ejecuta una vez por cada soldado en el array sol
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
    public static void crearMineros(int cantidad){
    String[] nombresMasculinos = {"Alejandro", "Andrés", "Diego", "Fernando", "Gabriel","Héctor", "Javier"};
    String[] nombresFemeninos = {"Adriana", "Beatriz", "Clara", "Diana", "Elena","Gabriela","Inés"};
        
    int contadorMasculinos = 0; 
    int contadorFemeninos = 0; //actua como índice para acceder a un elemento específico del array nombresFemeninos
    String nombreMinero;    
        
    for (int i = 0; i < cantidad; i++) { // bucle se ejecuta una vez por cada soldado en el array min
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

    public static void mostrarEstadoMemoriaBob() {
    
        BobInterface.main(new String[]{}); // Ejecuta el main de BobInterface para cargar la memoria

        // Obtiene la representación en String de la memoria
        String memoriaParaMostrar = BobInterface.obtenerMemoriaParaMostrar();

        // Imprime la cadena en la consola
        System.out.println("--- Estado de la Memoria desde MonitorMemoria ---");
        System.out.println(memoriaParaMostrar);
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
       cantidadSoldados += 2; // Incrementa la cantidad total de soldados en 2
        cantidadMineros += 2;  // Incrementa la cantidad total de mineros en 2
        crearSoldados(2);      // Crea 2 nuevos soldados y los añade a la lista
        crearMineros(2);       // Crea 2 nuevos mineros y los añade a la lista
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
        cantidadSoldados += 2; // Incrementa la cantidad total de soldados en 2
        cantidadMineros += 2;  // Incrementa la cantidad total de mineros en 2
        crearSoldados(2);      // Crea 2 nuevos soldados y los añade a la lista
        crearMineros(2);       // Crea 2 nuevos mineros y los añade a la lista
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
        cantidadSoldados += 2; // Incrementa la cantidad total de soldados en 2
        cantidadMineros += 2;  // Incrementa la cantidad total de mineros en 2
        crearSoldados(2);      // Crea 2 nuevos soldados y los añade a la lista
        crearMineros(2);       // Crea 2 nuevos mineros y los añade a la lista
        System.out.println("¡Ganaste! Ahora tienes 2 soldados y 2 mineros adicionales"); // Imprime un mensaje de victoria.
    } else { // Si el jugador perdió el juego.
        System.out.println("¡Perdiste! Inténtalo de nuevo."); // Imprime un mensaje de derrota.
    }
}
    
    public static void agregarGato() {
        System.out.println("Introduzca el nombre del gato:");
        String nombre = sc.next();

        System.out.println("Introduzca el sexo del gato (M/F):");
        char sexo = sc.next().toUpperCase().charAt(0);

        sc.nextLine(); // Limpia el buffer
        System.out.println("Introduzca la raza del gato:");
        String raza = sc.nextLine();

        Gatos gato = new Gatos(nombre, sexo, raza);
        mascotas.add(gato); // Agregar a la lista
        System.out.println("Gato agregado correctamente.");
    }
    public static void agregarPerro() {
        System.out.println("Introduca el nombre del perro");
        String nombre = sc.next();

        System.out.println("Introduzca el sexo del perro (M/F):");
        char sexo = sc.next().toUpperCase().charAt(0);

        System.out.println("Introduzca la raza del perro");
        String raza = sc.nextLine();

        Perros perro = new Perros(nombre,raza, sexo);
        mascotas.add(perro); // Agregar a la lista
        System.out.println("Perro agregado correctamente.");

    }
    public static void agregarPajaro() {
        System.out.println("Introduca el nombre del pajaro");
        String nombre = sc.next();

        System.out.println("Introduzca el sexo del pájaro (M/F): ");
        char sexo = sc.next().toUpperCase().charAt(0);

        System.out.println("Introduzca la especie del pajaro");
        String especie = sc.nextLine();

        Pajaros pajaro = new Pajaros(nombre, sexo, especie);
        mascotas.add(pajaro);//se agrega al array list
        System.out.println("Pajaro creado correctamente.");

    }
    public static void agregarAerobikes() {
        System.out.println("Agregando Aereobike...");
        System.out.println("Introduzca el color: ");
        String color = sc.next();
        System.out.println("Introduzca el modelo");
        String modelo = sc.next();
        System.out.println("Introduzca el tipo del aereobike:");
        String tipo = sc.next();
        System.out.println("Introduzca el numero de personas ");
        int numeropersonas = sc.nextInt();
        System.out.println("Introduzca la velocidad del aerobike: ");
        int velocidad = sc.nextInt();
        System.out.println("Introduzca el numero de turbosjets");
        int turbojets = sc.nextInt();

        Aerobikes ae1 = new Aerobikes(color, modelo, tipo, numeropersonas, velocidad, turbojets);
        aerobikes.add(ae1);
        System.out.println("Aerobike creado correctamente.");

    }
    public static void agregarAerocars() {
        System.out.println("Agregando Aereocars...");
        System.out.println("Introduzca el color: ");
        double distancia = sc.nextDouble();
        sc.nextLine();// Para que se limpie el buffer antes de leer el nombrre
        System.out.println("Introduzca el nombre del responsable: ");
        String nombreResponsable = sc.next();
        ResponsableVehiculo responsable = new ResponsableVehiculo(nombreResponsable);
        System.out.println("Introduzca el numero de personas: ");
        int numeropersonas = sc.nextInt();
        System.out.println("Introduzca la velocidad del aerobike: ");
        int velocidad = sc.nextInt();
        System.out.println("Introduzca el numero de turbosjets");
        int turbojets = sc.nextInt();

        Aerocars ae1 = new Aerocars(distancia, responsable, numeropersonas, velocidad, turbojets);
        aerocars.add(ae1);
        System.out.println("Aerocar creado correctamente.");

    }

    public static void eliminarMascota() {
        if (mascotas.isEmpty()) {
            System.out.println("No hay mascotas registradas para eliminar.");
            return;
        }

        System.out.println("Lista de Mascotas:");
        for (int i = 0; i < mascotas.size(); i++) {
            System.out.println(i + ". " + mascotas.get(i).toString());
        }

        System.out.print("Seleccione el índice de la mascota a eliminar: ");
        int index = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        if (index >= 0 && index < mascotas.size()) {
            mascotas.remove(index);
            System.out.println("Mascota eliminada correctamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }
    public static void eliminarPersona() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas para eliminar.");
            return;
        }

        System.out.println("Lista de Personas:");
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(i + ". " + personas.get(i).toString());
        }

        System.out.print("Seleccione el índice de la persona a eliminar: ");
        int index = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        if (index >= 0 && index < personas.size()) {
            personas.remove(index);
            System.out.println("Persona eliminada correctamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }
    public static void eliminarAerobike() {
    if (aerobikes.isEmpty()) {
        System.out.println("No hay Aerobikes registradas para eliminar.");
        return;
    }

    System.out.println("Lista de Aerobikes:");
    for (int i = 0; i < aerobikes.size(); i++) {
        System.out.println(i + ". " + aerobikes.get(i).toString());
    }

    System.out.print("Seleccione el índice de la Aerobike a eliminar: ");
    int index = sc.nextInt();
    sc.nextLine(); // Limpiar buffer

    if (index >= 0 && index < aerobikes.size()) {
        aerobikes.remove(index);
        System.out.println("Aerobike eliminada correctamente.");
    } else {
        System.out.println("Índice inválido.");
    }
}
    public static void eliminarAerocar() {
    if (aerocars.isEmpty()) {
        System.out.println("No hay Aerocars registrados para eliminar.");
        return;
    }

    System.out.println("Lista de Aerocars:");
    for (int i = 0; i < aerocars.size(); i++) {
        System.out.println(i + ". " + aerocars.get(i).toString());
    }

    System.out.print("Seleccione el índice del Aerocar a eliminar: ");
    int index = sc.nextInt();
    sc.nextLine(); // Limpiar buffer

    if (index >= 0 && index < aerocars.size()) {
        aerocars.remove(index);
        System.out.println("Aerocar eliminado correctamente.");
    } else {
        System.out.println("Índice inválido.");
    }
}
    
    public static void opcion2(){
        int opcion = 0;
int choice = 0;

do {
System.out.println("1. Consulta tripulaciOn completa y vehIculos");
System.out.println("2. Modifica tripulaciOn o vehIculos ");
System.out.println("4. Salir");
System.out.print("Seleccione una opciOn: ");
opcion = sc.nextInt();
sc.nextLine();//Para limoiar el buffer

switch (opcion) {
case 1:
System.out.println("Consulta Tripulacion");
break;
case 2:
do {
System.out.println("1. Agregar Tripulacion");
System.out.println("2. Eliminar Tripulacion");
System.out.println("3. Agregar Vehiculos");
System.out.println("4. Eliminar Vehiculos");
System.out.println("5. Volver al menu principal");
System.out.print("Seleccione una opcion: ");
choice = sc.nextInt();
sc.nextLine();

switch (choice) {
case 1:
System.out.println("Opciones para añadir:");
System.out.println("1. MASCOTAS");
System.out.println("2. PERSONAS");
int opcion1 = sc.nextInt();

if (opcion1 == 1) {
System.out.println("Introduzca que mascota quiere agregar: ");
System.out.println("1. Gato");
System.out.println("2. Perro");
System.out.println("3. Pajaro");
int mascota = sc.nextInt();
if (mascota == 1) {
agregarGato();
} else if (mascota == 2) {
agregarPerro();
} else {
agregarPajaro();
}

Gatos ga1 = new Gatos("Canela", 'F', "Bengali");
Perros pe1 = new Perros("Rocky","Labrador", 'M');
Pajaros pa1 = new Pajaros("Rito", 'F', "Loro");

mascotas.add(ga1);
mascotas.add(pe1);
mascotas.add(pa1);

} else if (opcion1 == 2) {

System.out.println("Personas");
Persona p1 = new Persona("Laura", 29, 'F', 67.5, 1.68);
Persona p2 = new Persona("Carmen", 40, 'F', 100, 1.59);
Persona p3 = new Persona("Lopez", 32, 'M', 67.5, 1.71);
Persona p4 = new Persona("Federico", 26, 'M', 67.5, 1.90);
personas.add(p1);
personas.add(p2);
personas.add(p3);
personas.add(p4);

break;
} else {
System.out.println("Opción inválida.");
}
break;

case 2:
System.out.println("Eliminar Tripulacion");
System.out.println("1. MASCOTAS");
System.out.println("2. PERSONAS");
int opcion3 = sc.nextInt();
if(opcion3 == 1) {
eliminarMascota();
} else if (opcion3 == 2) {
eliminarPersona();
} else {
System.out.println("Opción inválida.");
}
break;

case 3:
System.out.println("Opciones para añadir vehículos:");
System.out.println("1. AEREOBIKES");
System.out.println("2. AEREOCARS");
int opcionVehiculo = sc.nextInt();
sc.nextLine();

if (opcionVehiculo == 1) {
agregarAerobikes();
Aerobikes b1 = new Aerobikes("Azul", "first34", "FE-56", 67, 78.8, 98);
Aerobikes b2 = new Aerobikes("Negro", "SCON67", "WE-99", 56, 23, 34);

} else if (opcionVehiculo == 2) {
agregarAerocars();
ResponsableVehiculo rv1 = new ResponsableVehiculo("Ivan");
Aerocars v1 = new Aerocars(11.3, rv1, 5, 45.2, 4);
ResponsableVehiculo rv2 = new ResponsableVehiculo("Maria");
Aerocars v2 = new Aerocars(56.7, rv2, 7, 8.7, 9);

} else {
System.out.println("Opción inválida.");
}
break;

case 4:
System.out.println("Eliminar Vehiculo");
System.out.println("1. Aerobikes");
System.out.println("2. Aerocars");
int opcion4 = sc.nextInt();
if(opcion4 == 1) {
eliminarAerobike();
} else if (opcion4 == 2) {
eliminarAerocar();
} else {
System.out.println("Opción inválida.");
}

break;

case 5:
System.out.println("Volviendo al menú principal...");
break;

default:
System.out.println("Opción inválida.");
}
} while (choice != 5);
break;

}
} while (opcion != 4);
}
    }
