// The LNode class that reprents a node in linked lists
// Do not make any changes to this file!
// Xiwei Wang

public class LNode 
{
    // instance variables
    private int m_value;
    private LNode m_link;
    
    // constructor
    public LNode(int value)
    {
        m_value = value;
        m_link = null;
    }
    
    // member methods
    public void setLink(LNode link)
    {
        m_link = link;
    }
    
    public LNode getLink()
    {
        return m_link;
    }
    
    public int getInfo()
    {
        return m_value;
    }   
}