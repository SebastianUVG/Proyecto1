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
        String rutaArchivo = "C:\\Users\\sebas\\OneDrive\\Escritorio\\Github\\EstructuraDeDatos\\Proyecto1\\proyecto1\\src\\main\\java\\uvg\\edu\\gt\\archivo.txt";
        try {
            LeerTexto lector = new LeerTexto(rutaArchivo);
            
            System.out.println("La expresion a evaluar es la siguiente: ");
            lector.leerArchivo();
            //System.out.println(lector.textReader().get(5));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

