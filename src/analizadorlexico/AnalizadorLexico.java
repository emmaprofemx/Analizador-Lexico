package analizadorlexico;

import java.util.Scanner;

public class AnalizadorLexico {

    public static String comenzar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una cadena de texto:");
        String linea = scanner.nextLine();
        return linea;
    }

    public static void main(String[] args) {
        String lineaS = comenzar();
        String[] palabras = lineaS.split("@");
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            if (esNumeroInt(palabra)) {
                System.out.println(palabra + ": Numero Entero");
            } else if (esNumeroDouble(palabra)) {
                System.out.println(palabra + ": Numero Decimal");
            } else if (esPalabra(palabra)) {
                System.out.println(palabra + ": palabra");
            }
 
        for (int j = 0; j < palabra.length(); j++) {
    char c = palabra.charAt(j);
    switch (c) {
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
                j++; // Salta el siguiente carácter
            } else {
                System.out.println(c + ": operador relacional");
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
                System.out.println(c + ": es una letra");
            } else {
                System.out.println(c + ": es un carácter especial");
            }
            break;
    }
}

        }
    }

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

    public static boolean esSeparador(char x) {
        return (x == ' ');
    }

    public static boolean esFinLinea(char x) {
        return (x == '\r' || x == '\n');
    }

    public static boolean esOperadorAritmetico(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%');
    }
    public static boolean esOperadorRelacional(char c) {
    return (c == '<' || c == '>' || c == '=' || c == '!');
}

}
