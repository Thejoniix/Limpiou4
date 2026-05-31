package Model;

public class Temporada {
    private int numero;
    private int numeroEpisodios;

    public Temporada(int numero, int numeroEpisodios) {
        this.numero = numero;
        this.numeroEpisodios = numeroEpisodios;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    
    public int getNumeroEpisodios() { return numeroEpisodios; }
    public void setNumeroEpisodios(int numeroEpisodios) { this.numeroEpisodios = numeroEpisodios; }

    public String toCSV() {
        return String.format("%d;%d", numero, numeroEpisodios);
    }
    
    public void mostrarInformacion() {
        System.out.println("  Temporada " + numero + ": " + numeroEpisodios + " episodios");
    }
}