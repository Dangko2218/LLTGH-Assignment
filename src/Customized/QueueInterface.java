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
public interface QueueInterface<T> {
    
    public boolean enqueue(T newEntry);
    public T dequeue();
    public T getFront();
    public boolean isEmpty();
    public int size();

}
