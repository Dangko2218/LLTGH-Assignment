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
    public boolean update (int index, T newEntry) {
        if (!isEmpty() && index < numOfEnt){
            Node currentNode = firstNode;
            for (int i = 0; i < index; i++)
                currentNode = currentNode.next;
            currentNode.data = newEntry;
            return true;
        } else return false;
    }

    @Override
    public int size() {
        return numOfEnt;
    }

    @Override
    public boolean isEmpty() {
        return (numOfEnt == 0);
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
    }

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
        
        public Node(){
            this.data = null;
            this.next = null;
        }

        public Node(T item){
            this.next = null;
            this.data = item;
        }  
    }
}