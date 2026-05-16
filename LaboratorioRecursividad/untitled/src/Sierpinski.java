import javax.swing.*;
import java.awt.*;

// Metodo Ventana principal con el panel de dibujo y los controles
public class Sierpinski extends JFrame {

    private final PanelSierpinski panelDibujo = new PanelSierpinski();
    private final JTextField      txtNivel    = new JTextField("1", 5);
    private final JLabel          lblNivelAct = new JLabel("Nivel actual: 1");

    // Constructor
    public Sierpinski() {
        super("Triángulo de Sierpinski – Laboratorio Recursividad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JPanel barra = new JPanel();
        JButton btnDibujar = new JButton("Dibujar");
        btnDibujar.addActionListener(e -> aplicarNivel());
        txtNivel.addActionListener(e -> aplicarNivel());

        barra.add(new JLabel("Nivel:"));
        barra.add(txtNivel);
        barra.add(btnDibujar);
        barra.add(lblNivelAct);

        add(panelDibujo, BorderLayout.CENTER);
        add(barra,       BorderLayout.SOUTH);

        setSize(820, 720);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Metodo para aplicar el nivel ingresado por el usuario
    private void aplicarNivel() {
        try {
            int n = Math.max(0, Integer.parseInt(txtNivel.getText().trim()));
            panelDibujo.setNivel(n);
            lblNivelAct.setText("Nivel actual: " + n);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresa un número entero válido.");
            txtNivel.selectAll();
        }
    }
}