package btree;

import graph.Point;

public class Tree implements TreeI {

    // instance data member
    private Node root;
    
    public Tree(Node root) {
        this.root = root;
    }

   
    public Tree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    public boolean isEmpty() {
        if (this.root == null) {
            return true;
        } else {
            return false;
        }
    }

    // inorder traversal - Recursive
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node t) {
        if (t != null) {
            inOrder(t.getLeftChild()); // left subtree
            t.visit(); //visit current node
            inOrder(t.getRightChild()); // right subtree
        }
    }

    public void insertBST(Comparable c) throws DuplicateItemException {
//  System.out.print("insertBST(" + c + ")\n");
        if (this.getRoot() == null) {
            root = new Node(c);
            return;
        }
        this.insertBST(root, c);
    }

    // Recursive ordered insertion
    private void insertBST(Node n, Comparable c) {
        Comparable inf = (Comparable) n.getElement();

//        System.out.println(inf + ".compareTo(" + c + ") = " + inf.compareTo(c));
        if (inf.compareTo(c) > 0) {
//            System.out.println("insert left");
            if (n.getLeftChild() == null) {
                n.setLeftChild(new Node(c));
//                System.out.println("insert " + c);
                return;
            } else {
                insertBST(n.getLeftChild(), c);
            }
        } else {
//            System.out.println("insert right");
            if (n.getRightChild() == null) {
                n.setRightChild(new Node(c));
//                System.out.println("insert " + c);
                return;
            } else {
                insertBST(n.getRightChild(), c);
            }
        }
    }

    //Inserção Ordenada - Iterativo
    public Node insertOrderedBST(Comparable valor) {
        Node newNode = new Node(valor);

        if (this.root == null) {
            this.root = newNode;
            return newNode;
        }
        
        Node p = this.root;
        //Comparable comp = null;

        // search Node
        while (true) {
            Comparable comp = (Comparable) p.getElement();
            // left side
            if ((comp.compareTo(valor)) > 0) {
                if (p.getLeftChild() == null) {
                    p.setLeftChild(newNode);
                    return newNode;
                } else {
                    System.out.println("BTree - Left insertion: " + comp);
                    p = p.getLeftChild();
                }
            } else {
                // right side
                if (p.getRightChild() == null) {
                    p.setRightChild(newNode);
                    return newNode;
                } else {
                    System.out.println("BTree - Right insertion: " + comp);
                    p = p.getRightChild();
                }
            }
        }
    }

    public void deleteBST(Comparable k) throws ItemNotFoundException {
        System.out.println("delete(" + k + ")\n");
        if (this.getRoot() == null) {
            System.out.println("Empty tree\n");
            return;
        }
        root = deleteBST(root, k);
    }

    public Node deleteBST(Node t, Comparable k) {
        if (t == null) {
            return null;
        }
        if (k.equals(t.getElement())) {            
            if (t.getLeftChild() == null && t.getRightChild() == null) {
                return null;    // leaf node
            }
            if (t.getLeftChild() == null) {
                return t.getRightChild();
            }

            if (t.getRightChild() == null) {
                return t.getLeftChild();
            }

            // if t has 2 child nodes
            // 1. find its successor In Order
            // 2. replace it
            Node temp = sucessorInorder(t.getRightChild());
            // copy data from newnode to t
            t.setElement(temp.getElement());
            // delete newNode from the right subtree and return
            t.setRightChild(deleteBST(t.getRightChild(), temp.getElement()));

        } else if (k.compareTo(t.getElement()) < 0) {
            t.setLeftChild(deleteBST(t.getLeftChild(), k));
            return t;
        } else {
            t.setRightChild(deleteBST(t.getRightChild(), k));
            return t;
        }
        return t;
    }

    public Node sucessorInorder(Node T) {
        if (T.getLeftChild() == null) {
            return T;
        } else {
            return sucessorInorder(T.getLeftChild());
        }
    }

    public Node copy(Node t) {        
        if (t == null) {
            return null;
        }
        
        Node temp = new Node(t.getElement(), t.getLeftChild(), t.getRightChild());        
        temp.setLeftChild(copy(t.getLeftChild()));
        temp.setRightChild(copy(t.getRightChild()));
        // returns root node
        return temp;
    }

    
    public boolean NodeExists(Comparable c) throws ItemNotFoundException {
        
        if (root == null) {
            return false;
        }
        
        Node p = root;
        Comparable inf = null;
        // search node
        while (true) {
            inf = (Comparable) p.getElement();
            if (inf.compareTo(c) > 0) {
                if (p.getLeftChild() != null) {
                    p = p.getLeftChild();
                } else {
                    return false;
                }
            } else if (inf.compareTo(c) < 0) {
                if (p.getRightChild() != null) {
                    p = p.getRightChild();
                } else {
                    return false;
                }
            } else // found
                //JOptionPane.showMessageDialog(null,"Node found:"+"\n"+this.elementAt(p),"Informação",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Node found:" + p);
            {
                return (true);
            }
        }
    }

    public Node searchBST(Comparable c) {

        Comparable inf = null;

        if (root == null) {
            return null;
        }

        Node p = root;

        while (true) {
            inf = (Comparable) p.getElement();
            if (inf.compareTo(c) > 0) {
                if (p.getLeftChild() != null) {
                    p = p.getLeftChild();
                } else {
                    return null;
                }
            } else if (inf.compareTo(c) < 0) {
                if (p.getRightChild() != null) {
                    p = p.getRightChild();
                } else {
                    return null;
                }
            } else
            {
                return p;
            }
        }
    }

    //Gerar Tree mas incompleto mas a ideia está lá
    public Node pesquisarBST(int nivel,Comparable c) {

        Comparable inf = null;
        Point point = new Point();
        Tree Agrafo = new Tree();

        //raiz
        Agrafo.insertOrderedBST(new ScreenInfo('H', new Point(500 / 2, 500 / 2)));

        //Arvore vazia
        if (root == null) {
            return null;
        }
        //Declaração do nodo de temporário
        Node p = root;
        //Pesquisar o Node
        while (true) {
            inf = (Comparable) p.getElement();
            if (inf.compareTo(c) > 0) {
                if (p.getLeftChild() != null) {
                    p = p.getLeftChild();
                } else {
                    return null;
                }

            } else if (inf.compareTo(c) < 0) {
                if (p.getRightChild() != null) {
                    p = p.getRightChild();
                } else {
                    return null;
                }
            } else {
                //Encontrar Folha e Gerar dois filhos!!!!
                if (p.getLeftChild() != null && p.getRightChild() != null) {
                    while (nivel != 5) {
                        //Par
                        if (nivel % 2 == 0) {
                            Agrafo.insertOrderedBST(new ScreenInfo('V', new Point(point.getX() / 2, point.getY())));
                            Agrafo.insertOrderedBST(new ScreenInfo('V', new Point((point.getX() * 3) / 4, point.getY())));
                            //impar
                        } else {
                            Agrafo.insertOrderedBST(new ScreenInfo('H', new Point(point.getX(), point.getY() / 2)));
                            Agrafo.insertOrderedBST(new ScreenInfo('H', new Point(point.getX(), (point.getY() * 3) / 4)));
                        }
                    }

                }

            }

        }
    }
}

   
