public class NoNodeException extends Exception{
    public NoNodeException() {
        super("该节点不存在");
    }

    public NoNodeException(String message) {
        super(message);
    }
}
