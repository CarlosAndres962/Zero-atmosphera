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
            if (num <= 0) {
                throw new Excepciones("Error: El número no puede ser negativo o cero.");
            }
        } catch (NumberFormatException e) {
            throw new Excepciones("Error: La entrada no es un número entero válido.");
        }
    }
    public void validaChar(String confirmacion) throws Excepciones{
        if (confirmacion.length()!=1) {
            throw new Excepciones("Error: La entrada debe contener un digito.");
        }
        char caracter=confirmacion.charAt(0);
        if (caracter!='s' && caracter!='n') {
            throw new Excepciones("Error: La entrada no es válido solo 's' o 'n'.");
        }
    } 
}
