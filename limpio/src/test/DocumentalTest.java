package test;

import Model.Documental;
import Model.Investigador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class DocumentalTest {
    
    private Documental documental;
    private Investigador investigador;
    
    @BeforeEach
    void setUp() {
        investigador = new Investigador("Carlos Perez", "Biologia Marina");
        documental = new Documental("Vida Marina", 90, "Oceanos", investigador);
    }
    
    @Test
    void testCrearDocumental() {
    	System.out.println("===========================");
    	System.out.println("");
        System.out.println("Test: Documental - Crear Documental");
        assertEquals("Vida Marina", documental.getTitulo());
        assertEquals(90, documental.getDuracionEnMinutos());
        assertEquals("Oceanos", documental.getTema());
        assertEquals(investigador, documental.getInvestigador());
        System.out.println("OK: Documental creado");
    }
    
    @Test
    void testSetTema() {
        System.out.println("Test: Documental - Modificar tema");
        documental.setTema("Cambio Climatico");
        assertEquals("Cambio Climatico", documental.getTema());
        System.out.println("OK: Tema modificado");
    }
    
    @Test
    void testToCSV() {
        System.out.println("Test: Documental - Convertir a CSV");
        String csv = documental.toCSV();
        assertTrue(csv.contains("Documental"));
        assertTrue(csv.contains("Vida Marina"));
        System.out.println("OK: CSV generado");
        System.out.println("===========================");
    }
}