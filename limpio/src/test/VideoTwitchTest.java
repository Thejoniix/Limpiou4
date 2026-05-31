package test;

import Model.VideoTwitch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class VideoTwitchTest {
    
    private VideoTwitch video;
    
    @BeforeEach
    void setUp() {
        video = new VideoTwitch("Velada del ano", 120, "ibai", 1000000);
    }
    
    @Test
    void testCrearVideoTwitch() {
    	System.out.println("===========================");
    	System.out.println("");
        System.out.println("Test: Video Twitch - Crear Video");
        assertEquals("Velada del ano", video.getTitulo());
        assertEquals(120, video.getDuracionEnMinutos());
        assertEquals("ibai", video.getCanal());
        assertEquals(1000000, video.getLikes());
        System.out.println("OK: Video Twitch creado");
    }
    
    @Test
    void testSetCanal() {
        System.out.println("Test: Video Twitch - Modificar canal");
        video.setCanal("nuevoCanal");
        assertEquals("nuevoCanal", video.getCanal());
        System.out.println("OK: Canal modificado");
    }
    
    @Test
    void testSetLikes() {
        System.out.println("Test: Video Twitch - Modificar likes");
        video.setLikes(5000);
        assertEquals(5000, video.getLikes());
        System.out.println("OK: Likes modificados");
    }
    
    @Test
    void testToCSV() {
        System.out.println("Test: Video Twitch - Convertir a CSV");
        String csv = video.toCSV();
        assertTrue(csv.contains("VideoTwitch"));
        assertTrue(csv.contains("ibai"));
        System.out.println("OK: CSV generado");
        System.out.println("===========================");
    }
}