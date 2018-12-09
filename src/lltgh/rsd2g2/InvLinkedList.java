package lltgh.rsd2g2;

public class InvLinkedList<T> implements InvListInterface<T> {
    Node lastNode = null;
    Node firstNode = null;
    private int numOfEnt = 0;
    
    public InvLinkedList(){
        firstNode = new Node(null);
        numOfEnt = 0;
    }

    @Override
    public void add(T item) {
        
        if (firstNode == null)
            firstNode = new Node(item);
        
        Node tempNode = new Node(item);
        Node currentNode = firstNode;
        
        if (currentNode != null){
            while (currentNode.next != null)
                currentNode = currentNode.next;
            currentNode.next = tempNode;
        }
        numOfEnt++;
//        Node newNode = new Node(item);
//
//        if (isEmpty()){
//            firstNode = newNode;
//            lastNode = newNode;
//            numOfEnt++;
//        } else {
//            lastNode.next = newNode;
//            newNode.previous = lastNode;
//            lastNode = newNode;
//            numOfEnt++;
//        }
    }
    
    @Override
    public T remove(int index) {
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
        String output = "";
        if (firstNode != null){
            Node currentNode = firstNode.next;
            while(currentNode != null){
                output += "[" + currentNode.data.toString() + "]" + "\n";
                currentNode = currentNode.next;
            }
        }
        //output += print(firstNode);
        return output;
    }

    @Override
    public T get(int index) {
        if (index < 0)
            return null;
        Node currentNode = null;
        if (firstNode != null){
            currentNode = firstNode.next;
            for (int i = 0; i < index; i++){
                if (currentNode.next == null)
                    return null;
                else currentNode = currentNode.next;
            }
            return currentNode.data;
        }
        return currentNode.data;
//        T item = null;
//        
//        if (isEmpty() && index < numOfEnt){
//            Node currentNode = firstNode;
//            for (int i = 0; i < index; i++){
//                currentNode = currentNode.next;
//            }
//            item = currentNode.data;
//        }
//        return item;
    }

//    @Override
//    public boolean add(int index, T item) {
//        if (index < 0 || index > size())
//            return false;
//        Node newNode = new Node(item);
//        Node prev = null;
//    }

    @Override
    public boolean contains(T item) {
        if (firstNode == null)
            return false;
        if (firstNode.data == item){
            System.out.println(firstNode);
            return true;
        }
        while (firstNode.next != null) {
            firstNode = firstNode.next;
            if (firstNode.data == item){
                System.out.println(firstNode);
                return true;
            }
        }
        return false;
    }

    public class Node {
        T data;
        Node next;
        Node previous;
        Invoice invoice = new Invoice();

        public Node(T item){
            this.next = null;
            this.data = item;
        }

//        public Node(T item, Node next) {
//            this.next = next;
//            this.data = item;
//        }
//        
//        public T get(){
//            return data;
//        }
//        
//        public Node next(){
//            return next;
//        }       
    }
}