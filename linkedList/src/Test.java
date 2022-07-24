public class Test {
    public static void main(String[] args) throws LinkedListEmptyException, NoNodeException {
        LinkedList<Integer> test = new LinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.show();
        System.out.println("--------");
        test.reverseShow();
        System.out.println("-----------");
        test.reverse();
        test.show();

        System.out.println("--------");
        test.remove(4);
        test.show();

        System.out.println("--------");
        test.remove(1);
        test.show();

        System.out.println("---------");
        test.addToX(3,4);
        test.show();

        System.out.println("----------");
        test.addToFirst(5);
        test.show();

        System.out.println("----------");
        System.out.println(test.getNode(3));
        System.out.println("------------");
        test.getNode(6);
    }
}
