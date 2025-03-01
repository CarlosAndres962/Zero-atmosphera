/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmospher;

/**
 *
 * @author Pochado
 */
public class Validador {
    public Validador(){}
    
    public void validarnumero(String numero) throws Excepciones {
        // Verifica si la entrada es un número decimal
        if (numero.contains(".")) {
            throw new Excepciones("El número no puede ser un decimal.");
        }

        // Verifica si la entrada es un número entero válido
        try {
            int num = Integer.parseInt(numero);
            if (num < 0) {
                throw new Excepciones("El número de alienígenas no puede ser negativo.");
            }
            System.out.println("Número válido: " + num);
        } catch (NumberFormatException e) {
            throw new Excepciones("Error: La entrada no es un número entero válido.");
        }
    }
}
