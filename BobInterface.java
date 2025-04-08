public class BobInterface {

    private static final int FILAS = 4;
    private static final int COLUMNAS = 10;
    private static final Object[][] memoria = new Object[FILAS][COLUMNAS];
    private static final String[] ARCHIVOS = {
            "C:\\AA_pruebas\\mov_tierra.dat",
            "C:\\AA_pruebas\\martillo.dat",
            "C:\\AA_pruebas\\manual_pala.dat",
            "C:\\AA_pruebas\\cibercompresor.dat"
    };
    private static final Scanner scanner = new Scanner(System.in);
    
    public static String obtenerMemoriaParaMostrar() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Matriz de objetos en memoria:\n");
        for (int i = 0; i < FILAS; i++) {
            sb.append("\nTipo: ").append(ARCHIVOS[i]).append("\n");
            for (int j = 0; j < COLUMNAS; j++) {
                sb.append("  [").append(i).append("][").append(j).append("] → ").append(memoria[i][j]).append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BlueStarIV.generarArchivosBinarios();
        // Leer archivos y almacenar en la matriz de BobInterface
        BlueStarIV.leerArchivo(ARCHIVOS[0], 0, memoria);
        BlueStarIV.leerArchivo(ARCHIVOS[1], 1, memoria);
        BlueStarIV.leerArchivo(ARCHIVOS[2], 2, memoria);
        BlueStarIV.leerArchivo(ARCHIVOS[3], 3, memoria);

        boolean salir = false;
        while (!salir) {
            obtenerMemoriaParaMostrar();
            System.out.print("\n¿Deseas modificar algún objeto? (sí/no): ");
            String respuesta = scanner.next().toLowerCase();
            if (respuesta.equals("si") || respuesta.equals("sí")) {
                modificarObjeto();
            } else {
                salir = true;
            }
        }
        BlueStarIV.actualizarArchivosBinarios(memoria, ARCHIVOS);

        System.out.println("Los cambios han sido guardados. ¡Hasta luego!");
    }

    private static void modificarObjeto() {
        System.out.print("Introduce la fila del objeto a modificar (0-3): ");
        int fila = scanner.nextInt();
        System.out.print("Introduce la columna del objeto a modificar (0-9): ");
        int columna = scanner.nextInt();

        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            System.out.println(" Coordenadas inválidas.");
            return;
        }

        Object obj = memoria[fila][columna];

        // Permitir modificar atributos 2 al 4 según el tipo de objeto
        if (obj instanceof CiberExcavadora) {
            CiberExcavadora ce = (CiberExcavadora) obj;
            System.out.print("Nuevo consumo (1-5 litros): ");
            ce.setConsumo(scanner.nextInt());
            System.out.print("Nueva tracción (ruedas/oruga): ");
            ce.setTraccion(scanner.next());
            System.out.print("Nueva protección (0.0 - 1.0): ");
            ce.setProteccion(scanner.nextDouble());
        } else if (obj instanceof Martillo) {
            Martillo m = (Martillo) obj;
            System.out.print("Nuevo consumo (200-300 Kw): ");
            m.setConsumo(scanner.nextInt());
            System.out.print("Nueva sujeción (manual/correa): ");
            m.setSujecion(scanner.next());
            System.out.print("Nueva protección (0.0 - 1.0): ");
            m.setProteccion(scanner.nextDouble());
        } else if (obj instanceof Pala) {
            Pala p = (Pala) obj;
            System.out.print("Nuevo lonmango (1-5 metros): ");
            p.setLonmango(scanner.nextInt());
            System.out.print("Nuevo metal (puro/aleacion): ");
            p.setMetal(scanner.next());
            System.out.print("Nueva protección (PVC/vinilo): ");
            p.setProteccion(scanner.next());
        } else if (obj instanceof CiberCompresor) {
            CiberCompresor cc = (CiberCompresor) obj;
            System.out.print("Nuevo consumo (1-5 litros): ");
            cc.setConsumo(scanner.nextInt());
            System.out.print("Nueva tracción (ruedas/oruga): ");
            cc.setTraccion(scanner.next());
            System.out.print("Nueva protección (0.0 - 1.0): ");
            cc.setProteccion(scanner.nextDouble());
        } else {
            System.out.println(" Tipo de objeto desconocido.");
            return;
        }

        System.out.println(" Objeto actualizado.");
    }
}
