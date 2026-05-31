package test;

import Model.Actor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class AcotrTest {
    
    private Actor actor;
    
    @BeforeEach
    void setUp() {
        actor = new Actor("Keanu Reeves", 50);
    }
    
    @Test
    void testCrearActor() {
        System.out.println("===========================");
        System.out.println("");
        System.out.println("Test: Actor - Crear Actor");
        assertEquals("Keanu Reeves", actor.getNombre());
        assertEquals(50, actor.getEdad());
        System.out.println("OK: Actor creado");
    }
    
    @Test
    void testSetNombre() {
        System.out.println("Test: Actor - Modificar nombre");
        actor.setNombre("Scarlett Johansson");
        assertEquals("Scarlett Johansson", actor.getNombre());
        System.out.println("OK: Nombre modificado");
    }
    
    @Test
    void testSetEdad() {
        System.out.println("Test: Actor - Modificar edad");
        actor.setEdad(38);
        assertEquals(38, actor.getEdad());
        System.out.println("OK: Edad modificada");
    }
    
    @Test
    void testToCSV() {
        System.out.println("Test: Actor - Convertir a CSV");
        String csv = actor.toCSV();
        assertEquals("Keanu Reeves;50", csv);
        System.out.println("OK: CSV generado");
        System.out.println("===========================");
    }
}