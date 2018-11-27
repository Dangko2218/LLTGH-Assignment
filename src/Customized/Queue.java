/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customized;

/**
 *
 * @author User
 */
public class Queue<T extends Comparable<? super T>> implements QueueInterface<T> {
    
    private Node<T> firstNode;
    private int numberOfEntries;
    
    public Queue(){
        firstNode = null;
        numberOfEntries=0;
    }

    @Override
    public boolean enqueue(T newEntry) {
        Node newNode = new Node<>(newEntry);
        Node nodeBefore = null;							
        Node<T> currentNode = firstNode;
        while (currentNode != null && newEntry.compareTo(currentNode.data) > 0) {
          nodeBefore = currentNode;
          currentNode = currentNode.next;
        }

        if (isEmpty() || (nodeBefore == null)) { // CASE 1: add at beginning
            newNode.next = firstNode;
            firstNode = newNode;
        } else {	// CASE 2: add in the middle or at the end, i.e. after nodeBefore
            newNode.next = currentNode;
            nodeBefore.next = newNode;
        }
        numberOfEntries++;
        return true;
    }

    @Override
    public T dequeue() {
        T result = null;
        if (!isEmpty()){
            if(numberOfEntries==1){
                result =  firstNode.data;
                firstNode = null;
                numberOfEntries--;
            }
            else{
                result =  firstNode.data;
                firstNode = firstNode.next;
                numberOfEntries--;
            }
        }
        return result;
    }

    @Override
    public T getFront() {
        T item = null;
        
        if (!isEmpty())
            item =  firstNode.data;
        return item;
    }
    
    public T get(int index) {
        T result = null;
        if(!isEmpty()&&index<numberOfEntries){
            Node<T> currentNode = firstNode;
            for(int i = 0; i<index;i++)
                currentNode=currentNode.next;
            result = currentNode.data; 
        }
            
        return result;
    }
    
    public boolean update(int index, T newEntry) {
        
        if(!isEmpty()&&index<numberOfEntries){
            Node<T> currentNode = firstNode;
            for(int i = 0; i<index;i++)
                currentNode=currentNode.next;
            currentNode.data = newEntry;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isEmpty() {
        if(firstNode == null && numberOfEntries==0)
            return true;
        else
            return false;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }
    
    public class Node<T> {

        private T data;
        private Node<T> next;

        private Node() {
          this.data = null;
          this.next = null;
        }

        private Node(T data) {
          this.data = data;
          this.next = null;
        }

        private Node(T data, Node<T> next) {
          this.data = data;
          this.next = next;
        }
    } // end Node
    
}
