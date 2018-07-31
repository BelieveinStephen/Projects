// The RecursiveMethods class that implements several recursive solutions
// Your name here

public class RecursiveMethods 
{
    // This method calls the largestRec method and returns the largest.
    public int largest(int[] arr)
    {
        // Do not make any changes to this method!
        return largestRec(arr, 0);
    }
    
    // This method takes an integer array as well as an integer (the starting index) and returns the largest number in the array.
    public int largestRec(int[] arr, int pos)
    {
        if (pos == arr.length - 1)
        return arr[pos];
        else
        {
            int largest = largestRec(arr, pos + 1);
            if (arr[pos] > largest)
                return arr[pos];
            else
                return largest;
        }
    }
    
    // This method calls the sumRec method and returns the sum of the array.
    public int sum(int[] arr)
    {
        // Do not make any changes to this method!
        return sumRec(arr, 0);
    }    

    // This method takes an integer array as well as an integer (the starting index) and returns the sum of the values in the array.
    public int sumRec(int[] arr, int pos)
    {
        if (pos == arr.length - 1)
            return arr[pos];
        else
            return arr[pos] + sumRec(arr, pos + 1);
    }   

    // This method reads a string and returns the string in the reversed order.
    public String reverseStringRec(String s)
    {
        if (s.length() == 0)
            return s;
        else
        {
            char lastChar = s.charAt(s.length() - 1);
            String shorter = s.substring(0, s.length() - 1);

            return lastChar + reverseStringRec(shorter);
        }
    }
    
    // Bonus Question
    // This method takes a reference to the head of a linked list.
    // It returns the reference to the head of the linked list in the reversed order.
    public LNode reverseListRec(LNode head)
    {
        if (head == null || head.getLink() == null)
            return head;
        
        LNode revHead = reverseListRec(head.getLink());
        head.getLink().setLink(head);
        head.setLink(null);

        return revHead;
    }
}