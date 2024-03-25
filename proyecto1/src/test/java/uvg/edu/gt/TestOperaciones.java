package uvg.edu.gt;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class TestOperaciones {

    @Test
    public void testCalcularResultado()throws IOException {
        Operaciones operaciones = new Operaciones();
        Stack<String> stack = new Stack<>();
        stack.push("(");
        stack.push("5");
        stack.push("2");
        stack.push("+");
        stack.push(")");

        double resultado = operaciones.Operar();
        assertEquals(7.0, resultado, 0.001); // Verifica que el resultado sea 9.0 con un delta de 0.001
    }
}
