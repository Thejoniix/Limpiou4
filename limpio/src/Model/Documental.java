package Model;

public class Documental extends ContenidoAudiovisual {
    private String tema;
    private Investigador investigador;

    public Documental(String titulo, int duracionEnMinutos, String tema, Investigador investigador) {
        super(titulo, duracionEnMinutos);
        this.tema = tema;
        this.investigador = investigador;
    }

    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }
    
    public Investigador getInvestigador() { return investigador; }
    public void setInvestigador(Investigador investigador) { this.investigador = investigador; }

    @Override
    public String toCSV() {
        return String.format("Documental;%s;%d;%s;%s;%s", 
            getTitulo(), getDuracionEnMinutos(), tema,
            investigador.getNombre(), investigador.getEspecialidad());
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tema: " + tema);
        investigador.mostrarInformacion();
    }
}