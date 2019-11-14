/**
* This class handles creating stacks, adding and removing from stacks and 
* checking if a stack is full or is empty.
* 
* This class handles adding objects to the end of the stack, removing objects
* from the end of the stack, creating stacks with a given size, checking if
* the stack is full and checking if the stack is empty.
* @author lambertth
*/

public class Stack 
{
    private Object[] items;
    private int top;
    
    /**
    * Creates a stack with the size provided
    * @param sizein size to make stack
    */
    public Stack(int sizein)
    {
        items = new Object[sizein];
    }
    /**
    * Adds an object to the stack at the end
    * @param obj object to add
    */
    public void push(Object obj)
    {
        items[top ++] = obj;
    }
    /**
    * Removes an object from the end of the Stack and returns it
    * @return Object from end of stack
    */
    public Object pop()
    {
       return items[--top];
    }
    /**
    * Checks if the stack is full or not
    * @return true is stack is full, false is stack isn't full
    */
    public boolean isFull()
    {
        return top == items.length;
    }
    /**
    * Checks if the stack is empty or not
    * @return true is stack is empty, false is stack isn't empty
    */
    public boolean isEmpty()
    {
        return top == 0;
    }
    
}
