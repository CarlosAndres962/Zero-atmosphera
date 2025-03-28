package binarios;

import java.io.*;
public class BlueStarIV {

    public static void generarArchivosBinarios() {
        Random random = new Random();

        try {
            try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("C:\\AA_pruebas\\mov_tierra.dat"))) {
                for (int i = 0; i < 10; i++) {
                    CiberExcavadora ciberexcavadora = new CiberExcavadora(
                            "CiberExcavadora" + (i + 1),
                            random.nextInt(5) + 1,
                            random.nextBoolean() ? "ruedas" : "oruga",
                            random.nextDouble()
                    );
                    oos1.writeObject(ciberexcavadora);
                }
            }

            try (ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("C:\\AA_pruebas\\martillo.dat"))) {
                for (int i = 0; i < 10; i++) {
                    Martillo martillo = new Martillo(
                            "Martillo" + (i + 1),
                            random.nextInt(101) + 200,
                            random.nextBoolean() ? "manual" : "correa",
                            random.nextDouble()
                    );
                    oos2.writeObject(martillo);
                }
            }

            try (ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("C:\\AA_pruebas\\manual_pala.dat"))) {
                for (int i = 0; i < 10; i++) {
                    Pala pala = new Pala(
                            "Pala" + (i + 1),
                            random.nextInt(5) + 1,
                            random.nextBoolean() ? "puro" : "aleacion",
                            random.nextBoolean() ? "pvc" : "vinilo"
                    );
                    oos3.writeObject(pala);
                }
            }

            try (ObjectOutputStream oos4 = new ObjectOutputStream(new FileOutputStream("C:\\AA_pruebas\\cibercompresor.dat"))) {
                for (int i = 0; i < 10; i++) {
                    CiberCompresor cibercompresor = new CiberCompresor(
                            "CiberCompresor" + (i + 1),
                            random.nextInt(5) + 1,
                            random.nextBoolean() ? "ruedas" : "oruga",
                            random.nextDouble()
                    );
                    oos4.writeObject(cibercompresor);
                }
            }

            System.out.println("Archivos binarios creados exitosamente.");

        } catch (IOException e) {
        }
    }

    private static final String[] archivos = {
            "/Users/fani/Desktop/Binarios/mov_tierra.dat",
            "/Users/fani/Desktop/Binarios/martillo.dat",
            "/Users/fani/Desktop/Binarios/manual_pala.dat",
            "/Users/fani/Desktop/Binarios/cibercompresor.dat"
    };

    public static void main(String[] args) {
        generarArchivosBinarios();
        Object[][] tempMemoria = new Object[4][10];
        leerArchivo(archivos[0], 0, tempMemoria);
        leerArchivo(archivos[1], 1, tempMemoria);
        leerArchivo(archivos[2], 2, tempMemoria);
        leerArchivo(archivos[3], 3, tempMemoria);
        mostrarYModificarMemoria(tempMemoria);
    }

    public static void leerArchivo(String nombreArchivo, int fila, Object[][] memoria) {
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            int columna = 0;
            while (true) {
                try {
                    Object obj = ois.readObject();
                    memoria[fila][columna] = obj;
                    columna++;
                    System.out.println(obj);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: El archivo " + nombreArchivo + " no existe.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------");
    }

    private static void mostrarYModificarMemoria(Object[][] memoria) {
        Scanner scanner = new Scanner(System.in);
        mostrarMemoria(memoria);

        System.out.println("¿Desea modificar algún objeto? (s/n)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese la fila (1-4):");
            int fila = scanner.nextInt() - 1;
            System.out.println("Ingrese la columna (1-10):");
            int columna = scanner.nextInt() - 1;

            Object obj = memoria[fila][columna];
            if (obj != null) {
                modificarObjeto(obj, scanner);
                actualizarArchivosBinarios(memoria, archivos);
            } else {
                System.out.println("No hay objeto en esa posición.");
            }
        }
    }

    private static void mostrarMemoria(Object[][] memoria) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("[" + i + "][" + j + "] -> " + memoria[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void modificarObjeto(Object obj) {
        Scanner scanner = new Scanner(System.in);
        try{
            if (obj instanceof CiberExcavadora) {
                CiberExcavadora exc = (CiberExcavadora) obj;
                System.out.println("Nuevo consumo (1-5):");
                exc.setConsumo(scanner.nextInt());
                System.out.println("Nueva tracción (ruedas/oruga):");
                exc.setTraccion(scanner.next());
                System.out.println("Nueva protección (0-1):");
                exc.setProteccion(scanner.nextDouble());
            } else if (obj instanceof Martillo) {
                Martillo mart = (Martillo) obj;
                System.out.println("Nuevo consumo (200-300):");
                mart.setConsumo(scanner.nextInt());
                System.out.println("Nueva sujeción (manual/correa):");
                mart.setSujeccion(scanner.next());
                System.out.println("Nueva protección (0-1):");
                mart.setProteccion(scanner.nextDouble());
            } else if (obj instanceof Pala) {
                Pala pala = (Pala) obj;
                System.out.println("Nueva longitud de mango (1-5):");
                pala.setLonmango(scanner.nextInt());
                System.out.println("Nuevo metal (puro/aleacion):");
                pala.setMetal(scanner.next());
                System.out.println("Nueva protección (PVC/vinilo):");
                pala.setProteccion(scanner.next());
            } else if (obj instanceof CiberCompresor) {
                CiberCompresor comp = (CiberCompresor) obj;
                System.out.println("Nuevo consumo (1-5):");
                comp.setConsumo(scanner.nextInt());
                System.out.println("Nueva tracción (ruedas/oruga):");
                comp.setTraccion(scanner.next());
                System.out.println("Nueva protección (0-1):");
                comp.setProteccion(scanner.nextDouble());
        }
        }catch (Excepciones e){System.err.println(e);}
    }

    public static void actualizarArchivosBinarios(Object[][] memoria, String[] archivos) {
        for (int i = 0; i < 4; i++) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivos[i]))) {
                for (int j = 0; j < 10; j++) {
                    Object obj = memoria[i][j];
                    if (obj != null) {
                        oos.writeObject(obj);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
