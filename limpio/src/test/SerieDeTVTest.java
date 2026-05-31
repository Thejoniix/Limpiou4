package test;

import Model.SerieDeTV;
import Model.Temporada;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SerieDeTVTest {
    
    private SerieDeTV serie;
    
    @BeforeEach
    void setUp() {
        serie = new SerieDeTV("Breaking Bad", 47, "Vince Gilligan");
    }
    
    @Test
    void testCrearSerie() {
    	System.out.println("===========================");
    	System.out.println("");
        System.out.println("Test: Serie TV - Crear Serie");
        assertEquals("Breaking Bad", serie.getTitulo());
        assertEquals(47, serie.getDuracionEnMinutos());
        assertEquals("Vince Gilligan", serie.getCreador());
        System.out.println("OK: Serie creada");
    }
    
    @Test
    void testAgregarTemporada() {
        System.out.println("Test: Serie TV - Agregar Temporada");
        Temporada t1 = new Temporada(1, 7);
        serie.agregarTemporada(t1);
        assertEquals(1, serie.getTemporadas().size());
        System.out.println("OK: Temporada agregada");
    }
    
    @Test
    void testTotalEpisodios() {
        System.out.println("Test: Serie TV - Calcular total episodios");
        serie.agregarTemporada(new Temporada(1, 7));
        serie.agregarTemporada(new Temporada(2, 13));
        assertEquals(20, serie.getTotalEpisodios());
        System.out.println("OK: Total episodios calculado");
    }
    
    @Test
    void testToCSV() {
        System.out.println("Test: Serie TV - Convertir a CSV");
        String csv = serie.toCSV();
        assertTrue(csv.startsWith("SerieDeTV;Breaking Bad;47;Vince Gilligan"));
        System.out.println("OK: CSV generado");
        System.out.println("===========================");
    }
}