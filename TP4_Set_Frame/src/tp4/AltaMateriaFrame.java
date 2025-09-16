package tp4;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class AltaMateriaFrame extends JInternalFrame {
    private Set<Materia> materias;
    public AltaMateriaFrame(Set<Materia> materias) {
        super("Alta Materia", true, true, true, true);
        this.materias = materias;
        setSize(350,200);
        setLayout(new BorderLayout());
        JPanel p = new JPanel(new GridLayout(4,2,5,5));
        JTextField txtId = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtAnio = new JTextField();
        p.add(new JLabel("ID:")); p.add(txtId);
        p.add(new JLabel("Nombre:")); p.add(txtNombre);
        p.add(new JLabel("Año:")); p.add(txtAnio);
        add(p, BorderLayout.CENTER);
        JButton btn = new JButton("Guardar");
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(ev -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                String nombre = txtNombre.getText().trim();
                int anio = Integer.parseInt(txtAnio.getText().trim());
                Materia m = new Materia(id,nombre,anio);
                if (materias.add(m)) {
                    JOptionPane.showMessageDialog(this,"Materia agregada.");
                } else {
                    JOptionPane.showMessageDialog(this,"La materia ya existe.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Error en los datos.");
            }
        });
    }
}
