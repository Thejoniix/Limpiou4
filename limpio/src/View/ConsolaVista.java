package View;

import Model.*;
import java.util.*;

public class ConsolaVista {
    private Scanner scanner;
    
    public ConsolaVista() {
        scanner = new Scanner(System.in);
    }
    
    public void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE CONTENIDO AUDIOVISUAL ===");
        System.out.println("1. Agregar Película");
        System.out.println("2. Agregar Serie de TV");
        System.out.println("3. Agregar Documental");
        System.out.println("4. Agregar Video de Twitch");
        System.out.println("5. Agregar Serie de Netflix");
        System.out.println("6. Mostrar todos los contenidos");
        System.out.println("7. Guardar datos");
        System.out.println("8. Cargar datos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    public int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public Pelicula leerPelicula() {
        System.out.println("\n--- NUEVA PELÍCULA ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Duración (minutos): ");
        int duracion = Integer.parseInt(scanner.nextLine());
        System.out.print("Director: ");
        String director = scanner.nextLine();
        
        Pelicula pelicula = new Pelicula(titulo, duracion, director);
        
        System.out.print("¿Desea agregar actores? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            agregarActores(pelicula);
        }
        
        return pelicula;
    }
    
    private void agregarActores(Pelicula pelicula) {
        System.out.println("\n--- AGREGAR ACTORES ---");
        while (true) {
            System.out.print("Nombre del actor (dejar vacío para terminar): ");
            String nombre = scanner.nextLine();
            if (nombre.isEmpty()) break;
            
            System.out.print("Edad del actor: ");
            int edad = Integer.parseInt(scanner.nextLine());
            
            pelicula.agregarActor(new Actor(nombre, edad));
            System.out.println("✓ Actor agregado");
        }
    }
    
    public SerieDeTV leerSerie() {
        System.out.println("\n--- NUEVA SERIE DE TV ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Duración por episodio (minutos): ");
        int duracion = Integer.parseInt(scanner.nextLine());
        System.out.print("Creador: ");
        String creador = scanner.nextLine();
        
        SerieDeTV serie = new SerieDeTV(titulo, duracion, creador);
        
        System.out.print("¿Desea agregar temporadas? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            agregarTemporadas(serie);
        }
        
        return serie;
    }
    
    private void agregarTemporadas(SerieDeTV serie) {
        System.out.println("\n--- AGREGAR TEMPORADAS ---");
        while (true) {
            System.out.print("Número de temporada (0 para terminar): ");
            int num = Integer.parseInt(scanner.nextLine());
            if (num == 0) break;
            
            System.out.print("Número de episodios: ");
            int episodios = Integer.parseInt(scanner.nextLine());
            
            serie.agregarTemporada(new Temporada(num, episodios));
            System.out.println("✓ Temporada " + num + " agregada");
        }
    }
    
    public Documental leerDocumental() {
        System.out.println("\n--- NUEVO DOCUMENTAL ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Duración (minutos): ");
        int duracion = Integer.parseInt(scanner.nextLine());
        System.out.print("Tema: ");
        String tema = scanner.nextLine();
        System.out.print("Investigador: ");
        String investigador = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        
        return new Documental(titulo, duracion, tema, new Investigador(investigador, especialidad));
    }
    
    public VideoTwitch leerVideoTwitch() {
        System.out.println("\n--- NUEVO VIDEO DE TWITCH ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Duración (minutos): ");
        int duracion = Integer.parseInt(scanner.nextLine());
        System.out.print("Canal: ");
        String canal = scanner.nextLine();
        System.out.print("Likes: ");
        int likes = Integer.parseInt(scanner.nextLine());
        
        return new VideoTwitch(titulo, duracion, canal, likes);
    }
    
    public SerieNetflix leerSerieNetflix() {
        System.out.println("\n--- NUEVA SERIE DE NETFLIX ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Duración (minutos): ");
        int duracion = Integer.parseInt(scanner.nextLine());
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        
        return new SerieNetflix(titulo, duracion, genero);
    }
    
    public void mostrarContenidos(List<ContenidoAudiovisual> contenidos) {
        if (contenidos.isEmpty()) {
            System.out.println("\n⚠ No hay contenidos registrados");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        LISTA DE CONTENIDOS             ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        for (int i = 0; i < contenidos.size(); i++) {
            System.out.println("\n┌─────────── Contenido #" + (i + 1) + " ───────────┐");
            contenidos.get(i).mostrarInformacion();
            System.out.println("└────────────────────────────────────────┘");
        }
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n " + mensaje);
    }
    
    public void mostrarError(String error) {
        System.err.println("\n Error: " + error);
    }
}