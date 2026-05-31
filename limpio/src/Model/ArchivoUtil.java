package Model;

import java.io.*;
import java.util.*;

public class ArchivoUtil {
    
    private static final String ARCHIVO_CONTENIDOS = "data/contenidos.csv";
    
    // Escritura de archivos
    public static void guardarContenidos(List<ContenidoAudiovisual> contenidos) throws IOException {
        File directorio = new File("data");
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_CONTENIDOS))) {
            for (ContenidoAudiovisual contenido : contenidos) {
                writer.write(contenido.toCSV());
                writer.newLine();
            }
        }
    }
    
    // Lectura de archivos
    public static List<ContenidoAudiovisual> cargarContenidos() throws IOException {
        List<ContenidoAudiovisual> contenidos = new ArrayList<>();
        File archivo = new File(ARCHIVO_CONTENIDOS);
        
        if (!archivo.exists()) {
            return contenidos;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                ContenidoAudiovisual contenido = parsearLinea(linea);
                if (contenido != null) {
                    contenidos.add(contenido);
                }
            }
        }
        return contenidos;
    }
    
    private static ContenidoAudiovisual parsearLinea(String linea) {
        String[] partes = linea.split(";");
        if (partes.length < 2) return null;
        
        String tipo = partes[0];
        
        switch (tipo) {
            case "Pelicula":
                if (partes.length >= 4) {
                    return new Pelicula(partes[1], Integer.parseInt(partes[2]), partes[3]);
                }
                break;
            case "SerieDeTV":
                if (partes.length >= 4) {
                    return new SerieDeTV(partes[1], Integer.parseInt(partes[2]), partes[3]);
                }
                break;
            case "Documental":
                if (partes.length >= 6) {
                    Investigador inv = new Investigador(partes[4], partes[5]);
                    return new Documental(partes[1], Integer.parseInt(partes[2]), partes[3], inv);
                }
                break;
        }
        return null;
    }
}