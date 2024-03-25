package uvg.edu.gt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Operaciones {
    LeerTexto expresiones = new LeerTexto(); 
    ArrayList<String> expresion;
    
    public void Operar() throws IOException {
        expresion = expresiones.textReader();
      
        // Recorremos los elementos y guardamos los elementos de los stacks en listas dinámicas
        ArrayList<Stack<String>> stacks = new ArrayList<>();
        Stack<String> currentStack = null;
        int openParenthesesCount = 0;
        for (String element : expresion) {
            if (element.equals("(")) {
                openParenthesesCount++;
                currentStack = new Stack<>();
                stacks.add(currentStack);
            } else if (element.equals(")")) {
                if (openParenthesesCount > 0) {
                    openParenthesesCount--;
                }
                if (!currentStack.isEmpty()) {
                    double resultado = calcularResultado(currentStack); // Calcular el resultado del stack
                    System.out.println("Resultado del stack interno: " + resultado);
                    // Agregar el resultado al stack anterior si es posible
                    if (!stacks.isEmpty()) {
                        Stack<String> stackAnterior = stacks.get(stacks.size() - 1);
                        stackAnterior.push(Double.toString(resultado));
                    }
                }
            } else {
                // Agregamos elementos al último stack abierto (si existe)
                if (currentStack != null) {
                    currentStack.push(element);
                }
            }
        }
    
        // Calcular el resultado final sumando los resultados de los stacks externos
        double resultadoFinal = 0;
        for (Stack<String> stack : stacks) {
            resultadoFinal += calcularResultado(stack);
        }
        System.out.println("El resultado de la expresión es: " + resultadoFinal);
    }
    
    
    public double calcularResultado(Stack<String> stack) {
        Stack<Double> operandStack = new Stack<>();
        while (!stack.isEmpty()) {
            String elemento = stack.pop();
            if (esOperando(elemento)) {
                operandStack.push(Double.parseDouble(elemento));
            } else if (esOperador(elemento)) {
                // Obtener el operador y el número de operandos
                char operador = elemento.charAt(0);
                int numOperandos = operandosRequeridos(operador);
                // Verificar si hay suficientes operandos en el stack
                if (operandStack.size() < numOperandos) {
                    throw new IllegalArgumentException("Cantidad insuficiente de operandos para el operador " + operador);
                }
                // Realizar la operación con los operandos correspondientes
                double resultado = realizarOperacion(operador, operandStack, numOperandos);
                // Agregar el resultado al stack de operandos
                operandStack.push(resultado);
            }
        }
        // El resultado final debe ser el único elemento en el stack de operandos
        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Expresión mal formada");
        }
        return operandStack.pop();
    }
    
    private int operandosRequeridos(char operador) {
        // Definir el número de operandos requeridos para cada operador
        switch (operador) {
            case '+':
            case '-':
            case '*':
            case '/':
                return 2; // Operadores binarios
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }
    
    private double realizarOperacion(char operador, Stack<Double> operandStack, int numOperandos) {
        // Realizar la operación con los operandos correspondientes
        double resultado = operandStack.pop();
        for (int i = 1; i < numOperandos; i++) {
            double siguienteOperando = operandStack.pop();
            switch (operador) {
                case '+':
                    resultado += siguienteOperando;
                    break;
                case '-':
                    resultado -= siguienteOperando;
                    break;
                case '*':
                    resultado *= siguienteOperando;
                    break;
                case '/':
                    if (siguienteOperando == 0) {
                        throw new ArithmeticException("División por cero");
                    }
                    resultado /= siguienteOperando;
                    break;
            }
        }
        return resultado;
    }
    
    
    
    

    public boolean esOperando(String elemento) {
        try {
            Double.parseDouble(elemento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean esOperador(String elemento) {
        return elemento.equals("+") || elemento.equals("-") || elemento.equals("*") || elemento.equals("/");
    }

 
}
