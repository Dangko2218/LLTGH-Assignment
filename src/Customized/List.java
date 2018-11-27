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
public class List<T extends Comparable<? super T>> implements ListInterface<T> {
    private Node<T> firstNode;
    private int numberOfEntries;
    
    
    public List() {
        firstNode = null;
        numberOfEntries = 0;
    }

    
    @Override
    public boolean add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        if(isEmpty()){
            firstNode = newNode;
            
        }else{
            Node<T> currentNode = firstNode;
            while(currentNode.next!=null)
                currentNode = currentNode.next;
            currentNode.next = newNode;
        }
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean add(int index, T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        if(isEmpty()||index+1>numberOfEntries){
            return false;   
        }else{
            if(index == 0){
                newNode.next = firstNode;
                firstNode = newNode;
            }else{
            Node<T> currentNode = firstNode;
            for(int i = 0; i<index-1;i++)
                currentNode = currentNode.next;
            if(currentNode.next!= null)
                newNode.next = currentNode.next;
            currentNode.next = newNode;
            }
            numberOfEntries++;
            return true;
        }
    }

    @Override
    public T remove(int index) {
        T result = null;
        if(!isEmpty()&&index<numberOfEntries){
            if(index ==0){
                result = firstNode.data;
                if(firstNode.next!=null)
                    firstNode = firstNode.next;
                else
                   firstNode=null;
            }else{
                Node<T> currentNode = firstNode;
                for(int i = 0; i<index-1;i++)
                    currentNode=currentNode.next;
                result = currentNode.next.data;
                if(currentNode.next.next!=null)
                    currentNode.next = currentNode.next.next;
                else 
                    currentNode.next=null;
            }
            numberOfEntries--;
        }
            
        return result;
    }

    @Override
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

    @Override
    public boolean isEmpty() {
       return numberOfEntries==0;
    }


    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
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
