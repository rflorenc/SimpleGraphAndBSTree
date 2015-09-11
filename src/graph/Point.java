package graph;

import java.io.Serializable;

public class Point implements Serializable{

    private float x;
    private float y;

    
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

    
    public float distanceX(Point p) {
        return Math.abs(x - p.getX());
    }

    public float distanceY(Point p) {
        return Math.abs(y - p.getY());

    }

    public float distance(Point p) {
        double dx = distanceX(p);
        double dy = distanceY(p);
        return (float) Math.sqrt(dx * dx + dy * dy);
    }


    @Override
    public String toString() {
        return "Point@(" + this.x + ", " + this.y + ")";
    }

}
