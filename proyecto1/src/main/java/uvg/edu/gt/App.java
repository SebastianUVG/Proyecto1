package uvg.edu.gt;

/**
 * Aplicación principal de la calculadora de expresiones
 * 
 * @author sebas
 *
 */
public class App {
	
	/**
	 * Método principal de la aplicación
	 * 
	 * @param args
	 *            argumentos pasados por la línea de comandos
	 * @throws Exception
	 *             en caso de errores al leer el archivo
	 */
	public static void main(String[] args) throws Exception {
		
		/* Creamos un objeto de la clase LeerTexto para leer el archivo */
		LeerTexto lector = new LeerTexto();
		
		/* Creamos un objeto de la clase Operaciones para realizar las operaciones */
		Operaciones operaciones = new Operaciones();
		
		/* Imprimimos un mensaje antes de leer el archivo */
		System.out.println("La expresion a evaluar es la siguiente: ");
		
		/* Llamamos al método de la clase LeerTexto para leer el archivo */
		lector.leerArchivo();
		
		/* Imprimimos un mensaje después de leer el archivo */
		//System.out.println("Siguiente ");
		
		/* Llamamos al método de la clase LeerTexto para obtener el contenido del archivo como un ArrayList */
		//System.out.println(lector.textReader());
		
		/* Imprimimos un mensaje antes de realizar las operaciones */
		System.out.println("Resultado de las operaciones:");
		
		/* Llamamos al método de la clase Operaciones para realizar las operaciones */
		operaciones.Operar();
		
		/* Imprimimos un mensaje después de realizar las operaciones */
		System.out.println(" ");
	}
}


