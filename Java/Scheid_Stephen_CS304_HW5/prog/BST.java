// The BST class that represents binary search trees
// Stevie Scheid

import java.util.*;

public class BST 
{
    // instance variables
   private BSTNode m_root;
   private int m_size;
    
    // constructor
   public BST()
   {
      m_root = null;
      m_size = 0;
   }
    
    // add a value into the tree
   public void add(int v)
   {
      BSTNode newNode = new BSTNode(v);
        
      if(m_root == null)
      {
         m_root = newNode;
         m_size++;
         return;
      }
        
      BSTNode current = m_root;
      BSTNode parent = null;
        
      while(current != null)
      {
         if(v == current.getInfo())
            return;
            
         parent = current;
            
         if(v < current.getInfo())
            current = current.getLeft();
         else
            current = current.getRight();
      }
        
      if(v < parent.getInfo())
         parent.setLeft(newNode);
      else
         parent.setRight(newNode);
        
      m_size++;
   }
    
    // print the tree content using in-order traveral
   public void inOrder()
   {   
      if(m_root == null)  //if tree is empty
         return; //return
       
      Deque<BSTNode> stack = new ArrayDeque<BSTNode>();  //set up BSTNode stack
      BSTNode current = m_root; //Set up a current node and initalize it to the root
      
      while(true) //While(true)
      {  
         if(current != null) //if current node is not null
         {   
            stack.push(current); //push current node onto stack
            current = current.getLeft(); //set current node to its left child
         }
         else
         {
            current = stack.peek(); //set current node to the top of the stack;
            
            if(current == null) 
               break;
            
            stack.pop(); //pop the stack
            System.out.print(current.getInfo() + " "); //print the value of the current node
            current = current.getRight();  //set current node to its right child
         } 
          
      }  //end while
   }
    
    // get the size of the tree
   public int size()
   {
      return m_size;
   }
    
    // empty the tree
   public void clear()
   {
      m_root = null;
      m_size = 0;
   }
    
}
