package Model;

import java.util.ArrayList;
import java.util.List;

public class SerieDeTV extends ContenidoAudiovisual {
    private String creador;
    private List<Temporada> temporadas;

    public SerieDeTV(String titulo, int duracionPorEpisodio, String creador) {
        super(titulo, duracionPorEpisodio);
        this.creador = creador;
        this.temporadas = new ArrayList<>();
    }

    public String getCreador() { return creador; }
    public void setCreador(String creador) { this.creador = creador; }
    
    public List<Temporada> getTemporadas() { return temporadas; }
    
    public void agregarTemporada(Temporada temporada) {
        if (temporada != null) {
            temporadas.add(temporada);
        }
    }
    
    public int getTotalEpisodios() {
        int total = 0;
        for (Temporada temp : temporadas) {
            total += temp.getNumeroEpisodios();
        }
        return total;
    }

    @Override
    public String toCSV() {
        return String.format("SerieDeTV;%s;%d;%s", 
            getTitulo(), getDuracionEnMinutos(), creador);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Creador: " + creador);
        System.out.println("Total episodios: " + getTotalEpisodios());
        for (Temporada temp : temporadas) {
            temp.mostrarInformacion();
        }
    }
}