    package uvg.edu.gt;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    /**
     * Clase para leer un archivo de texto y almacenar sus contenidos en un
     * ArrayList, separados por palabras.
     *
     * @author sebas
     */
    public class LeerTexto {

        /* Ruta del archivo a leer */
        private String rutaArchivo = "C:\\Users\\sebas\\OneDrive\\Escritorio\\Github\\EstructuraDeDatos\\Proyecto1\\proyecto1\\src\\main\\java\\uvg\\edu\\gt\\archivo.txt";

        /**
         * Función para leer el archivo y meter los datos en un array list palabra
         * por palabra.
         *
         * @return ArrayList con los contenidos del archivo
         * @throws IOException en caso de errores al leer el archivo
         */
        public ArrayList<String> textReader() throws IOException {
            ArrayList<String> palabras = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                // Patrón de expresión regular para encontrar números (enteros y
                // decimales), operadores matemáticos y palabras
                Pattern pattern = Pattern.compile("\\b\\d+(\\.\\d+)?\\b|[+\\-*/()]|\\b\\w+\\b");

                while ((linea = br.readLine()) != null) {
                    Matcher matcher = pattern.matcher(linea);
                    while (matcher.find()) {
                        palabras.add(matcher.group()); // Agregar la coincidencia al ArrayList
                    }
                }
            }
            return palabras;
        }

        /**
         * Función para leer el contenido que tiene el archivo tal cual como
         * está.
         *
         * @throws IOException en caso de errores al leer el archivo
         */
        public void leerArchivo() throws IOException {
            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            }
        }

        /*
         * Función para leer elemento por elemento de una cadena y meterlo en un
         * ArrayList, eliminando espacios en blanco
         *
         * @return ArrayList con los números encontrados en la cadena
         * @throws IOException en caso de errores al leer el archivo
         */
        /*
        public ArrayList<String> LeerCaracter() throws IOException {
            ArrayList<String> numeros = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    // Dividir la línea en palabras separadas por espacios en blanco
                    String[] palabras = linea.split("\\s+");
                    for (String palabra : palabras) {
                        // Verificar si la palabra es un número
                        if (esNumero(palabra)) {
                            numeros.add(palabra);
                        }
                    }
                }
            }

            return numeros;
        }

        // Método para verificar si una cadena es un número (entero o decimal)
        private boolean esNumero(String cadena) {
            try {
                Double.parseDouble(cadena);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        */
    }

