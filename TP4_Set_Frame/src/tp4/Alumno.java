package tp4;

import java.util.HashSet;
import java.util.Objects;

public class Alumno {
    private int legajo;
    private String apellido;
    private String nombre;
    private HashSet<Materia> materias = new HashSet<>();

    public Alumno(int legajo, String apellido, String nombre) {
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public int getLegajo() { return legajo; }
    public String getApellido() { return apellido; }
    public String getNombre() { return nombre; }
    public HashSet<Materia> getMaterias() { return materias; }

    public boolean agregarMateria(Materia m) {
        return materias.add(m);
    }

    public int cantidadMaterias() { return materias.size(); }

    @Override
    public String toString() {
        return apellido + " " + nombre + " (Legajo " + legajo + ")";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return legajo == alumno.legajo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(legajo);
    }
}