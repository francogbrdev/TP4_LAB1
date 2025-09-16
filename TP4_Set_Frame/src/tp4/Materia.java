package tp4;

public class Materia {
    private int idMateria;
    private String nombre;
    private int anio;

    public Materia(int idMateria, String nombre, int anio) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anio = anio;
    }

    public int getIdMateria() { return idMateria; }
    public String getNombre() { return nombre; }
    public int getAnio() { return anio; }

    @Override
    public String toString() {
        return nombre + " (Año " + anio + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materia)) return false;
        Materia m = (Materia) o;
        return idMateria == m.idMateria;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(idMateria);
    }
}
