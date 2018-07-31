 // The SortingAlgs class that implements selection sort and merge sort
// Stevie Scheid

public class SortingAlgs 
{
    // card comparison
    public int compares(Card c1, Card c2)
    {
               
        if(c1.getSuit() < c2.getSuit())
            return -1;
        else if(c1.getSuit() > c2.getSuit())
            return 1;
        else
        {
            if(c1.getRank() < c2.getRank())
               return -1;
            else if(c1.getRank() > c2.getRank())
               return 1;
             else 
               return 0;
        }
    }
    
    // selection sort
    public void selectionSort(Card[] cardArray)
    {
        int last = cardArray.length - 1;
        
        for (int i = 0; i < last; i++)
        {
            int indMin = minIndex(cardArray, i, last);
            Card temp = cardArray[i];
            cardArray[i] = cardArray[indMin];
            cardArray[indMin] = temp;
        }
    }

    
    
    // find the index of the smallest element in the specified range
    public int minIndex(Card[] cardArray, int startIndex, int endIndex)
    {
        int indMin = startIndex;
        
        for(int i = startIndex + 1; i <= endIndex; i++)
            if (compares(cardArray[i], cardArray[indMin]) == -1)
                indMin = i;
            
            return indMin;
    }    

    // merge sort
    public void mergeSort(Card[] cardArray)
    {
        mergeSortRec(cardArray, 0, cardArray.length - 1);
    } 
    
    // recursive helper recursive method for mergeSort
    public void mergeSortRec(Card[] cardArray, int startIndex, int endIndex)
    {
        if (startIndex < endIndex)
        {
            int midIndex = (startIndex + endIndex) / 2;
            mergeSortRec(cardArray, startIndex, midIndex);
            mergeSortRec(cardArray, midIndex + 1, endIndex);
            merge(cardArray, startIndex, endIndex);
        }
    } 
    
    // merge two sorted halves into one sorted array
    public void merge(Card[] cardArray, int startIndex, int endIndex)
    {        
        int mid = (startIndex + endIndex) / 2;
        int n = endIndex - startIndex + 1;
        Card[] tempArray = new Card[n];
        
        int i1 = startIndex;
        int i2 = mid + 1;
        int j = 0;
        
        while(i1 <= mid && i2 <= endIndex)
        {
            if(compares(cardArray[i1], cardArray[i2]) == -1) 
             {
               tempArray[j] = cardArray[i1];
               i1++;
            }
            else
            {
               tempArray[j] = cardArray[i2];
               i2++;
            }
            j++;
        }
         
         while (i1 <= mid)
        {
            tempArray[j] = cardArray[i1];
            i1++;
            j++;
        }
        
        // copy the remaining elements of the second half into the temp array
        while (i2 <= endIndex)
        {
            tempArray[j] = cardArray[i2];
            i2++;
            j++;
        }     
        for(j=0; j < n; j++)
            cardArray[startIndex+j] =tempArray[j];
        
         
    }  
}
