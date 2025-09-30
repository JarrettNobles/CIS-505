package Module_4;
import java.util.*;
import java.util.LinkedList;
/*
 *COURSE: CIS 505
 * Assignment: 4.2 BowlingShopApp
 * Author: Jarrett Nobles
 * Due Date: 10-05-2025
 * File: product.java
 * Theme Focus: Inheritance and Polymorphism
 * Description:
 *  A simple generic queue built on LinkedList with behavior per figures 6.1 and 6.2:
 *      -enqueue: addFirst
 *      -dequeue: removeFirst
 *  Notes: This is intentionally specified by the assignment (LIFO-like).
 */
public class GenericQueue<T> {
    //linked list
    private LinkedList<T> list = new LinkedList<>();

    //Add an item to the front of the list (per assignment)
    public void enqueue(T item){
        list.addFirst(item);
    }

    //removes and returns the front item (per assignment)
    public T dequeue(){
        return list.removeFirst();
    }

    //current number of items
    public int size(){
        return list.size();
    }

    //true if the queue is empty.
    public boolean isEmpty(){
        return list.isEmpty();
    }
}//end class
