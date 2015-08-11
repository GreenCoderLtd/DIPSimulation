/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishek
 */
public interface IQueue<T> {
    
    public void enqueue(T o);
    public void enqueueFront(T o);
    public T dequeue(); 
    public int size();
    public int maxsize();
    public boolean IsFull();
    
}
