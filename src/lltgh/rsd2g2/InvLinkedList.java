package lltgh.rsd2g2;

public class InvLinkedList<T> implements InvListInterface<T> {
    Node lastNode = null;
    Node firstNode = null;
    private int numOfEnt = 0;

    @Override
    public void add(T item) {
        Node newNode = new Node(item);

        if (isEmpty()){
            firstNode = newNode;
            lastNode = newNode;
            numOfEnt++;
        } else {
            lastNode.next = newNode;
            newNode.previous = lastNode;
            lastNode = newNode;
            numOfEnt++;
        }
    }
    
    @Override
    public T remove() {
        T item = null;
        if (!isEmpty()){
            if (lastNode.next == lastNode) {
                item = firstNode.data;
                lastNode = lastNode.previous;
                lastNode.next = null;
                numOfEnt--;
            }
        }
        return item;
    }

    @Override
    public int size() {
        return numOfEnt;
    }

    @Override
    public boolean isEmpty() {
        if (lastNode == null)
            return true;
        else return false;
    }
    
    public String print(Node showNode) {
        String s;
        if (showNode == null) {
            s = " ";
        } else {
            s = showNode.data.toString();
            s += print(showNode.next);
        }
        return s;
    }

    public String toString() {
        String o = "";
        o += print(firstNode);
        return o;
    }

    @Override
    public T get(int index) {
        T result = null;
        if (isEmpty() && index < numOfEnt){
            Node currentNode = firstNode;
            for (int i = 0; i < index; i++){
                currentNode = currentNode.next;
            }
            result = currentNode.data;
        }
        return result;
    }

    public class Node {
        T data;
        Node next;
        Node previous;
        Invoice invoice = new Invoice();

        public Node(T data){
            this.data = data;
        }
    }
}