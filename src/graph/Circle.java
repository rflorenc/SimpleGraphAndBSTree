package graph;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Circle extends GeoFigure implements Serializable {

    public float radius;
    public Point center;

    public Circle(Color c, Point center, float radius) {
        super(c);
        this.radius = radius;
        super.addPoint(center);
    }

    public Circle(Point center, float radius) {
        super(Color.YELLOW);
        this.radius = radius;
        super.addPoint(center);
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * (this.radius * this.radius);
    }

    public void moveXY(float dx, float dy) {
        Point p = super.getPoint(0);
        p.setX((p.getX() + dx));
        p.setY((p.getY() + dy));
    }

    public boolean isInside(Point p) {
        if (Math.sqrt(Math.pow(p.getX() - super.getPoint(0).getX(), 2)
            + Math.pow(p.getY() - super.getPoint(0).getY(), 2)) < radius) {
                return true;
        }
        return false;
    }

    public void drawCircle(Graphics g) {
        center = this.getPoint(0);
        int width = (int) (2 * radius);
        int height = (int) (2 * radius);
        
        g.setColor(Color.BLUE);
        g.fillOval((int) center.getX(), (int) center.getY(), width, height);
        g.setColor(Color.white);

    }

    @Override
    public String toString() {
        Point p = super.getPoint(0);
        return "Circle[" + p.getX() + ", " + p.getY() + "]";
    }
}
