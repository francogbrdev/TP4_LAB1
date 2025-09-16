package tp4;

public class Colegio {
    
    public static void main(String[] args) {
        System.out.println("=== TRABAJO PRÁCTICO 4 - MÉTODO MAIN ===\n");
        
        // 1. Crear las materias
        Materia web2 = new Materia(1, "Web 2", 2);
        Materia matematicas = new Materia(2, "Matemáticas", 1);
        Materia laboratorio1 = new Materia(3, "Laboratorio 1", 1);
        
        System.out.println("1. Materias creadas:");
        System.out.println("   - " + web2);
        System.out.println("   - " + matematicas);
        System.out.println("   - " + laboratorio1);
        
        // 2. Crear 2 alumnos
        Alumno lopez = new Alumno(1001, "López", "Martin");
        Alumno martinez = new Alumno(1002, "Martínez", "Brenda");
        
        System.out.println("\n2. Alumnos creados:");
        System.out.println("   - " + lopez);
        System.out.println("   - " + martinez);
        
        // 3. Inscribir a López en las 3 materias
        System.out.println("\n3. Inscribiendo a López en las 3 materias:");
        boolean resultado1 = lopez.agregarMateria(web2);
        System.out.println("   - Web 2: " + (resultado1 ? "✓ Inscripto" : "✗ Ya estaba inscripto"));
        
        boolean resultado2 = lopez.agregarMateria(matematicas);
        System.out.println("   - Matemáticas: " + (resultado2 ? "✓ Inscripto" : "✗ Ya estaba inscripto"));
        
        boolean resultado3 = lopez.agregarMateria(laboratorio1);
        System.out.println("   - Laboratorio 1: " + (resultado3 ? "✓ Inscripto" : "✗ Ya estaba inscripto"));
        
        // 4. Inscribir a Martínez en las 3 materias y volver a inscribirlo en Laboratorio 1
        System.out.println("\n4. Inscribiendo a Martínez en las 3 materias:");
        boolean resultado4 = martinez.agregarMateria(web2);
        System.out.println("   - Web 2: " + (resultado4 ? "✓ Inscripto" : "✗ Ya estaba inscripto"));
        
        boolean resultado5 = martinez.agregarMateria(matematicas);
        System.out.println("   - Matemáticas: " + (resultado5 ? "✓ Inscripto" : "✗ Ya estaba inscripto"));
        
        boolean resultado6 = martinez.agregarMateria(laboratorio1);
        System.out.println("   - Laboratorio 1: " + (resultado6 ? "✓ Inscripto" : "✗ Ya estaba inscripto"));
        
        System.out.println("\n   Intentando inscribir a Martínez nuevamente en Laboratorio 1:");
        boolean resultado7 = martinez.agregarMateria(laboratorio1);
        System.out.println("   - Laboratorio 1 (2° intento): " + (resultado7 ? "✓ Inscripto" : "✗ Ya estaba inscripto"));
        
        // 5. Visualizar la cantidad de materias a las que está inscripto cada alumno
        System.out.println("\n5. CANTIDAD DE MATERIAS POR ALUMNO:");
        System.out.println("=====================================");
        System.out.println(lopez.toString() + " - Materias: " + lopez.cantidadMaterias());
        System.out.println(martinez.toString() + " - Materias: " + martinez.cantidadMaterias());
        
        System.out.println("\n=== FIN DEL MÉTODO MAIN ===");
        
        // Opcional: Lanzar la interfaz gráfica después
        System.out.println("\nLanzando interfaz gráfica...");
        javax.swing.SwingUtilities.invokeLater(() -> {
            new ColegioGUI().setVisible(true);
        });
    }
}