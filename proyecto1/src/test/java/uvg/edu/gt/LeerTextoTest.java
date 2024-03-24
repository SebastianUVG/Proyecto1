package uvg.edu.gt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class LeerTextoTest 
{

    //String rutaArchivo = "C:\\Users\\sebas\\OneDrive\\Escritorio\\Github\\EstructuraDeDatos\\Proyecto1\\proyecto1\\src\\main\\java\\uvg\\edu\\gt\\Test.txt";
       
    /**
     * Rigorous Test :-)
     * @throws IOException 
     */
    @Test
    public void TestTextReader() throws IOException
    {
        LeerTexto lector = new LeerTexto();
        ArrayList<String> palabras = lector.textReader();
        // Aquí puedes agregar aserciones para verificar que las palabras se leen correctamente
        assertEquals(1, palabras.size()); // Por ejemplo, verifica el tamaño del ArrayList
        assertTrue(palabras.contains("(5+2*5/(5+10))")); 
    }


    @Test
    public void testLeerCaracter() throws IOException {
        LeerTexto lector = new LeerTexto();
        ArrayList<Character> caracteres = lector.LeerCaracter();
        
        // Aquí puedes agregar aserciones para verificar que los caracteres se leen correctamente
        assertEquals(14, caracteres.size()); // Por ejemplo, verifica el tamaño del ArrayList
        assertTrue(caracteres.contains('+')); // Verifica si un carácter específico está presente
    }
}
