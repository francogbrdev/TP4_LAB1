package tp4;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class AltaAlumnoFrame extends JInternalFrame {
    private Set<Alumno> alumnos;
    public AltaAlumnoFrame(Set<Alumno> alumnos) {
        super("Alta Alumno", true, true, true, true);
        this.alumnos = alumnos;
        setSize(350,200);
        setLayout(new BorderLayout());
        JPanel p = new JPanel(new GridLayout(3,2,5,5));
        JTextField txtLegajo = new JTextField();
        JTextField txtApellido = new JTextField();
        JTextField txtNombre = new JTextField();
        p.add(new JLabel("Legajo:")); p.add(txtLegajo);
        p.add(new JLabel("Apellido:")); p.add(txtApellido);
        p.add(new JLabel("Nombre:")); p.add(txtNombre);
        add(p, BorderLayout.CENTER);
        JButton btn = new JButton("Guardar");
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(ev -> {
            try {
                int legajo = Integer.parseInt(txtLegajo.getText().trim());
                String apellido = txtApellido.getText().trim();
                String nombre = txtNombre.getText().trim();
                Alumno a = new Alumno(legajo, apellido, nombre);
                if (alumnos.add(a)) {
                    JOptionPane.showMessageDialog(this,"Alumno agregado.");
                } else {
                    JOptionPane.showMessageDialog(this,"El alumno ya existe (por legajo).");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Error en los datos.");
            }
        });
    }
}
