public class LinkedListEmptyException extends Exception{
    public LinkedListEmptyException() {
        super("链表为空");
    }

    public LinkedListEmptyException(String message) {
        super(message);
    }
}
