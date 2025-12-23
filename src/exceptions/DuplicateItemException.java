package exceptions;

public class DuplicateItemException extends InventoryException {
    public DuplicateItemException(String message) {
        super(message);
    }
}
