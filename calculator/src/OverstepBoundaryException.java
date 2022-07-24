public class OverstepBoundaryException extends Exception{
    public OverstepBoundaryException(){super("结算过程或结果有越界的情况");}
    public OverstepBoundaryException(String gripe)
    {
        super(gripe);
    }
}
