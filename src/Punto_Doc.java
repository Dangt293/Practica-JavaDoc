import java.util.Random;

/**
 * @author Daniel
 * @version 1.0
 */
public class Punto_Doc {
    private int x;
    private int y;

    /**
     *
     * @param x Valor entero, coordenada x del punto
     * @param y Valor entero, coordenada y del punto
     */
    public Punto_Doc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return devuelve el valor de x en forma de entero
     */
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return devuelve el valor de y en forma de entero
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y Nueva coordenada y del punto en forma de entero
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @param x Nueva coordenada x del punto en forma de entero
     * @param y Nueva coordenada y del punto en forma de entero
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void imprimirPunto() {
        System.out.println("Coordenadas del punto: (" +x+ ", " +y+ ")");
        System.out.println();
    }

    /**
     *
     * @param x Entero que indica el valor por el que se sustiturá el valor x actual
     * @param y Entero que indica el valor por el que se sustiturá el valor y actual
     */
    public void desplaza(int x, int y) {
        this.x = this.getX() + x;
        this.y = getY() + y;
    }

    /**
     *
     * @param p Punto con el que se quiere medir la distancia respecto al que llama al método
     * @return devuelve en double la distancia entre los puntos redondeada a dos decimales
     */
    public double distancia(Punto_Doc p) {
        double distancia = Math.sqrt(Math.pow((this.x - p.x),2) + Math.pow((this.y - p.y),2));
        distancia = Math.round(distancia * 100);
        System.out.println("Distancia entre los puntos: " +distancia/100);
        return distancia/100;
    }

    /**
     *
     * @return Devuelve un punto generado aleatoriamente
     */
    public static Punto_Doc creaPuntoAleatorio() {
        Random rdm = new Random();
        Punto_Doc puntoAle = new Punto_Doc (rdm.nextInt(-100,101),rdm.nextInt(-100,101));
        return puntoAle;
    }
}
