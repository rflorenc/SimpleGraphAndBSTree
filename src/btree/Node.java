package btree;

public class Node {

    private FrameTree fa = null;
    private Comparable element;
    private Node leftChild, rightChild;

    public Node() {
    }

    public Node(Comparable element) {
        this.element = element;
    }

    public Node(Comparable elementt, Node l, Node r) {
        element = elementt;
        leftChild = l;
        rightChild = r;
    }

    public FrameTree getFa() {
        return fa;
    }

    public void setFa(FrameTree fa) {
        this.fa = fa;
    }

    public Comparable getElement() {
        return element;
    }

    public void setElement(Comparable element) {
        this.element = element;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        System.out.println("Nodo - insert setLeftChild(): " + leftChild.getElement().toString() + " to left of " + this.element.toString());
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        System.out.println("Nodo - insert setRightChild(): " + rightChild.getElement().toString() + " to right of " + this.element.toString());
        this.rightChild = rightChild;
    }

    // node visit method 
    public void visit() {
        this.fa.addTxtInOrder(element);

    }
}
