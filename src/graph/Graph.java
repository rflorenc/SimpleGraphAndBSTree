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

    private int numVert; 
    private int numArch; 
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
        numVert = nVertices;
        visit = new boolean[numVert + 1];
        comp = new int[numVert + 1];
        for (int i = 0; i <= numVert; i++) {
            visit[i] = false;
            comp[i] = 999;
            adjList.addElement(new LinkedList());
        }
    }

    public int Vertices() {
        return numVert;
    }

    
    public int numArches() {
        numArch = 0;
        for (int i = 1; i < adjList.size(); i++) {
            if (adjList.elementAt(i) != null) {
                LinkedList lista = adjList.elementAt(i);
                numArch += lista.size();
            }
        }
//        System.out.print("\n" + "Archs (total):");
        return numArch;
    }

    // Connects two vertices with an arch
    public void addArch(Vertex Vert1, Vertex Vert2, int cost) {
        // get point reference
        int v1 = Vert1.getReference(); 
        int v2 = Vert2.getReference();
        LinkedList List = adjList.elementAt(v1);
        List.add(v2);
        List.add(cost);
        this.vertices.add(Vert1);
        this.vertices.add(Vert2);
        Vert1.Varch.add(new Arch(Vert1, Vert2, cost)); 
    }

    public void addArchv(int v1, int v2, int custo) {
        this.addArch(getVertex(v1), getVertex(v2), custo);
    }

    public Vertex getVertex(int i) {
        return this.vertices.elementAt(i);
    }

    public void addVertex(Vertex v) {
        vertices.addElement(v);
    }

    public void removeVertex(int n) {
        vertices.removeElementAt(n);
    }

    // marks nodes as visited, recursively
    public void Dfs_Rec(int ref) {
        System.out.print(" " + ref); //write
        //JOptionPane.showMessageDialog(null, "Values: " + ref, 
        // "Verify graph type:", JOptionPane.INFORMATION_MESSAGE);
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
    
    public void clearVisit() {
        for (int i = 1; i
                <= adjList.size(); i++) {
            visit[i] = false;
        }
    }

    public boolean ConexGraph(int ref) {
        for (int i = 1; i <= numVert; i++) {
            visit[i] = false;
        }
        Dfs_Rec(ref);
        for (int i = 1; i <= numVert; i++) {
            if (!visit[i]) {
                return false;
            }
        }
        return true;
    }

    public void BFS(int ref) {
        clearVisit();
        System.out.println("First: " + ref);
        visit[ref] = true;
        queue.add(ref); // adds 1 visited node
        while (!queue.isEmpty()) { 
            int del = queue.remove(); // FIFO
            l = adjList.elementAt(del);
            ListIterator iterador = l.listIterator(); 

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
                <= numVert; i++) {
            comp[i] = 999;
        }
        System.out.println("\nSHORTEST_PATH:" + start);
        comp[start] = 0;
        queue.add(start); 

        while (!queue.isEmpty()) { 
            int nodo_cur = (Integer) queue.remove(); 
            l = adjList.elementAt(nodo_cur);
            ListIterator iterador = l.listIterator(); 

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
            // JOptionPane.showMessageDialog(null, "Length of [" + start + 
            //       "," + i + "] = " + comp[i] + "\n", "SHORTEST_PATH:" + 
            //                start, JOptionPane.INFORMATION_MESSAGE);
            System.out.print("Length of [" + start + "," + i + "] = " + comp[i] + "\n");
        }
        System.out.println(" --  -- ");

    }

    // determine the shortest paths and costs
    public void dijkstra(int start) {
        System.out.println("Dijkstra(" + start + "): starting...");
        Iterator iter;
        Queue queue = new LinkedList();

        int dmin = 0;
        for (int j = 1; j <= numVert; j++) {
            comp[j] = 999;
        }
        comp[start] = 0;
        
        System.out.println("queueing " + start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int node_id = (Integer) queue.remove();
            System.out.println("  node_id = " + node_id);
            auxList = this.adjList.elementAt(node_id);
            iter = auxList.iterator();

            while (iter.hasNext()) {
                int node_adj = ((Integer) iter.next());
                int cost = ((Integer) iter.next());
                System.out.println("    node_adj = " + node_adj + ", cost = " + cost);
                dmin = comp[node_id] + cost;
                System.out.println("    dmin = comp[" + node_id + "] = " + comp[node_id] + " + cost = " + cost);
                System.out.println("    comp[" + node_adj + "] = " + comp[node_adj]);

                if (dmin < (comp[node_adj])) {
                    System.out.println("    dmin = " + dmin + " < comp[" + node_adj + "]=" + comp[node_adj]);
                    comp[node_adj] = dmin;
                    previous = new LinkedList[this.adjList.size() + 1];
                    for (int i = 1; i <= this.adjList.size(); i++) {
                        previous[i] = new LinkedList();
                    }
                    LinkedList prev = previous[node_adj];
                    LinkedList auxPrev = previous[node_id];
                    if (prev.size() > 0 && auxPrev.size() > 0 && prev.contains(auxPrev.getFirst())) {
                        prev.clear();
                    }
                    Iterator auxIter = auxPrev.iterator();
                    while (auxIter.hasNext()) {
                        prev.add(auxIter.next());
                    }
                    prev.add(node_id);
                    System.out.println("    queueing " + node_adj);
                    queue.add(node_adj);
                }
            }
        }
        // print the shortest paths
        System.out.print("\n");
        for (int i = 1; i <= numVert; i++) {
            System.out.print(i + "-" + previous[i] + "\n");
        }
        System.out.print("\n Dijkstra - shortest paths - start vertex: " + start + " - ");
        for (int i = 1; i <= numVert; i++) {
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
