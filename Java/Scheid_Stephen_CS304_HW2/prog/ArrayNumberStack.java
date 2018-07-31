// The array based implementation for the NumberStack ADT
// Do not make any changes to this file!
// Xiwei Wang

public class ArrayNumberStack implements NumberStack
{
    // instance variables
    private int[] m_array;
    private int m_index = 0;
    
    // constructor
    public ArrayNumberStack(int cap)
    {
        m_array = new int[cap];
    }

    // check whether the stack is empty
    public boolean isEmpty()
    {
        if (m_index == 0)
            return true;
        else
            return false;
    }
    
    // check whether the stack is full
    public boolean isFull()
    {
        if (m_index == m_array.length)
            return true;
        else
            return false;
    }

    // return the element at the top of the stack
    public int top()
    {
        if (isEmpty())
            throw new RuntimeException("top attempted on an empty stack");
        else
            return m_array[m_index - 1];
    }
            
    // push a value onto the stack
    public void push(int v)
    {
        if (isFull())
            throw new RuntimeException("push attempted on a full stack");
        else
        {
            m_array[m_index] = v;
            m_index++;
        }
    }
    
    // remove and return the element at the top of the stack
    public int pop()
    { 
        if (isEmpty())
            throw new RuntimeException("pop attempted on an empty stack");
        else
        {
            int v = m_array[m_index - 1];
            m_index--;
            
            return v;
        }
    }

    // return the size of the stack
    public int size()
    {       
        return m_index;
    }
    
    // return a string representation of the stack
    @Override
    public String toString()
    {
        String stackContent = "";
        
        for (int i = 0; i < m_index; i++)
            stackContent += m_array[i] + " ";

        return stackContent;    
    }
}
