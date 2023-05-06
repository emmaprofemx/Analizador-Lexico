/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import java.util.Scanner;

/**
 *
 * @author EMMANUEL
 */
public class AnalizadorLexico {

    /**
     * @param args the command line arguments
     */
    
    public static String comenzar(){
         Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una cadena de texto:");
        String linea = scanner.nextLine();
        return linea;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
       String lineaS = comenzar();
        String[] palabras = lineaS.split("@");
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            if (esNumeroInt(palabra)) {
                System.out.println(palabra + ": Numero Entero");
            } else if (esNumeroDouble(palabra)) {
                System.out.println(palabra + ": Numero Decimal");
            } else if (esPalabra(palabra)) {
                System.out.println(palabra + ": palabra"); // <- Cambiar por "conjunto de caracteres especiales"
            }

            for (int j = 0; j < palabra.length(); j++) {
            char c = palabra.charAt(j);
            if (esDigito(c)) {
                System.out.println(c + ": es un dígito");
            } else if (esLetra(c)) {
                System.out.println(c + ": es una letra");
            } else if (esSeparador(c)) {
                System.out.println(c + ": es un separador");
            } else if (esFinLinea(c)) {
                System.out.println(c + ": es un fin de línea");
            } else {
                System.out.println(c + ": es un carácter especial");
            }
            }
        }
    }//FIN DEL METODO MAIN

    public static boolean esNumeroInt(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean esNumeroDouble(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean esPalabra(String cadena) {
        String cadenaLimpia = cadena.replaceAll("\\s+", ""); // Solo elimina los espacios en blanco

        for (char c : cadenaLimpia.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean esDigito(char x) {
        return (x >= '0' && x <= '9');
    }

    public static boolean esLetra(char x) {
        if ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean esSeparador(char x) {
        if (x == ' ') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean esFinLinea(char x) {
        if (x == '\r' || x == '\n') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean esOperadorAritmetico(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c== '%');
    }

    
    public static boolean operadorLogico(String c){
        return (c == "AND" || c == "OR" || c == "NO");
    }
    
    public static boolean operadorRelacional(String realcional){
     return false;   
    }
}