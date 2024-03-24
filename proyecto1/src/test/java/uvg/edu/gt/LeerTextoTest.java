package uvg.edu.gt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList<String> arregloEsperado = new ArrayList<>(Arrays.asList("Hola", "(", "10", "1", "8", "30", "*", "1", "2", "3", "4", "5", ")"));
        
        // Aquí puedes agregar aserciones para verificar que las palabras se leen correctamente
        assertEquals(13, palabras.size()); // Por ejemplo, verifica el tamaño del ArrayList
        assertTrue(palabras.contains("Hola")); 
        assertEquals(arregloEsperado,palabras);
    }


   
}
