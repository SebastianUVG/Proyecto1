package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeerTexto {
    private String rutaArchivo;

    public LeerTexto(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public ArrayList<String> textReader() throws IOException {
        ArrayList<String> palabras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabrasEnLinea = linea.split("\\s+"); // Dividir la línea en palabras usando espacios como delimitador
                for (String palabra : palabrasEnLinea) {
                    if (!palabra.isEmpty()) { // Si la palabra no está vacía (es decir, no es solo un espacio en blanco)
                        palabras.add(palabra); // Agregar la palabra al ArrayList
                    }
                }
            }
        }
        return palabras;
    }
    
//* Función para leer el contenido que tiene el archivo tal cual como esta */
    public void leerArchivo() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }


    // Función para leer elemento por elemento de una cadena y meterlo en un ArrayList
    // Función para leer elemento por elemento de una cadena y meterlo en un ArrayList, eliminando espacios en blanco
    public ArrayList<Character> LeerCaracter() throws IOException {
        ArrayList<Character> caracteres = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            int valor;
            while ((valor = br.read()) != -1) {
                char caracter = (char) valor;
                if (!Character.isWhitespace(caracter)) { // Verificar si el carácter no es un espacio en blanco
                    caracteres.add(caracter);
                }
            }
        }
        
        return caracteres;
    }




}
