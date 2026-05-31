package Model;

public class SerieNetflix extends ContenidoAudiovisual {
    private String genero;

    public SerieNetflix(String titulo, int duracionEnMinutos, String genero) {
        super(titulo, duracionEnMinutos);
        this.genero = genero;
    }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    @Override
    public String toCSV() {
        return String.format("SerieNetflix;%s;%d;%s", 
            getTitulo(), getDuracionEnMinutos(), genero);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Género: " + genero);
    }
}