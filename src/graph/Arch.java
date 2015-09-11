package graph;

import java.io.Serializable;

public class Arch implements Serializable {

    private Vertex origin;
    private Vertex destination;
    private double cost;

    public Arch() {
    }

    public Arch(Vertex origin, Vertex destination, double cost) {
        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public Vertex getOrigin() {
        return origin;
    }

    public void setOrigin(Vertex origin) {
        this.origin = origin;
    }
}
