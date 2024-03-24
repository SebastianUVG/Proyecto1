package uvg.edu.gt;


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
            //Operaciones operaciones = new Operaciones();
            System.out.println("La expresion a evaluar es la siguiente: ");
            lector.leerArchivo();
            System.out.println("Siguiente ");
            System.out.println(lector.textReader());

            System.out.println("Resultado de las operaciones:");
            //operaciones.Operar();
            System.out.println("Siguiente caracteres");
            
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

