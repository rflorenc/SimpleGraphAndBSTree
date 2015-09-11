package graph;


import java.awt.Graphics;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;


class DrawCircles implements Serializable {

    private LinkedList<Circle> circulos = new LinkedList<Circle>();
    FrameGraph fg = new FrameGraph();

    public DrawCircles() {
       
        fg.dc=this;
    }

    public void addCirculo(Circle c) {
        this.circulos.addLast(c);
    }

    public void drawCirculos(Graphics g) {
        Circle cir = null;
        Iterator<Circle> it = this.circulos.iterator();
        while (it.hasNext()) {
            cir = it.next();
            cir.drawCirculo(g);
        }

    }
}
