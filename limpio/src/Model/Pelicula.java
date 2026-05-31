package Model;

import java.util.ArrayList;
import java.util.List;

public class Pelicula extends ContenidoAudiovisual {
    private String director;
    private List<Actor> actores;

    public Pelicula(String titulo, int duracionEnMinutos, String director) {
        super(titulo, duracionEnMinutos);
        this.director = director;
        this.actores = new ArrayList<>();
    }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    
    public List<Actor> getActores() { return actores; }
    
    public void agregarActor(Actor actor) {
        if (actor != null) {
            actores.add(actor);
        }
    }

    @Override
    public String toCSV() {
        return String.format("Pelicula;%s;%d;%s", 
            getTitulo(), getDuracionEnMinutos(), director);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Director: " + director);
        if (!actores.isEmpty()) {
            System.out.println("Actores (" + actores.size() + "):");
            for (Actor actor : actores) {
                System.out.println("  - " + actor.getNombre() + " (" + actor.getEdad() + " años)");
            }
        }
    }
}