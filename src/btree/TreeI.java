package btree;

public interface TreeI {

    public boolean isEmpty();

    public void inOrder();

    public void insertBST(Comparable c);

    public Node insertOrderedBST(Comparable value);

    public void deleteBST(Comparable k);

    public Node deleteBST(Node t, Comparable k);

    public Node sucessorInorder(Node T);

    public Node copy(Node t);

    public boolean NodeExists(Comparable c);

    public Node searchBST(Comparable info);

}
