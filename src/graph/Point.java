package graph;

import java.io.Serializable;

public class Point implements Serializable{

    private float x;
    private float y;

    //CONSTRUTOR//
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

     public Point(double p1, double p2) {
        this.x = (float) p1;
        this.y = (float) p2;
    }


    //GETS E SETS //
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    
    public float distanciaX(Point p) {
        return Math.abs(x - p.getX());
    }

    public float distanciaY(Point p) {
        return Math.abs(y - p.getY());

    }

    public float distancia(Point p) {
        double dx = distanciaX(p);
        double dy = distanciaY(p);
        return (float) Math.sqrt(dx * dx + dy * dy);
    }


    @Override
    public String toString() {
        return "Ponto@(" + this.x + ", " + this.y + ")";
    }

}
