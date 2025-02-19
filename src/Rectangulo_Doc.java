import java.util.Random;

/**
 * @author Daniel
 * @version 1.0
 */
public class Rectangulo_Doc {
    private Punto_Doc p1;
    private Punto_Doc p2;
    private static int min = 0;
    private static int max = 100;

    /**
     *
     * @param p1 Punto 1 del rectángulo, corresponde al de abajo izquierda
     * @param p2 Punto 2 del rectángulo, corresponde al de arriba derecha
     * @see Punto_Doc
     */
    public Rectangulo_Doc(Punto_Doc p1, Punto_Doc p2) {
        if (rectanguloValido(p1.getX(), p1.getY(), p2.getX(),  p2.getY())) {
            this.p1 = new Punto_Doc(p1.getX(),p1.getY());
            this.p2 = new Punto_Doc(p2.getX(),p2.getY());
            System.out.println("Rectángulo correcto");
            System.out.println("*******************");
        }else {
            System.out.println("Error al instanciar el rectángulo");
            System.out.println("*********************************");
        }
    }

    /**
     *
     * @return Devuelve el punto 1 del rectángulo
     */
    public Punto_Doc getP1() {
        return p1;
    }

    /**
     *
     * @return Retorna el punto 2 del rectángulo
     */
    public Punto_Doc getP2() {
        return p2;
    }

    /**
     *
     * @param x Entero que indica la nueva coordenada x del punto 1
     * @param y Entero que indica la nueva coordenada y del punto 1
     */
    public void setP1(int x, int y) {
        if (rectanguloValido(x,y,this.p2.getX(),this.p2.getY())) {
            Punto_Doc p1 = new Punto_Doc(x, y);
            this.p1 = p1;
            System.out.println("*****************");
            System.out.println("Punto_Doc actualizado");
            System.out.println("*****************");
        }else {
            System.out.println("*********************************");
            System.out.println("Punto_Doc no válido, no se modificará");
            System.out.println("*********************************");
        }
    }

    /**
     *
     * @param x Entero que indica la nueva coordenada x del punto 2
     * @param y Entero que indica la nueva coordenada y del punto 2
     */
    public void setP2(int x, int y) {
        if (rectanguloValido(this.p1.getX(),this.p1.getY(),x,y)) {
            Punto_Doc p2 = new Punto_Doc(x, y);
            this.p2 = p2;
            System.out.println("*****************");
            System.out.println("Punto_Doc actualizado");
            System.out.println("*****************");
        }else {
            System.out.println("*********************************");
            System.out.println("Punto_Doc no válido, no se modificará");
            System.out.println("*********************************");
        }
    }

    public void imprimirRectangulo() {
        if (rectanguloValido(p1.getX(), p1.getY(), p2.getX(), p2.getY())) {
            System.out.println("Coordenada 1: (" + p1.getX() + ", " + p1.getY() + ")");
            System.out.println("Coordenada 2: (" + p2.getX() + ", " + p2.getY() + ")");
            System.out.println("Coordenada 3: (" + p1.getX() + ", " + p2.getY() + ")");
            System.out.println("Coordenada 4: (" + p2.getX() + ", " + p1.getY() + ")");
            System.out.println("Perímetro: " + getPerimetro());
            System.out.println("Área: " + getArea());
            System.out.println();
        }else {
            System.out.println("Rectángulo mal instanciado");
            System.out.println();
        }
    }

    /**
     *
     * @return Retorna el perimetro del rectángulo en forma de int
     */
    public int getPerimetro() {
        int lado = Math.abs(p2.getY() - p1.getY());
        int base = Math.abs(p2.getX() - p1.getX());

        return ((base * 2) + (lado * 2));
    }

    /**
     *
     * @return Devuelve el área del rectángulo en forma de int
     */
    public int getArea() {
        int lado = Math.abs(p2.getY() - p1.getY());
        int base = Math.abs(p2.getX() - p1.getX());

        return (base * lado);
    }

    /**
     *
     * @param x1 Entero que indica coordenada x del punto 1
     * @param y1 Entero que indica coordenada y del punto 1
     * @param x2 Entero que indica coordenada x del punto 2
     * @param y2 Entero que indica coordenada y del punto 2
     * @return Boolean que devuelve un true si el punto 1 es el de abajo izquierda y el punto 2 es el de arriba derecha
     */
    private boolean rectanguloValido(int x1, int y1, int x2, int y2) {
        if (x1 < min || y1 < min || x2 < min || y2 < min) {
            System.out.println("Error, coordenadas inferiores a 0");
            return false;
        }else if (x1 > max || y1 > max || x2 > max || y2 > max) {
            System.out.println("Error, coordenadas superiores a 100");
            return false;
        }
        return  (x1 <= x2 && y1 <= y2);
    }

    /**
     *
     * @return Devuelve un rectángulo generado aleatoriamente
     */
    public static Rectangulo_Doc rectanguloAleatorio() {
        Random rdm = new Random();
        int x1, y1, x2, y2;
        x1 = rdm.nextInt(0,99);
        y1 = rdm.nextInt(0,99);
        x2 = rdm.nextInt(x1,100);
        y2 = rdm.nextInt(y1,100);
        Rectangulo_Doc rect = new Rectangulo_Doc(new Punto_Doc(x1,y1), new Punto_Doc(x2,y2));
        return rect;
    }
}
