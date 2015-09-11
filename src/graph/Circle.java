package graph;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Circle extends GeoFigure implements Serializable {

    public float raio;
    public Point centro;

//Construtor
    public Circle(Color c, Point centro, float raio) {
        super(c);
        this.raio = raio;
        super.addPonto(centro);
    }

    public Circle(Point centro, float raio) {
        super(Color.YELLOW);
        this.raio = raio;
        super.addPonto(centro);
    }

//Getse SETS //
    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    public double area() {
        return Math.PI * (this.raio * this.raio);
    }

    public void moverXY(float dx, float dy) {
        Point p = super.getPonto(0);
        p.setX((p.getX() + dx));
        p.setY((p.getY() + dy));
    }

    public boolean inside(Point p) {
//   (basicamente, se distância do meu ponto ao outro ponto for menor que o raio então desenha)
        if (Math.sqrt(Math.pow(p.getX() - super.getPonto(0).getX(), 2) + Math.pow(p.getY() - super.getPonto(0).getY(), 2)) < raio) {
            return true;
        }
        return false;
    }

    public void drawCirculo(Graphics g) {

        centro = this.getPonto(0);
        int width = (int) (2 * raio);
        int height = (int) (2 * raio);

        //preenche a Azul
        g.setColor(Color.BLUE);
        g.fillOval((int) centro.getX(), (int) centro.getY(), width, height);
        g.setColor(Color.white);

    }

    @Override
    public String toString() {
        Point p = super.getPonto(0);
        return "circulo[" + p.getX() + ", " + p.getY() + "]";
    }
}
