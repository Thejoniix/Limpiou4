package Controller;

import Model.*;
import View.ConsolaVista;
import Model.ArchivoUtil;
import java.io.IOException;
import java.util.*;

public class ContenidoController {
    private List<ContenidoAudiovisual> contenidos;
    private ConsolaVista vista;
    
    public ContenidoController() {
        this.contenidos = new ArrayList<>();
        this.vista = new ConsolaVista();
    }
    
    public void ejecutar() {
        boolean ejecutando = true;
        
        // Intentar cargar datos al iniciar
        cargarDatosAlIniciar();
        
        while (ejecutando) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();
            
            switch (opcion) {
                case 1:
                    agregarPelicula();
                    break;
                case 2:
                    agregarSerie();
                    break;
                case 3:
                    agregarDocumental();
                    break;
                case 4:
                    agregarVideoTwitch();
                    break;
                case 5:
                    agregarSerieNetflix();
                    break;
                case 6:
                    mostrarContenidos();
                    break;
                case 7:
                    guardarDatos();
                    break;
                case 8:
                    cargarDatos();
                    break;
                case 0:
                    ejecutando = false;
                    vista.mostrarMensaje("¡Hasta luego!");
                    break;
                default:
                    vista.mostrarError("Opción inválida. Intente nuevamente.");
            }
        }
    }
    
    private void cargarDatosAlIniciar() {
        try {
            List<ContenidoAudiovisual> cargados = ArchivoUtil.cargarContenidos();
            if (!cargados.isEmpty()) {
                contenidos.addAll(cargados);
                vista.mostrarMensaje("Datos cargados automáticamente (" + contenidos.size() + " contenidos)");
            } else {
                vista.mostrarMensaje("No se encontraron datos previos. Comience agregando contenido.");
            }
        } catch (IOException e) {
            vista.mostrarError("No se pudieron cargar los datos: " + e.getMessage());
        }
    }
    
    private void agregarPelicula() {
        try {
            Pelicula pelicula = vista.leerPelicula();
            contenidos.add(pelicula);
            vista.mostrarMensaje("Película \"" + pelicula.getTitulo() + "\" agregada exitosamente");
        } catch (Exception e) {
            vista.mostrarError("Error al agregar película: " + e.getMessage());
        }
    }
    
    private void agregarSerie() {
        try {
            SerieDeTV serie = vista.leerSerie();
            contenidos.add(serie);
            vista.mostrarMensaje("Serie \"" + serie.getTitulo() + "\" agregada exitosamente");
        } catch (Exception e) {
            vista.mostrarError("Error al agregar serie: " + e.getMessage());
        }
    }
    
    private void agregarDocumental() {
        try {
            Documental documental = vista.leerDocumental();
            contenidos.add(documental);
            vista.mostrarMensaje("Documental \"" + documental.getTitulo() + "\" agregado exitosamente");
        } catch (Exception e) {
            vista.mostrarError("Error al agregar documental: " + e.getMessage());
        }
    }
    
    private void agregarVideoTwitch() {
        try {
            VideoTwitch video = vista.leerVideoTwitch();
            contenidos.add(video);
            vista.mostrarMensaje("Video de Twitch \"" + video.getTitulo() + "\" agregado exitosamente");
        } catch (Exception e) {
            vista.mostrarError("Error al agregar video de Twitch: " + e.getMessage());
        }
    }
    
    private void agregarSerieNetflix() {
        try {
            SerieNetflix serie = vista.leerSerieNetflix();
            contenidos.add(serie);
            vista.mostrarMensaje("Serie de Netflix \"" + serie.getTitulo() + "\" agregada exitosamente");
        } catch (Exception e) {
            vista.mostrarError("Error al agregar serie de Netflix: " + e.getMessage());
        }
    }
    
    private void mostrarContenidos() {
        if (contenidos.isEmpty()) {
            vista.mostrarMensaje("No hay contenidos para mostrar. Agregue algunos primero.");
        } else {
            vista.mostrarContenidos(contenidos);
        }
    }
    
    private void guardarDatos() {
        try {
            ArchivoUtil.guardarContenidos(contenidos);
            vista.mostrarMensaje("Datos guardados exitosamente (" + contenidos.size() + " contenidos)");
        } catch (IOException e) {
            vista.mostrarError("No se pudo guardar: " + e.getMessage());
        }
    }
    
    private void cargarDatos() {
        try {
            List<ContenidoAudiovisual> cargados = ArchivoUtil.cargarContenidos();
            if (!cargados.isEmpty()) {
                contenidos.clear();
                contenidos.addAll(cargados);
                vista.mostrarMensaje("Datos cargados exitosamente (" + contenidos.size() + " contenidos)");
            } else {
                vista.mostrarMensaje("No hay datos para cargar");
            }
        } catch (IOException e) {
            vista.mostrarError("No se pudo cargar: " + e.getMessage());
        }
    }
    
    public List<ContenidoAudiovisual> getContenidos() {
        return contenidos;
    }
    
    public ContenidoAudiovisual buscarPorTitulo(String titulo) {
        for (ContenidoAudiovisual contenido : contenidos) {
            if (contenido.getTitulo().equalsIgnoreCase(titulo)) {
                return contenido;
            }
        }
        return null;
    }
    
    public boolean eliminarContenido(String titulo) {
        ContenidoAudiovisual contenido = buscarPorTitulo(titulo);
        if (contenido != null) {
            contenidos.remove(contenido);
            return true;
        }
        return false;
    }
}