package uvg.edu.gt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Operaciones {
    LeerTexto expresiones = new LeerTexto(); 
    ArrayList<String> expresion;
    
    /**
     * Realiza las operaciones correspondientes a una expresión
     * @return El resultado de la expresión
     * @throws IOException Si hay problemas con la lectura del archivo
     */
    public double Operar() throws IOException {
        expresion = expresiones.textReader(); // Leer la expresión
        
        // Recorremos los elementos y guardamos los elementos de los stacks en listas dinámicas
        ArrayList<Stack<String>> stacks = new ArrayList<>(); // Lista de stacks
        Stack<String> currentStack = null; // Stack actual
        int openParenthesesCount = 0; // Contador de paréntesis abiertos
        for (String element : expresion) {
            if (element.equals("(")) { // Si es un paréntesis abierto
                openParenthesesCount++; // Incrementar contador
                currentStack = new Stack<>(); // Crear stack
                stacks.add(currentStack); // Agregar stack a la lista
            } else if (element.equals(")")) { // Si es un paréntesis cerrado
                if (openParenthesesCount > 0) { // Si hay un paréntesis abierto
                    openParenthesesCount--; // Decrementar contador
                }
                if (!currentStack.isEmpty()) { // Si el stack no está vacío
                    double resultado = calcularResultado(currentStack); // Calcular resultado
                    //System.out.println("Resultado: " + resultado); // Mostrar resultado
                    // Agregar resultado al stack anterior si es posible
                    if (!stacks.isEmpty()) {
                        Stack<String> stackAnterior = stacks.get(stacks.size() - 1);
                        stackAnterior.push(Double.toString(resultado));
                    }
                }
            } else { // Si es un operando o un operador
                // Agregamos elementos al último stack abierto (si existe)
                if (currentStack != null) {
                    currentStack.push(element);
                }
            }
        }
        
        // Calcular resultado final sumando los resultados de los stacks externos
        double resultadoFinal = 0;
        for (Stack<String> stack : stacks) {
            resultadoFinal += calcularResultado(stack);
        }
        System.out.println("El resultado de la expresión es: " + resultadoFinal);
        return resultadoFinal;
    }

    
    
    /**
     * Calcula el resultado de una expresión que se ha almacenado en un stack
     * @param stack El stack que contiene los elementos de la expresión
     * @return El resultado de la expresión
     * @throws IllegalArgumentException Si la expresión no está bien formada
     */
    public double calcularResultado(Stack<String> stack) {
        // Stack que contendrá los operandos a operar
        Stack<Double> operandStack = new Stack<>();
        
        // Iterar sobre el stack de entrada
        while (!stack.isEmpty()) {
            String elemento = stack.pop(); // Obtener elemento actual
            
            // Si es un operando, agregarlo al stack de operandos
            if (esOperando(elemento)) {
                operandStack.push(Double.parseDouble(elemento));
            } 
            
            // Si es un operador, realizar la operación correspondiente
            else if (esOperador(elemento)) {
                // Obtener el operador y el número de operandos requeridos
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
        return operandStack.pop(); // Devolver resultado
    }

    
    /**
     * Devuelve el número de operandos requeridos para un operador
     * @param operador El operador a evaluar
     * @return El número de operandos requeridos para el operador
     * @throws IllegalArgumentException Si el operador no es válido
     */
    private int operandosRequeridos(char operador) {
        // Definir el número de operandos requeridos para cada operador
        switch (operador) {
            case '+':
            case '-':
            case '*': // Operadores binarios
                return 2;
            case '/': // Operador de división
                return 2;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }
    
    /**
     * Realiza la operación correspondiente a un operador con los operandos
     * almacenados en el stack de operandos
     * @param operador El operador a realizar
     * @param operandStack El stack que contiene los operandos
     * @param numOperandos El número de operandos requeridos por el operador
     * @return El resultado de la operación
     * @throws ArithmeticException Si el operador es división y el divisor es cero
     */
    private double realizarOperacion(char operador, Stack<Double> operandStack, int numOperandos) {
        // Realizar la operación con los operandos correspondientes
        double resultado = operandStack.pop(); // Obtener el primer operando
        for (int i = 1; i < numOperandos; i++) { // Iterar sobre los operandos restantes
            double siguienteOperando = operandStack.pop(); // Obtener el siguiente operando
            switch (operador) { // Realizar la operación correspondiente
                case '+':
                    resultado += siguienteOperando; // Suma
                    break;
                case '-':
                    resultado -= siguienteOperando; // Resta
                    break;
                case '*':
                    resultado *= siguienteOperando; // Multiplicación
                    break;
                case '/':
                    if (siguienteOperando == 0) { // Verificar que el divisor no sea cero
                        throw new ArithmeticException("División por cero"); 
                    }
                    resultado /= siguienteOperando; // División
                    break;
            }
        }
        return resultado; // Devolver el resultado
    }

    
    /**
     * Verifica si el elemento es un operando válido
     * @param elemento El elemento a verificar
     * @return {@code true} si el elemento es un número, {@code false} en caso contrario
     */
    public boolean esOperando(String elemento) {
        try {
            Double.parseDouble(elemento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Verifica si el elemento es un operador válido
     * @param elemento El elemento a verificar
     * @return {@code true} si el elemento es un operador (+, -, *, /), {@code false} en caso contrario
     */
    public boolean esOperador(String elemento) {
        return elemento.equals("+") || elemento.equals("-") || elemento.equals("*") || elemento.equals("/");
    }

}



