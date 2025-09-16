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
        if (txtLegajo.getText().trim().isEmpty() || 
            txtApellido.getText().trim().isEmpty() || 
            txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        int legajo = Integer.parseInt(txtLegajo.getText().trim());
        String apellido = txtApellido.getText().trim().toUpperCase();
        String nombre = txtNombre.getText().trim().toUpperCase();

        Alumno a = new Alumno(legajo, apellido, nombre);
        if (alumnos.add(a)) {
            JOptionPane.showMessageDialog(this,"Alumno agregado.");
            txtLegajo.setText("");
            txtApellido.setText("");
            txtNombre.setText("");
            txtLegajo.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this,"El alumno ya existe (por legajo).");
        }
    } catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(this,"El legajo debe ser un número entero.");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,"Ocurrió un error: " + ex.getMessage());
    }
        });
    }
}
