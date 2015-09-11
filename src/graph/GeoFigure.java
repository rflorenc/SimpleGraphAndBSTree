package graph;

import java.awt.Color;
import java.io.Serializable;
import java.util.Vector;

public class GeoFigure implements Serializable {

    public Color cor;

    public Vector<Point> points = new Vector<Point>();
    
    public GeoFigure(Color color) {
        this.cor = color;
    }

    public void addPoint(Point p) {
        points.addElement(p);

    }

    public void addPoint(int x, int y) {        
        Point p = new Point(x, y);
        points.addElement(p);
    }

    public void removePoint(int x, int y) {
        Point p = new Point(x, y);
        points.removeElement(p);
    }

    public Point getPoint(int index) {
        if (index < points.size()) {
            return points.elementAt(index);
        }
        return null;
    }

    public void movexy(int dx, int dy) {

    }

}
