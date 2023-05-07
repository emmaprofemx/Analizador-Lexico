package analizadorlexico;

import java.util.Scanner;

public class AnalizadorLexico {

    public static String comenzar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una cadena de texto:");
        String linea = scanner.nextLine();
        return linea;
    }

    public static void main(String[] args) { //Inciio de Main
        String lineaS = comenzar();
        String[] palabras = lineaS.split("@");
        for (int i = 0; i < palabras.length; i++) {//Inicio de primer for
            String palabra = palabras[i];
            if (esNumeroInt(palabra)) {
                System.out.println(palabra + ": Numero Entero");
            } else if (esNumeroDouble(palabra)) {
                System.out.println(palabra + ": Numero Decimal");
            } else if (operadorLogico(palabra)) {
                System.out.println(palabra + ": es un operador lógico");
            } else if (esPalabra(palabra)) {
                System.out.println(palabra + ": palabra");
            }

            for (int j = 0; j < palabra.length(); j++) { //Inicio de segundo for
                char c = palabra.charAt(j);
                switch (c) { //Inicio del switch
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                    case '^':
                    case '%':
                        System.out.println(c + ": es un operador aritmético");
                        break;
                    case '>':
                    case '<':
                        if (j < palabra.length() - 1 && palabra.charAt(j + 1) == '=') {
                            System.out.println(c + "=" + ": operador relacional");
                            j++;
                        } else {
                            System.out.println(c + ": operador relacional");
                        }
                        break;
                    case '!':
                        if (j < palabra.length() - 1 && palabra.charAt(j + 1) == '=') {
                            System.out.println(c + "=" + ": operador relacional");
                            j++;
                        } else {
                            System.out.println(c + ": No esta ligado a este analizador");
                        }
                        break;
                    case '=':
                        if (j < palabra.length() - 1 && palabra.charAt(j + 1) == '=') {
                            System.out.println(c + "=" + ": operador relacional");
                            j++;
                        } else {
                            System.out.println(c + ": es un carácter especial");
                        }
                        break;
                    case ' ':
                        System.out.println(c + ": es un separador");
                        break;
                    case '\r':
                    case '\n':
                        System.out.println(c + ": es un fin de línea");
                        break;
                    default:
                        if (esDigito(c)) {
                            System.out.println(c + ": es un dígito");
                        } else if (esLetra(c)) {
                            if (operadorLogico(palabra.substring(j))) {
                                System.out.println(palabra.substring(j) + ": es un operador lógico");
                                j = palabra.length(); // Salta el resto de la palabra
                            } else {
                                System.out.println(c + ": es una letra");
                            }
                        } else {
                            System.out.println(c + ": es un carácter especial");
                        }
                        break;
                }//Fin de switch
            }//Fin del segundo for
        }//Fin de primer for
    }//Fin del main

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
        String cadenaLimpia = cadena.replaceAll("\\s+", "");
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
        return ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z'));
    }

    public static boolean esFinLinea(char x) {
        return (x == '\r' || x == '\n');
    }

    public static boolean esOperadorAritmetico(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%');
    }

    public static boolean esOperadorRelacional(char c) {
        return (c == '<' || c == '>' || c == '=');
    }

    //usando un contenedor en el cual se guarden los operadores que usare
    public static boolean operadorLogico(String cadena) {
        //Definimos un array de Strings en el cual almacenamos AND OR NO , que seran nuestros logicos en este 
        //analizador.
        String[] operadores = {"AND", "OR", "NO"};

        for (String operador : operadores) {
            if (operador.equalsIgnoreCase(cadena)) {
                return true;
            }
        }
        return false;
    }

}
