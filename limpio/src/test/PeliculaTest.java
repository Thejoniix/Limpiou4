package test;

import Model.Pelicula;
import Model.Actor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class PeliculaTest {
    
    private Pelicula pelicula;
    
    @BeforeEach
    void setUp() {
        pelicula = new Pelicula("Inception", 148, "Christopher Nolan");
    }
    
    @Test
    void testCrearPelicula() {
    	System.out.println("===========================");
    	System.out.println("");
        System.out.println("Test: Pelicula - Crear Pelicula");
        assertEquals("Inception", pelicula.getTitulo());
        assertEquals(148, pelicula.getDuracionEnMinutos());
        assertEquals("Christopher Nolan", pelicula.getDirector());
        System.out.println("OK: Pelicula creada");
    }
    
    @Test
    void testAgregarActor() {
        System.out.println("Test: Pelicula - Agregar Actor");
        Actor actor = new Actor("Leonardo DiCaprio", 49);
        pelicula.agregarActor(actor);
        assertEquals(1, pelicula.getActores().size());
        System.out.println("OK: Actor agregado");
    }
    
    @Test
    void testToCSV() {
        System.out.println("Test: Pelicula - Convertir a CSV");
        String csv = pelicula.toCSV();
        assertTrue(csv.startsWith("Pelicula;Inception;148;Christopher Nolan"));
        System.out.println("OK: CSV generado");
    }
    
    @Test
    void testSetDirector() {
        System.out.println("Test: Pelicula - Modificar Director");
        pelicula.setDirector("Nuevo Director");
        assertEquals("Nuevo Director", pelicula.getDirector());
        System.out.println("OK: Director modificado");
        System.out.println("===========================");
    }
}