package test;

import Model.Temporada;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class TemporadaTest {
    
    private Temporada temporada;
    
    @BeforeEach
    void setUp() {
        temporada = new Temporada(1, 10);
    }
    
    @Test
    void testCrearTemporada() {
    	System.out.println("===========================");
    	System.out.println("");
        System.out.println("Test: Temporada - Crear Temporada");
        assertEquals(1, temporada.getNumero());
        assertEquals(10, temporada.getNumeroEpisodios());
        System.out.println("OK: Temporada creada");
    }
    
    @Test
    void testSetNumero() {
        System.out.println("Test: Temporada - Modificar numero");
        temporada.setNumero(2);
        assertEquals(2, temporada.getNumero());
        System.out.println("OK: Numero modificado");
    }
    
    @Test
    void testSetNumeroEpisodios() {
        System.out.println("Test: Temporada - Modificar episodios");
        temporada.setNumeroEpisodios(15);
        assertEquals(15, temporada.getNumeroEpisodios());
        System.out.println("OK: Episodios modificados");
    }
    
    @Test
    void testToCSV() {
        System.out.println("Test: Temporada - Convertir a CSV");
        String csv = temporada.toCSV();
        assertEquals("1;10", csv);
        System.out.println("OK: CSV generado");
        System.out.println("===========================");
    }
}