package test;

import Model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;

public class ArchivoUtilTest {
    
    private List<ContenidoAudiovisual> contenidos;
    
    @BeforeEach
    void setUp() {
        contenidos = new ArrayList<>();
        contenidos.add(new Pelicula("Test Movie", 120, "Test Director"));
    }
    
    @AfterEach
    void tearDown() {
        File archivo = new File("data/contenidos.csv");
        if (archivo.exists()) {
            archivo.delete();
        }
    }
    
    @Test
    void testGuardarContenidos() {
    	System.out.println("========================");
    	System.out.println("");
        System.out.println("Test: Archivo - Guardar contenidos");
        assertDoesNotThrow(() -> ArchivoUtil.guardarContenidos(contenidos));
        System.out.println("OK: Contenidos guardados");
    }
    
    @Test
    void testCargarContenidos() throws IOException {
        System.out.println("Test: Archivo - Cargar contenidos");
        ArchivoUtil.guardarContenidos(contenidos);
        List<ContenidoAudiovisual> cargados = ArchivoUtil.cargarContenidos();
        assertNotNull(cargados);
        assertFalse(cargados.isEmpty());
        System.out.println("OK: Contenidos cargados");
    }
    
    @Test
    void testCargarArchivoInexistente() throws IOException {
        System.out.println("Test: Archivo - Cargar archivo inexistente");
        File archivo = new File("data/contenidos.csv");
        if (archivo.exists()) {
            archivo.delete();
        }
        List<ContenidoAudiovisual> cargados = ArchivoUtil.cargarContenidos();
        assertTrue(cargados.isEmpty());
        System.out.println("OK: Archivo inexistente devuelve lista vacia");
        System.out.println("===========================");
    }
}