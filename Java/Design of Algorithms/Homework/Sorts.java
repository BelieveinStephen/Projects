import java.util.Arrays;

/*Bubble Sort*/
public class Sorts
{

   public static void main(String[] args)
   {
      int s = 100;
      int[] A = new int[s];
      int[] B = new int[s];
      int[] C = new int[s];
      
      /*adding random elements to an array*/
      for(int i = 0; i <A.length; i++)
      {
         A[i] = (int)(Math.random()* s * 2);
         B[i] = A[i];
      }
      
            
      while (s <=2000)
      {
         A[i] = A[i];
         B[i] = A[i];
         C[i] = A[i];
      }
      
      C = mergeSort(C);
      System.out.println(Arrays.toString(C));
      System.out.println("Merge sort finished");
      
      System.out.println("bubbleSort Started");
      System.out.println(Arrays.toString(A));
      bubbleSort(B);
      System.out.println(Arrays.toString(B));
      
      System.out.println("Bubble sort finished");
      
          
      s = s*10;
      
      
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
   
   public static int[] mergeSort(int[] A)
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
      
   public static int[] merge(int[] A, int[] B)
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
}