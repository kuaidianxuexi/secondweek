public class ExpressionException extends Exception{
    public ExpressionException() {
        super("表达式错误");
    }

    public ExpressionException(String message) {
        super(message);
    }
}
