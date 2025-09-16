package tp4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

public class ColegioGUI extends JFrame {
    public static HashSet<Alumno> setAlumnos = new HashSet<>();
    public static HashSet<Materia> setMaterias = new HashSet<>();
    private JDesktopPane escritorio = new JDesktopPane();

    public ColegioGUI() {
        super("TP4 - Colegio (GUI)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);

        // menu
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem mAltaMat = new JMenuItem("Alta Materia");
        JMenuItem mAltaAlu = new JMenuItem("Alta Alumno");
        JMenuItem mIns = new JMenuItem("Inscripción");
        JMenuItem mSalir = new JMenuItem("Salir");
        menu.add(mAltaMat); menu.add(mAltaAlu); menu.add(mIns); menu.addSeparator(); menu.add(mSalir);
        mb.add(menu);
        setJMenuBar(mb);
        add(escritorio);

        // actions
        mAltaMat.addActionListener(e -> {
            AltaMateriaFrame f = new AltaMateriaFrame(setMaterias);
            escritorio.add(f); f.setVisible(true);
        });
        mAltaAlu.addActionListener(e -> {
            AltaAlumnoFrame f = new AltaAlumnoFrame(setAlumnos);
            escritorio.add(f); f.setVisible(true);
        });
        mIns.addActionListener(e -> {
            InscripcionFrame f = new InscripcionFrame(setAlumnos, setMaterias);
            escritorio.add(f); f.setVisible(true);
        });
        mSalir.addActionListener(e -> System.exit(0));

        // preload sample data
        setMaterias.add(new Materia(1,"Web 2",2));
        setMaterias.add(new Materia(2,"Matemáticas",1));
        setMaterias.add(new Materia(3,"Laboratorio 1",1));

        setAlumnos.add(new Alumno(1001,"López","Martin"));
        setAlumnos.add(new Alumno(1002,"Martínez","Brenda"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ColegioGUI().setVisible(true);
        });
    }
}
