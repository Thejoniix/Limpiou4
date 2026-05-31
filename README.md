#  Sistema de Gestión de Contenido Audiovisual Actualizado
 
Sistema desarrollado en Java para la gestión de contenido audiovisual, aplicando principios de Programación Orientada a Objetos (POO), código limpio, principios SOLID y el patrón de diseño MVC.

##  Descripción

El sistema permite administrar diferentes tipos de contenido audiovisual como películas, series de TV, documentales, videos de Twitch y series de Netflix. Implementa relaciones de herencia, agregación, composición y asociación entre clases, además de persistencia de datos mediante archivos CSV.

##  Objetivos del Proyecto

- Aplicar herencia en Java
- Implementar relaciones entre clases (asociación, agregación, composición)
- Aplicar principios de código limpio y SOLID
- Implementar el patrón MVC (Modelo-Vista-Controlador)
- Desarrollar pruebas unitarias con JUnit 5
- Persistencia de datos mediante archivos CSV

##  Estructura del Proyecto
src/
├── Controller/
│ └── ContenidoController.java # Controlador principal
├── MainPrincipal/
│ └── PruevaAudiovisual.java # Punto de entrada
├── Model/
│ ├── Actor.java # Clase Actor
│ ├── ArchivoUtil.java # Manejo de archivos
│ ├── ContenidoAudiovisual.java # Clase base abstracta
│ ├── Documental.java # Clase Documental
│ ├── Investigador.java # Clase Investigador
│ ├── Pelicula.java # Clase Pelicula
│ ├── SerieDeTV.java # Clase SerieDeTV
│ ├── SerieNetflix.java # Clase SerieNetflix
│ ├── Temporada.java # Clase Temporada
│ └── VideoTwitch.java # Clase VideoTwitch
├── test/
│ ├── ActorTest.java
│ ├── ArchivoUtilTest.java
│ ├── DocumentalTest.java
│ ├── InvestigadorTest.java
│ ├── PeliculaTest.java
│ ├── SerieDeTVTest.java
│ ├── SerieNetflixTest.java
│ ├── TemporadaTest.java
│ └── VideoTwitchTest.java
└── View/
└── ConsolaVista.java # Interfaz de usuario

##  Clases del Sistema

### Clase Base

| Clase | Descripción |
|-------|-------------|
| **ContenidoAudiovisual** | Clase abstracta base con atributos título y duración |

### Clases Derivadas

| Clase | Descripción |
|-------|-------------|
| **Pelicula** | Película con director y lista de actores |
| **SerieDeTV** | Serie con creador y lista de temporadas |
| **Documental** | Documental con tema e investigador |
| **VideoTwitch** | Video de Twitch con canal y likes |
| **SerieNetflix** | Serie de Netflix con género |

### Clases de Apoyo

| Clase | Descripción |
|-------|-------------|
| **Actor** | Actor con nombre y edad |
| **Temporada** | Temporada con número y episodios |
| **Investigador** | Investigador con nombre y especialidad |

##  Relaciones UML

| Tipo | Relación | Multiplicidad |
|------|----------|---------------|
| **Herencia** | ContenidoAudiovisual ← Pelicula, SerieDeTV, Documental, VideoTwitch, SerieNetflix | - |
| **Agregación** | Pelicula → Actor | 1 → 0..* |
| **Composición** | SerieDeTV → Temporada | 1 → 0..* |
| **Asociación** | Documental → Investigador | 1 → 1 |

##  Patrón MVC

| Componente | Ubicación | Responsabilidad |
|------------|-----------|-----------------|
| **Modelo** | src/Model/ | Lógica de negocio y datos |
| **Vista** | src/View/ | Interfaz de usuario en consola |
| **Controlador** | src/Controller/ | Coordinación entre modelo y vista |

##  Principios SOLID Aplicados

| Principio | Aplicación |
|-----------|------------|
| **SRP** | Cada clase tiene una única responsabilidad |
| **OCP** | Clase abstracta ContenidoAudiovisual permite extensión |
| **LSP** | Subclases pueden sustituir a la clase base |
| **ISP** | Métodos específicos por cada clase |
| **DIP** | Dependencia en abstracciones |

##  Funcionalidades

1. **Agregar Película** - Título, duración, director y actores
2. **Agregar Serie de TV** - Título, duración, creador y temporadas
3. **Agregar Documental** - Título, duración, tema e investigador
4. **Agregar Video de Twitch** - Título, duración, canal y likes
5. **Agregar Serie de Netflix** - Título, duración y género
6. **Mostrar Contenidos** - Lista todo el contenido registrado
7. **Guardar Datos** - Persiste en archivo CSV
8. **Cargar Datos** - Recupera desde archivo CSV

##  Manejo de Archivos

Los datos se guardan en `data/contenidos.csv` con el formato:

##  Requisitos

- Java JDK 8 o superior
- JUnit 5 (para ejecutar pruebas)

##  Clonar el Repositorio

```bash
git clone https://github.com/Thejoniix/Limpiou4.git
