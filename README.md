#  Sistema de Gestión de Contenido Audiovisual - POO

##  Descripción del Proyecto

Este proyecto fue desarrollado como parte de la **Tarea #1 de la Unidad 2** de la materia **Programación Orientada a Objetos (POO)** en la **Universidad Politécnica Salesiana**, carrera de **Ingeniería de Software**.

El objetivo principal es modelar y demostrar las **relaciones entre clases** en Java utilizando los conceptos fundamentales de POO:

-  **Herencia**
-  **Agregación**
-  **Composición**
-  **Asociación**

##  Estructura del Proyecto

### Clase base
- `ContenidoAudiovisual` → Clase abstracta o base que contiene atributos comunes como `título` y `duración`.

### Clases derivadas (Herencia)
- `Pelicula`
- `SerieDeTV`
- `Documental`
- `VideoTwitch`
- `SerieNetflix`

### Relaciones entre clases

| Relación       | Ejemplo |
|----------------|------------------------------------------------|
| **Herencia**   | `Pelicula`, `SerieDeTV`, `Documental` heredan de `ContenidoAudiovisual` |
| **Agregación** | `Pelicula` contiene una lista de `Actor` |
| **Composición**| `SerieDeTV` está compuesta por `Temporada` |
| **Asociación** | `Documental` se asocia con `Investigador` |

## Claves implementadas

- `Actor` – nombre y edad del actor.
- `Temporada` – número de temporada y cantidad de episodios.
- `Investigador` – nombre y especialidad del investigador.
- `VideoTwitch` – canal y número de likes.
- `SerieNetflix` – género de la serie.

## Funcionalidades del sistema

-  Registro de películas y sus actores.
-  Gestión de series y temporadas.
-  Gestión de documentales e investigadores.
-  Uso de **getters** y **setters**.
-  Visualización de información mediante métodos `mostrarInformacion()`.

## Ejemplo de salida del programa

```text
Película: El Gran Golpe
Actor: Juan Pérez (35 años)
Temporada 2 de "Misterio Total" - 8 episodios
Documental "Naturaleza Extrema" investigado por Dra. Ana López (Biología)
VideoTwitch: GameZone - 1,200 likes
SerieNetflix: Estrategia Digital - Género: Suspenso
