package graph;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Graph implements Serializable {

    private int numvert; 
    private int numarc; 
    //array of lists which represents the graph on the screen
    protected LinkedList l; 
    Vector<LinkedList> adjList = new Vector<LinkedList>();    
    Vector<Vertex> vertices = new Vector<Vertex>();
    protected LinkedList[] previous;   // array of lists - dijkstra algorithm
    protected int[] comp;              // array to represent the shortest paths
    protected LinkedList auxList;      
    protected boolean[] visit;
    private Queue<Integer> queue = new LinkedList<Integer>();
    FrameGraph fg = null;
    
    public Graph() {
    }
    
    public Graph(int nVertices) {
        numvert = nVertices;
        visit = new boolean[numvert + 1];
        comp = new int[numvert + 1];
        for (int i = 0; i <= numvert; i++) {
            visit[i] = false;
            comp[i] = 999;
            adjList.addElement(new LinkedList());
        }
    }

    public int Vertices() {
        return numvert;
    }

    
    public int numArcos() {
        numarc = 0;
        for (int i = 1; i < adjList.size(); i++) {
            if (adjList.elementAt(i) != null) {
                LinkedList lista = adjList.elementAt(i);
                numarc += lista.size();
            }
        }
//        System.out.print("\n" + "Archs (total):");
        return numarc;
    }

    // Connects two vertex with an arch
    public void Addarc(Vertex Vert1, Vertex Vert2, int cost) {
        // get point reference
        int v1 = Vert1.getReference(); 
        int v2 = Vert2.getReference();
        LinkedList List = adjList.elementAt(v1);
        List.add(v2);
        List.add(cost);
        this.vertices.add(Vert1); //adds vertex to our vector
        this.vertices.add(Vert2);
        Vert1.Varch.add(new Arch(Vert1, Vert2, cost)); //criar novo arco de ligacao entre Vert1 e Vert2
    }

    public void Addarcv(int v1, int v2, int custo) {
        this.Addarc(getVertice(v1), getVertice(v2), custo);
    }

    public Vertex getVertice(int i) {
        return this.vertices.elementAt(i);
    }

    public void addVertice(Vertex v) {
        vertices.addElement(v);
    }

    public void removeVertice(int n) {
        vertices.removeElementAt(n);
    }

    // marks nodes as visited, recursively
    public void Dfs_Rec(int ref) {
        System.out.print(" " + ref); //write
        //JOptionPane.showMessageDialog(null, "Values: " + ref, "Verify graph type:", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Values:" + ref);
        visit[ref] = true;
        l = adjList.elementAt(ref);
        ListIterator iter = l.listIterator();

        while (iter.hasNext()) {
            int val = (Integer) iter.next();
            if (!visit[val]) {
                Dfs_Rec(val);
            }
            iter.next();
        }
    }

    //Limpar Visits
    public void clearVisit() {
        for (int i = 1; i
                <= adjList.size(); i++) {
            visit[i] = false;
        }
    }

    public boolean GraphConexo(int ref) {
        for (int i = 1; i <= numvert; i++) {
            visit[i] = false;
        }
        Dfs_Rec(ref);
        for (int i = 1; i <= numvert; i++) {
            if (!visit[i]) {
                return false;
            }
        }
        return true;
    }

    //Para teste BFS Iterativo
    public void BFS(int ref) {
        clearVisit();
        System.out.println("Prim: " + ref);
        visit[ref] = true;
        queue.add(ref); // adiciona 1 nodo visitado a lista
        while (!queue.isEmpty()) { //enquanto lista nao estiver vazia
            int del = (Integer) queue.remove(); // first in , first out
            l = adjList.elementAt(del);
            ListIterator iterador = l.listIterator(); // temp = info[nodo_cur]

            while (iterador.hasNext()) {
                int val = (Integer) iterador.next();

                if (!visit[val]) {
                    visit[val] = true;
                    System.out.println("LinkedList: " + val);
                    queue.add(val);
                }
                iterador.next();

            }
        }
    }

    public void Shortest_Path(int start) {

        for (int i = 0; i
                <= numvert; i++) {
            comp[i] = 999;
        }
        System.out.println("\nSHORTEST_PATH:" + start);
        comp[start] = 0;
        queue.add(start); // adiciona 1 nodo visitado a lista

        while (!queue.isEmpty()) { //enquanto lista nao estiver vazia
            int nodo_cur = (Integer) queue.remove(); // first in , first out
            l = adjList.elementAt(nodo_cur);
            ListIterator iterador = l.listIterator(); // temp = info[nodo_cur]

            while (iterador.hasNext()) {
                int val = (Integer) iterador.next();

                int custo = (Integer) iterador.next();

                if (comp[val] == 999) {
                    comp[val] = comp[nodo_cur] + custo;
                    System.out.println("" + comp[val]);
                    queue.add(val);
                }
                //iterador.next();
            }
        }
        for (int i = 1; i < comp.length; i++) {
            JOptionPane.showMessageDialog(null, "Comprimento de[" + start + "," + i + "] = " + comp[i] + "\n", "SHORTEST_PATH:" + start, JOptionPane.INFORMATION_MESSAGE);
            //System.out.print("Comprimento de[" + start + "," + i + "] = " + comp[i] + "\n");
        }
        System.out.println(" --  -- ");

    }

    // procedure to determine the shortest paths and costs
    public void dijkstra(int start) {
        System.out.println("dijkstra(" + start + "): starting...");
        Iterator iterador;
        Queue fila = new LinkedList();

        int dmin = 0;

        for (int j = 1; j <= numvert; j++) {
            comp[j] = 999;
        }
        comp[start] = 0;
        // for (int i=1;i<=n;i++) visit[i] = false;
        System.out.println("queueing " + start);
        fila.add(start);

        while (!fila.isEmpty()) {
            int nodo_id = (Integer) fila.remove();
            System.out.println("  nodo_id = " + nodo_id);
            auxList = this.adjList.elementAt(nodo_id);
            iterador = auxList.iterator();

            while (iterador.hasNext()) {
                int nodo_adj = ((Integer) iterador.next());
                int custo = ((Integer) iterador.next());
                System.out.println("    nodo_adj = " + nodo_adj + ", custo = " + custo);
                dmin = comp[nodo_id] + custo;
                System.out.println("    dmin = comp[" + nodo_id + "] = " + comp[nodo_id] + " + custo = " + custo);
                System.out.println("    comp[" + nodo_adj + "] = " + comp[nodo_adj]);

                if (dmin < (comp[nodo_adj])) {
                    System.out.println("    dmin = " + dmin + " < comp[" + nodo_adj + "]=" + comp[nodo_adj]);
                    comp[nodo_adj] = dmin;
                    previous = new LinkedList[this.adjList.size() + 1];
                    for (int i = 1; i <= this.adjList.size(); i++) {
                        previous[i] = new LinkedList();
                    }
                    LinkedList prev = previous[nodo_adj];
                    LinkedList auxPrev = previous[nodo_id];
                    if (prev.size() > 0 && auxPrev.size() > 0 && prev.contains(auxPrev.getFirst())) {
                        prev.clear();
                    }
                    Iterator auxIter = auxPrev.iterator();
                    while (auxIter.hasNext()) {
                        prev.add(auxIter.next());
                    }
                    prev.add(nodo_id);
                    System.out.println("    queueing " + nodo_adj);
                    fila.add(nodo_adj);
                }
            }
        }
        // print the shortest paths
        System.out.print("\n");
        for (int i = 1; i <= numvert; i++) {
            System.out.print(i + "-" + previous[i] + "\n");
        }
        System.out.print("\n Dijkstra - shortest paths - start vertex: " + start + " - ");
        for (int i = 1; i <= numvert; i++) {
            System.out.print(comp[i] + " ");
        }
        System.out.println("\ndijkstra(" + start + "): end!");
    }

    public void save2bin(File selectedFile) {
        OutputStream o = null;
        try {
            ObjectOutputStream oos = null;
            try {
                o = new FileOutputStream(selectedFile);
                oos = new ObjectOutputStream(o);
                oos.writeObject(this);

            } catch (IOException ex) {
                Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    oos.close();

                } catch (IOException ex) {
                    Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                o.close();
            } catch (IOException ex) {
                Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
//    public void drawGraph(Graphics g) {
//        this.drawNodes(g);
//        this.drawArcs(g);
//    }
//    private void drawNodes(Graphics g) {
//        Circulo cir = null;
//        Iterator<GraphNode> it = this.graphNodesList.iterator();
//        while (it.hasNext()) {
//            GraphNode gn = it.next();
//            cir = gn.getCirculo();
//            cir.drawCirculo(g);
//        }
//    }
//    /* Insere ligação (arco) entre dois vértices */
//    public void AddGraphNode(Circulo c) {
//        this.graphNodesList.addElement(new GraphNode(c));
//        return;
//
//    }
//  private void drawArcs(Graphics g) {
//        g.setColor(Color.WHITE);
//
//        Iterator<GraphNode> it = this.graphNodesList.iterator();
//        for (int i = 1; i <= adjList.size(); i++) {
//            while (it.hasNext()) {
//                this.adjList.elementAt(i);
//                //c1 liga c2
//                Circulo c1 = null;
//                Ponto centro1 = c1.getPoint(0);
//                int x1 = (int) centro1.getX();
//                int y1 = (int) centro1.getY();
//                Circulo c2 = null;
//                Ponto centro2 = c2.getPoint(0);
//                int x2 = (int) centro2.getX();
//                int y2 = (int) centro2.getY();
//                g.drawLine(x1, y1, x2, y2); // gb1 to gb2
//
//            }
//        }
//    }

