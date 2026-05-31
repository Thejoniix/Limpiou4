package test;

import Model.SerieNetflix;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SerieNetflixTest {
    
    private SerieNetflix serie;
    
    @BeforeEach
    void setUp() {
        serie = new SerieNetflix("Stranger Things", 50, "Ciencia Ficcion");
    }
    
    @Test
    void testCrearSerieNetflix() {
    	System.out.println("===========================");
    	System.out.println("");
        System.out.println("Test: Serie Netflix - Crear Serie");
        assertEquals("Stranger Things", serie.getTitulo());
        assertEquals(50, serie.getDuracionEnMinutos());
        assertEquals("Ciencia Ficcion", serie.getGenero());
        System.out.println("OK: Serie Netflix creada");
    }
    
    @Test
    void testSetGenero() {
        System.out.println("Test: Serie Netflix - Modificar genero");
        serie.setGenero("Terror");
        assertEquals("Terror", serie.getGenero());
        System.out.println("OK: Genero modificado");
    }
    
    @Test
    void testToCSV() {
        System.out.println("Test: Serie Netflix - Convertir a CSV");
        String csv = serie.toCSV();
        assertTrue(csv.startsWith("SerieNetflix;Stranger Things;50;Ciencia Ficcion"));
        System.out.println("OK: CSV generado");
        System.out.println("===========================");
    }
}