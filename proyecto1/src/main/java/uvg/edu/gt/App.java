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

    public static String[] textReader(String rutaArchivo) throws Exception {
        

        List<String> ListaPalabras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String line ;
            while ((line = br.readLine()) != null) {
                String[] wordsInLine = line.split("\\s+"); // Dividir la línea en palabras usando espacios como delimitador
                for (String word : wordsInLine) {
                    ListaPalabras.add(word);
                }
            }
        }
       

        String[] PalabrasLista = new String[ListaPalabras.size()];
        return ListaPalabras.toArray(PalabrasLista);
    
    }






    public static void main( String[] args ) throws Exception
    {
        String rutaArchivo = "C:\\Users\\sebas\\OneDrive\\Escritorio\\Github\\EstructuraDeDatos\\Proyecto1\\proyecto1\\src\\main\\java\\uvg\\edu\\gt\\archivo.txt";
        try {
            String[] palabras  = textReader(rutaArchivo);
            System.out.println("Palabras en el archivo: ");
            for (String palabra : palabras){
                System.out.println(palabra);
            }
        }catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
