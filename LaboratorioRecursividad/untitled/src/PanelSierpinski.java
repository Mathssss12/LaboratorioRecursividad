import javax.swing.*;
import java.awt.*;


public class PanelSierpinski extends JPanel {

    private int nivel = 1;


    private int contadorLlamadas = 0;


    public PanelSierpinski() {
        setBackground(Color.WHITE);
    }


    public void setNivel(int n) {
        this.nivel = Math.max(0, n);
        repaint();
    }


    public int getNivel() { return nivel; }


    public int getContador() { return contadorLlamadas; }

 //Metodo Componente
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        contadorLlamadas = 0;

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int margen = 50;
        int ancho  = getWidth()  - 2 * margen;
        int alto   = getHeight() - 2 * margen - 40;

        double h = ancho * (Math.sqrt(3.0) / 2.0);
        if (h > alto) {
            h     = alto;
            ancho = (int) (h * 2.0 / Math.sqrt(3.0));
        }

        double cx = getWidth()  / 2.0;
        double cy = margen + h;

        Punto a = new Punto(cx,               margen);
        Punto b = new Punto(cx - ancho / 2.0, cy);
        Punto c = new Punto(cx + ancho / 2.0, cy);

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1.0f));

        sierpinski(g2, nivel, a, b, c);

        g2.setFont(new Font("Consolas", Font.PLAIN, 12));
        g2.drawString("Llamadas recursivas: " + contadorLlamadas, margen, getHeight() - 12);
    }

    // Método recursivo que construye el fractal

    private void sierpinski(Graphics2D g2, int nivel, Punto a, Punto b, Punto c) {

        contadorLlamadas++;

        // CASO BASE: condición estricta de salida
        if (nivel == 0) {
            dibujarTriangulo(g2, a, b, c);
            return;
        }

        // DIVIDIR: cálculo de puntos medios
        Punto m1 = a.medio(b);
        Punto m2 = b.medio(c);
        Punto m3 = c.medio(a);

        // VENCER: 3 llamadas recursivas descendentes
        sierpinski(g2, nivel - 1, a,  m1, m3);
        sierpinski(g2, nivel - 1, m1, b,  m2);
        sierpinski(g2, nivel - 1, m3, m2, c );
    }

    // Metodo para dibujar un triángulo dado por sus vértices
    private void dibujarTriangulo(Graphics2D g2, Punto a, Punto b, Punto c) {
        int[] xs = { (int) a.x, (int) b.x, (int) c.x };
        int[] ys = { (int) a.y, (int) b.y, (int) c.y };
        g2.drawPolygon(xs, ys, 3);
    }
}