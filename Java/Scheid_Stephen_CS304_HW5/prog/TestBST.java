// The test driver for the BST class
// Do not make any changes to this file!
// Xiwei Wang

import java.util.Scanner;

public class TestBST 
{
   public static void main(String[] args)
   {
      BST myTree = new BST();
      
      System.out.println("Test 1: ");
      
      // insert values
      myTree.add(10);
      myTree.add(20);
      myTree.add(3);
      myTree.add(5);
      myTree.add(15);
      myTree.add(17);
      myTree.add(30);
      myTree.add(25);
      myTree.add(40);
      myTree.add(20);
      myTree.add(33);
      
      System.out.println("The tree should have 10 nodes and your tree has " 
                         + myTree.size() + " nodes.");
      System.out.print("The in-order traversal of the tree should print the "
                         + "following sequence: 3 5 10 15 17 20 25 30 33 40.\n"
                         + "Your tree prints the following sequence: ");
      myTree.inOrder();
      
      System.out.println("\nTest 2: ");
      
      // clear the tree
      myTree.clear();
      
      // insert values
      myTree.add(10);
      myTree.add(20);
      myTree.add(30);
      myTree.add(40);
      myTree.add(50);
      myTree.add(60);
      myTree.add(70);
      myTree.add(80);
      myTree.add(90);
      myTree.add(90);
      
      System.out.println("The tree should have 9 nodes and your tree has " 
                         + myTree.size() + " nodes.");
      System.out.print("The in-order traversal of the tree should print the "
                         + "following sequence: 10 20 30 40 50 60 70 80 90.\n"
                         + "Your tree prints the following sequence: ");
      myTree.inOrder();     
      
      
      System.out.println("\nTest 3: ");
      
      // clear the tree
      myTree.clear();
      
      // insert values
      myTree.add(50);
      myTree.add(40);
      myTree.add(30);
      myTree.add(20);
      myTree.add(10);
      
      System.out.println("The tree should have 5 nodes and your tree has " 
                         + myTree.size() + " nodes.");
      System.out.print("The in-order traversal of the tree should print the "
                         + "following sequence: 10 20 30 40 50.\n"
                         + "Your tree prints the following sequence: ");
      myTree.inOrder();  
   }
}
