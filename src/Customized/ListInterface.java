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
public interface ListInterface<T> {
    public boolean add(T newEntry);
    public boolean add(int index, T newEntry);
    public T remove(int index);
    public boolean update(int index, T newEntry);
    public T get(int index);
    public boolean isEmpty();    
    public int size();
}
