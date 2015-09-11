package graph;

import java.awt.Color;
import java.io.Serializable;
import java.util.Vector;

public class GeoFigure implements Serializable {

    public Color cor;

    public Vector<Point> pontos = new Vector<Point>();

    //CONSTRUTOR//
    public GeoFigure(Color cor) {
        this.cor = cor;
    }

    public void addPonto(Point p) {
        pontos.addElement(p);

    }

    public void addPonto(int x, int y) {
        //Ver Boxing
        Point p = new Point(x, y);
        pontos.addElement(p);
    }

    public void removerPonto(int x, int y) {
        Point p = new Point(x, y);
        pontos.removeElement(p);
    }

    public Point getPonto(int index) {
        if (index < pontos.size()) {
            return pontos.elementAt(index);
        }
        return null;
    }

    public void movexy(int dx, int dy) {

    }

}
