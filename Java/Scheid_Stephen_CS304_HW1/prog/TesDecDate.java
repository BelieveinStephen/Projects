// Test driver for the DecDate class
// Do not make any changes to this file!
// Xiwei Wang

import java.util.*;
import java.io.*;

public class TesDecDate
{
    public static void main(String[] args)
    {        
        try
        {    
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("testDates.dat"));
            ArrayList<Date> oldDates;
            ArrayList<Date> newDates;
            oldDates = (ArrayList<Date>)in.readObject();
            newDates = (ArrayList<Date>)in.readObject();
            
            DecDate myDate;
            int numCorrect = 0;
            
            for (int i = 0; i < oldDates.size(); i++)
            {
                System.out.println("The current date is " + oldDates.get(i));
                myDate = new DecDate(oldDates.get(i));
                myDate.decrement();
                System.out.println("The correct previous day is " + newDates.get(i) + " and the one calculated by your program is " + myDate + ".");
                
                if (myDate.toString().equals(newDates.get(i).toString()))
                {
                    System.out.println("Correct!\n");
                    numCorrect++;
                }
                else
                    System.out.println("Wrong!\n");
            }
            
            System.out.println("Total test cases: " + oldDates.size() + "\nCorrect: " + numCorrect + "\nWrong: " + (oldDates.size() - numCorrect));
        }
        catch (Exception e)
        {
           System.out.println("Error occurred: " + e.getMessage());   
        }
    }
}
		
