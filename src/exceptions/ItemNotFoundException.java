package exceptions;

public class ItemNotFoundException extends InventoryException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
