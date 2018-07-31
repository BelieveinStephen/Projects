import java.util.Arrays;

public class HWSorts
{
   static int[] sizes = {20, 100, 500, 1000, 2000, 5000, 10000, 20000, 40000, 65000, 100000, 120000, 130000, 140000, 200000, 500000, 1000000};  
   public static void main(String[] args)
   {
      int sIdx = 0;
      long startTime;
      long endTime;
      double time;
      while( sIdx < sizes.length ) 
      {
         int[] A = new int[sizes[sIdx]];
         int[] B = new int[sizes[sIdx]];  
         int[] C = new int[sizes[sIdx]]; 
         int[] D = new int[sizes[sIdx]]; 
         int[] E = new int[sizes[sIdx]]; 
         for( int i=0; i<A.length; i++ ) 
         {
            A[i] = (int)(Math.random()*sizes[sIdx]*2);
            B[i] = A[i];
            C[i] = A[i];
            D[i] = A[i];
            E[i] = A[i];
         }
         //System.out.println( Arrays.toString(A) );
         System.out.println( "----------------\nSize = " + C.length);
         startTime = System.nanoTime();         
         C = mergeSort(C);         
         endTime = System.nanoTime();
         time = (endTime - startTime) / 1000000000.;
         System.out.println( "Merge sort finished - time = " + time  + " seconds.");
         System.out.println( "Starting bubble sort!" );
         //System.out.println( Arrays.toString(C) );
         startTime = System.nanoTime();
         bubbleSort(B);
         endTime = System.nanoTime();
         time = (endTime - startTime) / 1000000000.;
         System.out.println( "Bubble sort finished - time = " + time  + " seconds." );
         //System.out.println( Arrays.toString(B) );
         System.out.println( "Starting java's Array sort!" );
         //System.out.println( Arrays.toString(C) );
         startTime = System.nanoTime();
         D = javaSort(D);
         endTime = System.nanoTime();
         time = (endTime - startTime) / 1000000000.;
         System.out.println( "Java's Array sort finished - time = " + time  + " seconds." );
         System.out.println( "Starting QuickSort!" );
         //System.out.println( Arrays.toString(C) );
         startTime = System.nanoTime();
         E = quickSort(E);
         endTime = System.nanoTime();
         time = (endTime - startTime) / 1000000000.;
         System.out.println( "QuickSort finished - time = " + time  + " seconds." );
         sIdx = sIdx + 1;   
      }
   }  
   
   public static void bubbleSort(int[] A)
   {
      for(int i = 0; i < A.length; i++)
      {
         for(int j = 1; j <A.length - i; j++)
         {
            if(A[j] < A[j-1])
            {
               int t = A[j];
               A[j] = A[j-1];
               A[j-1] = t;
               /*swap*/
            }
         }      
      }
   }
   
   public static int[] mergeSort(int[] X)
 {
      if(A.length <= 1)
         return A;
      else
      {
         
         int[] L = new int[A.length/2];
         int[] R = new int[A.length-L.length];
         for(int i=0; i<A.length; i++)
         {
            if(i<L.length)
               L[i] = A[i];
            else
               R[i - L.length] = A[i];
         }
         L = mergeSort(L);
         R = mergeSort(R);
         A = merge(L, R);
         return A;
      }
   }

   private static int[] merge(int[] A, int[] B)
   {
      int[] R = new int[A.length + B.length];
      
      int Bindex = 0;
      int Aindex = 0;
      int Rindex = 0;
      
      /*Sorting the Arrays*/
      while(Aindex < A.length && Bindex < B.length)
      {
         if(A[Aindex]>B[Bindex])
         {
            R[Aindex+Bindex] = B[Bindex];
            Aindex++;
            Rindex++;
         }
         else
         {
            R[Aindex+Bindex] = A[Aindex];
            Bindex++;
            Rindex++;
         }
      }
     
     /* When there are leftovers in the arrays after sort */ 
      while(Aindex < A.length)
      {
         R[Rindex] = A[Aindex];
         Rindex++;
         Aindex++;
      }
      while(Bindex < B.length)
      {
         R[Rindex] = B[Bindex];
         Rindex++;
         Bindex++;
      }
   return R;
   }
   public static int[] javaSort(int[] X)
   {
      return arrays.sort(X);
      
   }
   public static int[] quickSort(int[] X)
   {
      //quicksort doesn't create a new array
      //  so we need additional params for our 
      //  recursive method
      return quickSort(X, 0, X.length-1);   
   }
   
   public static int[] quickSort(int[] X, int s, int e)
   {
      if((s>=e) || (e<=s))
         return;
      else
      {
      int pivot = X[s];
      int i = s +1;
      int tmp;
      
      for(int j = s+1; j<e; j++)
      {
         if(pivot > a[j])
         {
            tmp=a[j];
            a[j]=a[i];
            a[i]=tmp;
            i++;
         }
      }
   
   a[s] = a[i-1];
   a[i-1] = pivot;
   quickSort(X, s, i-2);
   quickSort(X, i, e);
   
      }   
   }
   
}