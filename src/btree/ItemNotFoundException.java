
package btree;


public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException() {
        super();
    }

    public ItemNotFoundException(String message) {
        super(message);
    }
}
