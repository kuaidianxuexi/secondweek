import org.w3c.dom.ls.LSOutput;

public class LinkedList<T> {
    private Node head;
    private int numberOfEntry;

    public LinkedList(){
        head = null;
        numberOfEntry = 0;
    }

    public boolean addToFirst(T newEntry)
    {
        Node newNode = new Node(newEntry);

        if (head != null)
        {
            newNode.next = head;
            head.pre = newNode;
        }
        head = newNode;
        numberOfEntry++;
        return true;
    }

    public boolean add(T newEntry)
    {
        Node newNode = new Node(newEntry);
        Node curNode = head;
        if (curNode != null) {
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = newNode;
            newNode.pre = curNode;
        }else {
            head = newNode;
        }
        numberOfEntry++;
        return true;
    }

    public boolean addToX(T k, T newEntry) throws LinkedListEmptyException, NoNodeException {
        if (head == null)
            throw new LinkedListEmptyException();
        Node newNode = new Node(newEntry);
        Node curNode = head;
        while( curNode != null && curNode.data != k)
        {
            curNode = curNode.next;
        }
        if (curNode == null)
            throw new NoNodeException();
        else{
            newNode.next = curNode.next;
            newNode.pre = curNode;
            curNode.next.pre = newNode;
            curNode.next = newNode;
        }
        numberOfEntry++;
        return true;
    }

    public boolean remove(T k) throws LinkedListEmptyException, NoNodeException {
        if (head == null)
            throw new LinkedListEmptyException();

        Node curNode = head;

        while (curNode != null && curNode.data != k)
            curNode = curNode.next;

        if (curNode == null)
            throw new NoNodeException();
        else{
            if (curNode.pre == null){//头节点
                head = curNode.next;
                head.pre = null;
            }else if (curNode.next == null){//尾节点
                curNode.pre.next = null;
                curNode.pre = null;
            }else{
                curNode.pre.next = curNode.next;
                curNode.next.pre = curNode.pre;
                curNode = null;
            }
        }
        numberOfEntry--;
        return true;
    }

    public Node getNode(T k) throws LinkedListEmptyException, NoNodeException {
        if (head == null)
            throw new LinkedListEmptyException();
        Node curNode = head;
        while(curNode != null && curNode.data != k)
            curNode = curNode.next;
        if (curNode == null)
            throw new NoNodeException();
        else {
            return curNode;
        }
    }

    public void show()
    {
        if (head == null)
        {
            System.out.println("链表为空！");
            return;
        }
        Node curNode = head;
        while (curNode != null) {
            System.out.println(curNode);
            curNode = curNode.next;
        }
    }

    public void reverseShow()
    {
        if (head != null && head.next != null)
        {
            Node curNode = head;
            while (curNode.next != null)
            {
                curNode = curNode.next;
            }
            while (curNode != null)
            {
                System.out.println(curNode);
                curNode = curNode.pre;
            }
        }
    }

    public void reverse() {
        if (head == null)
            System.out.println("链表为空，无法反转");
        if (head.next == null)
        {
            return;
        }
        Node reverseHead = head;
        while (reverseHead.next != null)
            reverseHead = reverseHead.next;
        Node reverseNode = reverseHead;
        Node preNode = reverseHead.pre;
        Node pre = null;
        while (preNode != null){
            pre = preNode.pre;
            reverseNode.next = preNode;
            preNode.pre = reverseNode;
            reverseNode = reverseNode.next;
            preNode = pre;
        }
        reverseNode.next = null;
        reverseHead.pre = null;
        head = reverseHead;
    }

    public Node getHead() {
        return head;
    }

    public Node getNodePre(Node x)
    {
        return x.pre;
    }

    public Node getNodeNext(Node x)
    {
        return x.next;
    }

    public int getNumberOfEntry() {
        return numberOfEntry;
    }

    private class Node{
        private T data;
        private Node pre;
        private Node next;
        private Node(T data )
        {
            this(data, null, null);
        }

        private Node(T data, Node next, Node pre)
        {
            this.data = data;
            this.next = next;
            this.pre = pre;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
