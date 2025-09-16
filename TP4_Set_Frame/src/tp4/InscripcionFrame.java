package tp4;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class InscripcionFrame extends JInternalFrame {
    public InscripcionFrame(Set<Alumno> alumnos, Set<Materia> materias) {
        super("Inscripción", true, true, true, true);
        setSize(500,300);
        setLayout(new BorderLayout());
        DefaultListModel<Alumno> lmAl = new DefaultListModel<>();
        DefaultListModel<Materia> lmMa = new DefaultListModel<>();
        for (Alumno a: alumnos) lmAl.addElement(a);
        for (Materia m: materias) lmMa.addElement(m);
        JList<Alumno> listAl = new JList<>(lmAl);
        JList<Materia> listMa = new JList<>(lmMa);
        JPanel p = new JPanel(new GridLayout(1,2));
        p.add(new JScrollPane(listAl));
        p.add(new JScrollPane(listMa));
        add(p, BorderLayout.CENTER);
        JButton btn = new JButton("Inscribir");
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(e -> {
            Alumno a = listAl.getSelectedValue();
            Materia m = listMa.getSelectedValue();
            if (a==null || m==null) {
                JOptionPane.showMessageDialog(this,"Seleccione alumno y materia.");
                return;
            }
            boolean added = a.agregarMateria(m);
            JOptionPane.showMessageDialog(this, added ? "Inscripción realizada." : "El alumno ya está inscripto en esa materia.");
        });
    }
}
