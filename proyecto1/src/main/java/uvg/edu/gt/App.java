package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args ) throws Exception 
    {
        try {
            LeerTexto lector = new LeerTexto();
            System.out.println("La expresion a evaluar es la siguiente: ");
            lector.leerArchivo();
            System.out.println("Siguiente ");
            System.out.println(lector.textReader());
            System.out.println("siguiente");
            System.out.println(lector.LeerCaracter());
            System.out.println("Siguiente caracteres");
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

