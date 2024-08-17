
/*
    Name: Felix Najera
    PID:  A17618969
 */

import java.util.NoSuchElementException;

/**
* Circular Queue with length being relative
*
* @author Felix Najera
* @since 8/13/2024
*/

public class CharQueue {
    /* instance variables, feel free to add more if you need */
    private char[] circularArray;
    private int length;
    private int front;
    private int rear;
    private int capacity;


    /*
    * Set the capacity of queue of default of 5
    *
    * */
    public CharQueue() {
        circularArray = new char[5];
        capacity = 5;
        length = 0;
        front = 0;
        rear = -1;

    }


    /*
    * Constructs the class and members with non default fields
    * @param capacity the designated size from the outset of the queue
    * @throws IllegalArgumentException checks that the queue isn't empty or "negative"
    * */
    public CharQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1");
        }
        this.capacity = capacity;
        this.circularArray = new char[capacity];
        this.length = 0;
        this.front = 0;
        this.rear = -1;
    }


    /*
    * size check of queue
    * @return binary check for a 0
    * */
    public boolean isEmpty() {
        return length == 0;
    }



    /*
    * Provides the actual quantity of data in the queue
    * @return the amount of the queue that is populated
    * */
    public int size() {
        return length;
    }


    /*
    * "Empties" the queue to no data state
    *
    * */
    public void clear() {
        length = 0;
        front = 0;
        rear = -1;
    }


    /*
    * Places the data into the circular queue ensuring no out of index
    * @param elem element of the queue of type char
    * */
    public void enqueue(char elem) {
        if (length == capacity) {
            expandCapacity();
        }
        rear = (rear + 1) % capacity;
        circularArray[rear] = elem;
        length++;
    }

    /*
    * Access the "first" element of the circular array
    * @return give the data at the front position
    * @throws NoSuchElementException ensures data is present
    * */
    public char peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return circularArray[front];
    }


    /*
    * removes from the circular the data in the position
    * @throws NoSuchElementException ensures the stack isn't out of index accessed
    * @return what the actual char was at the index
    * */
    public char dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        char elem = circularArray[front];
        front = (front + 1) % capacity;
        length--;
        return elem;
    }
}
