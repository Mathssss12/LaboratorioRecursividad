
public class Punto {

    public final double x;
    public final double y;

    // Constructor
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Método para calcular el punto medio entre este punto y otro
    public Punto medio(Punto otro) {
        return new Punto(
                (this.x + otro.x) / 2.0,
                (this.y + otro.y) / 2.0
        );
    }


}