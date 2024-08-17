/*
    Name: Felix Najera
    PID:  A17618969
 */

import java.util.EmptyStackException;
import utilities.FullStackException;

/**
* MyStack Class with limited methods to replace the defaults \
* provided by base Java.
* @author Felix Najera
* @since 8/13/2024
*/
public class MyStack {

    private String[] stackArray;
    private int top;
    private int capacity;


    /*
    * find the total max size for the stack\
    * check its valid with a an except
    * @param capacity what the assigned size for the stack will be
    * @throws IllegalArgumentException prevents the size from being null/invalid
    *
    * */
    public MyStack(int capacity) throws IllegalArgumentException {
        if (capacity < 1) {
            new IllegalArgumentException("Capacity must be at least 1");

        }
        this.capacity = capacity;
        this.stackArray = new String[capacity];
        this.top = -1;



    }

    /*
    * Default size for the stack if not assigned
    *
    * */
    public MyStack() {

        this(10);
    }

    /*
    * checks whether or not the instantiation is empty of elements
    * @return prevents the conventional value of -1 to tell that the list\
    * is complete empty and not just index 0
    * */
    public boolean isEmpty() {

        return top == -1;


    }

    /*
    * label the stack as clear and set each as null
    * */
    public void clear() {
        for (int i = 0; i <= top; i++) {
            stackArray[i] = null;
        }
        top = -1;



    }

    /*
    * Just provides the index size basically +1 bc of 0 index
    * @return the actual quantity of data in the stack
    * */
    public int size() {

        return top + 1;



    }

    /*
    * whats effectively a getter for the capacity of max size
    * @return class attribute for max size possible of the stack
    * */
    public int capacity() {
        return capacity;


    }

    /*
    * Allows the first element to be used for assignment
    * @return the size of the stack
    * @throws EmptyStackException ensure an actual populated stack is present
    * */
    public String peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];



    }

    /*
    * Data entry at top of the stack
    * @param element specified String data to enter the stack
    * @throws IllegalArgumentException ensure the element is actually data
    * @throws FullStackException prevents stack overflow of the capacity
    *
    * */
    public void push(String element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (size() == capacity) {
            throw new FullStackException("Your stack is full.");
        }
        stackArray[++top] = element;

    }

    /*
    *
    * Provides whatever was deleted from the stack as a return object
    *
    * @throws EmptyStackException prevents a "deletion" on an empty stack
    * @return provides the actual data of the deleted element
    * */
    public String pop() {


        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }

    /*
    * adds several data to the stack
    * @param elements an "array" of elements to push to the stack
    * */
    public void multiPush(String[] elements) {

        if (elements == null) {
            throw new IllegalArgumentException("Elements cannot be null");
        }
        for (String element : elements) {
            push(element);
        }
    }

    /*
    * Pop several elements of the stack ensuring it's not over size of the stack
    * @return an array of the elements from the stack
    * @throws IllegalArgumentException ensures quantity won't suggest an empty stack
    * */
    public String[] multiPop(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Amount must be a positive number");
        }
        int actualAmount = Math.min(amount, size());
        String[] poppedElements = new String[actualAmount];
        for (int i = 0; i < actualAmount; i++) {
            poppedElements[i] = pop();
        }
        return poppedElements;

    }


}
