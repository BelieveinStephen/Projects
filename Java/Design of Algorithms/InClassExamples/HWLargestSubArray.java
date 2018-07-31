import java.util.Arrays;
public class HWLargestSubArray
{
   static int start = 0;
   static int end = 0;
   /* for practice use this array */
   static int[] sizes = {10};
   //static int[] sizes = {20, 100, 500, 1000, 2000, 5000, 10000, 20000, 40000, 65000, 100000, 120000, 130000, 140000, 200000, 500000, 1000000};  
   public static void main(String[] args)
   {
      long startTime, endTime;
      for( int sz=0; sz<sizes.length; sz++ )
      {
         int[] A = new int[sizes[sz]];
         /* 
            largest value is equal to the size of the array.
            can we overflow?  maybe.
         */
         for( int i=0; i<A.length; i++ ) 
         {
            A[i] = A.length - (int)(Math.random()*A.length*2);
         }
         System.out.println( "--------------------\nSize of array = " + A.length );
         if( A.length <= 1000 )
            System.out.println( Arrays.toString(A));
         
         System.out.println( "n^2" );
         startTime = System.nanoTime();
         int result = lsa(A);
         endTime = System.nanoTime();
         System.out.println( "largest sub array sum = " + result + ", time = " + (endTime - startTime)/1000000000. );   
         System.out.println( "n*log2(n)" );
         startTime = System.nanoTime();
         result = lsaRec(A, 0, A.length-1);
         endTime = System.nanoTime();
         System.out.println( "largest sub array sum = " + result + ", time = " + (endTime - startTime)/1000000000. );   
         System.out.println( "start = " + start + ", end = " + end );   
      }
   }
   public static int lsa(int[] A)
   {
      /*  our n^2 solution used a nested for-loop.
          the outer loop is the starting element
          the inner loop checks all remaining elements from the 
          starting element until the end of the array.  
          every new sum (every iteration of inner loop) is checked 
          against a maximum value and replaces it if greater 
          then return maximum value;
      */
      return 0;
   }
   public static int lsaRec( int[] A, int s, int e )
   {
      /* stopping condition:  only one element to check, return it */
      if( s==e ) return A[s]; 
      /* otherwise, the largest sum is in the left half (s -> mid),
         the right half (mid+1 -> end) *OR* in a segment that crosses
         the middle.
         this segment will have a portion in the left half and a 
         portion in the right half.  The two portions added together 
         will be the largest sum.  
         To calculate this middle portion, find largest sum from 
         mid -> s, the largest sum from mid+1 -> e and add together.
         this is a linear process - no recursion.
         return the maximum of the three values you found 
      */
      int mid = (s + e) / 2;
      return A[mid];  //no...
   }
}