package test;

import Model.Investigador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class InvestigadorTest {
    
    private Investigador investigador;
    
    @BeforeEach
    void setUp() {
        investigador = new Investigador("Carlos Perez", "Biologia Marina");
    }
    
    @Test
    void testCrearInvestigador() {
    	System.out.println("===========================");
    	System.out.println("");
        System.out.println("Test: Investigador - Crear Investigador");
        assertEquals("Carlos Perez", investigador.getNombre());
        assertEquals("Biologia Marina", investigador.getEspecialidad());
        System.out.println("OK: Investigador creado");
    }
    
    @Test
    void testSetNombre() {
        System.out.println("Test: Investigador - Modificar nombre");
        investigador.setNombre("Ana Lopez");
        assertEquals("Ana Lopez", investigador.getNombre());
        System.out.println("OK: Nombre modificado");
    }
    
    @Test
    void testToCSV() {
        System.out.println("Test: Investigador - Convertir a CSV");
        String csv = investigador.toCSV();
        assertEquals("Carlos Perez;Biologia Marina", csv);
        System.out.println("OK: CSV generado");
        System.out.println("===========================");
    }
}