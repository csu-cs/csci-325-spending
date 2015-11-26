package csu.csci325;

/**
 * Created by BBrak on 11/22/2015.
 */
public interface Queue<T> {
    //adds one element to the rear of this queue.
    public void enqueue(T element);
    public void add(T element);
    //removes and returns the element at the front of this queue.
    public T dequeue();
    public T remove();
    //returns without removing the element at the front of this queue.
    public T first();
    //returns true if this queue contains no elements
    public boolean isEmpty();
    //returns the number of elements in the queue.
    public int size();
    public String toString();
}
