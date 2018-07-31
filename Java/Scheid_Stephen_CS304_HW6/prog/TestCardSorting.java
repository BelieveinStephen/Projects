// Test driver for the SortingAlgs class
// Do not make any changes to this file!
// Xiwei Wang

import java.io.*;
import java.util.Arrays;

public class TestCardSorting
{	
    public static void main(String[] args)
    {        
        SortingAlgs mySort = new SortingAlgs();
       
        try
        {
            // read the decks from file
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Decks.dat"));
            Deck[] myDeck = new Deck[5];
            myDeck = (Deck[])in.readObject();

            for (int i = 0; i < 5; i++)
            {
                Card[] myCards = myDeck[i].getPartialDeck(myDeck[i].getnumCards());
                String before = Arrays.toString(myCards);
				
                System.out.println("Test " + (i + 1) + ":");  
                System.out.println("The cards before sorting are\n" + before);
                System.out.println("------------------------------------");
                
                Card[] testCards = myCards.clone();
                mySort.selectionSort(testCards);
                String after = Arrays.toString(testCards);

                System.out.println("The cards after Selection Sort are\n" + after);
                if (after.equals(myDeck[i].getSortedDeck()))
                    System.out.println("Your Selection Sort works correctly.\n");
                else
                    System.out.println("Something is wrong with your Selection Sort.\n");
                
                testCards = myCards.clone();
                mySort.mergeSort(testCards);
                after = Arrays.toString(testCards);

                System.out.println("The cards after Merge Sort are\n" + after); 
                if (after.equals(myDeck[i].getSortedDeck()))
                    System.out.println("Your Merge Sort works correctly.");
                else
                    System.out.println("Something is wrong with your Merge Sort.");  
                
                System.out.println("====================================\n");
            }
          
        }
        catch (Exception e)
        {
          System.out.println("Error occurred: " + e.getMessage());   
        }        
    }
}
