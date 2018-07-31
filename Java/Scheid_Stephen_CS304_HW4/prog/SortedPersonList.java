// The SortedPersonList class
// Stevie Scheid

public class SortedPersonList 
{
    // instance variables
    private PersonNode m_first;
    private int m_numElements; 

    // constructor
    // Do not make any changes to this method!
    public SortedPersonList()
    {
        m_first = null;
        m_numElements = 0;
    }

    // check whether the list is empty
    // Do not make any changes to this method!
    boolean isEmpty()
    {
        if (m_first == null)
            return true;
        else
            return false;
    }

    // return the size of the list (# of Person nodes)
    // Do not make any changes to this method!
    public int size()
    {
        return m_numElements;
    }

    // check whether a PersonNode associated with the given ID is in the list
    public boolean contains(int ID)
    {
        PersonNode current = m_first;
        while(current != null)
        {
            if(current.getID() == ID)
               return true;
            else
               current = current.getLink();
        }
        return false;
    }

    // search for and return the PersonNode associated with the given ID
    public PersonNode get(int ID)
    {
        PersonNode current = m_first;
        while(current != null)
        {
            if(current.getID() == ID)
               return current;
            else
               current = current.getLink();
        }
         return null;
    }

    // add a new PersonNode to the list with the given ID and name
    public boolean add(int ID, String name)
    {
        PersonNode newNode = new PersonNode(ID, name); // create a new node with the given value        
        PersonNode current = m_first;       // set up a temporary reference to iterate over the list      
        PersonNode previous = null;         // set up a reference that allows the access to the previous node
        
        
        m_numElements++;

        if(m_first == null)
        {
            m_first = newNode;
            return true;       
        }

           
        while (current != null)
        {    
            // compare the new value with the value of each node
            if (current.getID() < ID)
            {   
                previous = current;
                current = current.getLink();     
            }
            else if(current.getID() == ID)
            {
               return false;
            }
            else
               break;
               
        }
        if (previous == null)
        {
            newNode.setLink(m_first);
            m_first = newNode;
        }
        else
        {
            newNode.setLink(current);       
            previous.setLink(newNode);
            
        }
        
        return true;
    }

    // remove a PersonNode associated with the given ID from the list
    public boolean remove(int ID)
    {
        PersonNode current = m_first;
        PersonNode previous = null;
        boolean found = false;
        m_numElements--;
        
                 
        while (current != null)
        {
            // compare the given value with the value of each node
            if (current.getID() < ID)
            {
                previous = current;
                current = current.getLink();
                           
            }
            else if (current.getID() == ID)
            {
                found = true;
                current = current.getLink();
                
                
                if (previous == null) 
                    m_first = current;
                else  
                    
                    previous.setLink(current);  
                  
            }
            else
                return found;
        
        }
        return found;
         
    }
    
    // return a string representation of the list
    // Do not make any changes to this method!
    public String toString()
    {
        String listContent = "";
        PersonNode current = m_first;
        
        while (current != null)
        {
            listContent += "[" + current.getID() + " | " + current.getName() + "] ";
            current = current.getLink();
        }

        return listContent;
    }    
}