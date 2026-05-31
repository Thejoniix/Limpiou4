package Model;

public class VideoTwitch extends ContenidoAudiovisual {
    private String canal;
    private int likes;

    public VideoTwitch(String titulo, int duracionEnMinutos, String canal, int likes) {
        super(titulo, duracionEnMinutos);
        this.canal = canal;
        this.likes = likes;
    }

    public String getCanal() { return canal; }
    public void setCanal(String canal) { this.canal = canal; }
    
    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }

    @Override
    public String toCSV() {
        return String.format("VideoTwitch;%s;%d;%s;%d", 
            getTitulo(), getDuracionEnMinutos(), canal, likes);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Canal: " + canal);
        System.out.println("Likes: " + likes);
    }
}