package graph;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

class DrawCircles implements Serializable {

    private LinkedList<Circle> circles = new LinkedList<Circle>();
    FrameGraph fg = new FrameGraph();

    public DrawCircles() {
        fg.dc = this;
    }

    public void addCircle(Circle c) {
        this.circles.addLast(c);
    }

    public void drawCircle(Graphics g) {
        Circle cir = null;
        Iterator<Circle> it = this.circles.iterator();
        while (it.hasNext()) {
            cir = it.next();
            cir.drawCircle(g);
        }
    }
}
