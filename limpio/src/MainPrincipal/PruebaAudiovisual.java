package MainPrincipal;

import Controller.ContenidoController;

public class PruebaAudiovisual {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CONTENIDO AUDIOVISUAL ===");
        System.out.println("Iniciando aplicación...\n");
        
        ContenidoController controller = new ContenidoController();
        controller.ejecutar();
    }
}