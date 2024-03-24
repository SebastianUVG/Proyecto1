package uvg.edu.gt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Operaciones {
    LeerTexto expresiones = new LeerTexto(); 
    ArrayList<Character> expresion;

    public void Operar() throws IOException {
        expresion = expresiones.LeerCaracter();
        // Inicializar el stack para mantener los operandos y operadores
        Stack<Character> stack = new Stack<>();
        
        // Iterar sobre la expresión
        for (char c : expresion) {
            if (c == ')') {
                // Al encontrar un paréntesis cerrado, extraer los elementos dentro del paréntesis
                ArrayList<Character> subExpresion = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    subExpresion.add(0, stack.pop()); // Agregar al inicio para mantener el orden correcto
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // Eliminar el '('
                }
                
                // Calcular el resultado de la sub-expresión y agregarlo al stack
                int resultado = calcularSubExpresion(subExpresion);
                stack.push((char) (resultado + '0')); // Convertir el resultado a char y agregarlo al stack
            } else {
                // Si no es un paréntesis cerrado, simplemente agregar al stack
                stack.push(c);
            }
        }
        
        // Calcular el resultado final (debe haber solo un elemento en el stack)
        if (stack.size() == 1) {
            System.out.println("Resultado: " + (stack.pop() - '0')); // Convertir el resultado de char a int
        } else {
            System.out.println("Expresión no válida");
        }
    }
    
    // Método para calcular el resultado de una sub-expresión
    private int calcularSubExpresion(ArrayList<Character> subExpresion) {
        char operador = subExpresion.get(0); // El primer elemento es el operador
        int resultado = Character.getNumericValue(subExpresion.get(1)); // Inicializar resultado con el primer operando
        
        // Iterar sobre los demás elementos, realizando la operación correspondiente
        for (int i = 2; i < subExpresion.size(); i++) {
            char elemento = subExpresion.get(i);
            if (Character.isDigit(elemento)) {
                int operando = Character.getNumericValue(elemento);
                if (operador == '+') {
                    resultado += operando;
                } else if (operador == '-') {
                    resultado -= operando;
                } else if (operador == '*') {
                    resultado *= operando;
                } else if (operador == '/') {
                    resultado /= operando;
                }
            }
        }
        return resultado;
    }
}
