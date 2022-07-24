import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    private static final double boundary = 1e300;

    public static void main(String[] args) throws OverstepBoundaryException, ExpressionException {
        System.out.println(calculate());
    }
    public static double calculate () throws OverstepBoundaryException, ExpressionException {
        double result = 0;
        Stack<Character> ch = new Stack<>();
        ch.push('#');
        Stack<Double> num = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String[] expression = sc.nextLine().split(" ");

        int i = 0;
        while (i < expression.length)
        {
            char tch = expression[i++].charAt(0);

            if (tch == '+' || tch == '-' || tch == '*' || tch == '/' || tch == '(' || tch == ')')
            {
                int xx = 0;
                char t = ch.pop();
                char flag = getPriority(t, tch);
                if (flag == '<') {
                    ch.push(t);
                    ch.push(tch);
                }else if (flag == '>') {
                    do{
                        double a = num.pop();
                        double b = num.pop();
                        result = computing(t, b, a);
                        if (result > boundary){
                            throw new OverstepBoundaryException();
                        }
                        num.push(result);
                        xx = 1;
                        t = ch.pop();
                        flag = getPriority(t, tch);
                    }while (flag == '>');
                }
                if (flag == '='){
                    continue;
                }else if (flag == '<' && xx == 1)
                {
                    ch.push(t);
                    ch.push(tch);
                }
            }
            else if (!(tch <= '9' && tch >= '0')){
                try {
                    throw new ExpressionException();
                } catch (ExpressionException e) {
                    e.printStackTrace();
                }
            }else{
                num.push(Double.parseDouble(expression[i - 1]));
            }
        }
        char c = ch.pop();
        while (c != '#')
        {
            result = computing(c, num.pop(), num.pop());
            num.push(result);
            c = ch.pop();
        }
        return result;
    }

    private static double computing(char theta, double a, double b) throws ExpressionException {
        if (theta == '+') return a + b;
        else if (theta == '-') return a - b;
        else if (theta == '*') return a * b;
        else {
            if (b == 0){
                throw new ExpressionException("除数为零");
            }
            else return a / b;
        }
    }

    private static char getPriority(char theta1, char theta2)
    {
        final char[][] priority =
                {
                    {'>', '>', '<', '<', '<', '>', '>'},
                    {'>', '>', '<', '<', '<', '>', '>'},
                    {'>', '>', '>', '>', '<', '>', '>'},
                    {'>', '>', '>', '>', '<', '>', '>'},
                    {'<', '<', '<', '<', '<', '=', '0'},
                    {'>', '>', '>', '>', '0', '>', '>'},
                    {'<', '<', '<', '<', '<', '0', '='}
                };
        int index1 = getIndex(theta1);
        int index2 = getIndex(theta2);
        return priority[index1][index2];
    }
    private static int getIndex(char theta)
    {
        int index = 0;
        switch (theta)
        {
            case '+':
                index = 0;
                break;
            case '-':
                index = 1;
                break;
            case '*':
                index = 2;
                break;
            case '/':
                index = 3;
                break;
            case '(':
                index = 4;
                break;
            case ')' :
                index = 5;
                break;
            case '#':
                index = 6;
            default:break;
        }
        return index;
    }
}
