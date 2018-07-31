// The BSTNode class that represents BST nodes
// Do not make any changes to this file!
// Xiwei Wang

public class BSTNode 
{
   // instance variables
   private int m_value;
   private BSTNode m_left;
   private BSTNode m_right;
   
   // constuctor
   public BSTNode(int value)
   {
      m_value = value;
      m_left = null;
      m_right = null;
   }
   
   // getters and setters
   public int getInfo()
   {
      return m_value;
   }
   
   public BSTNode getLeft()
   {
      return m_left;
   }
   
   public BSTNode getRight()
   {
      return m_right;
   }
   
   public void setLeft(BSTNode left)
   {
      m_left = left;
   }
   
   public void setRight(BSTNode right)
   {
      m_right = right;
   }      
}
