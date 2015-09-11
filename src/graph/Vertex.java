package graph;

import java.io.Serializable;
import java.util.Vector;

public class Vertex implements Serializable {

    private int reference;
    private Point point;
    public Vector<Arch> Varch = new Vector<Arch>();

    public Vertex() {
    }

    public Vertex(int reference, Point point) {
        this.reference = reference;
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public void ListArches() {
        for (int i = 0; i < Varch.size(); i++) {
            System.out.print(Varch.elementAt(i).getCost() + " ");
        }
    }
}
