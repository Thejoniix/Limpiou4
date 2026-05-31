package Model;

public abstract class ContenidoAudiovisual {
    protected String titulo;
    protected int duracionEnMinutos;

    public ContenidoAudiovisual(String titulo, int duracionEnMinutos) {
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public int getDuracionEnMinutos() { return duracionEnMinutos; }
    public void setDuracionEnMinutos(int duracionEnMinutos) { this.duracionEnMinutos = duracionEnMinutos; }

    public abstract String toCSV();
    
    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Duración: " + duracionEnMinutos + " minutos");
    }
}