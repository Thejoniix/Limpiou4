package Model;

public class Actor {
    private String nombre;
    private int edad;

    public Actor(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String toCSV() {
        return String.format("%s;%d", nombre, edad);
    }
    
    public void mostrarInformacion() {
        System.out.println("Actor: " + nombre + " (Edad: " + edad + ")");
    }
}