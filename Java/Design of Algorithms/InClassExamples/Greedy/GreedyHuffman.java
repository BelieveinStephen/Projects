import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Iterator;

class Vert implements Comparable<Vert>
{
   public Vert(){}
   public Vert(char c, int f)
   {
      ch = c;
      freq = f;
   }
   public int compareTo(Vert v)
   {
      return this.freq - v.freq;
   }
   public Vert left;
   public Vert right;
   
   Character ch;
   Integer freq;
   public String toString()
   {
      return "" + ch + ", " + freq;
   }
}


public class GreedyHuffman
{

   static Map<Character, String> paths;
   
   public static void main(String[] args)
   {
      String[] messages = {"hello", "TOBEORNOTTOBE"};
      for( int i=0; i<messages.length; i++ ) 
      {
         String orig = messages[i];
         String enc = huffmanEnc(orig);
         String dec = huffmanDec(enc);
         huffmanInfo(orig, enc, dec);
      }
   }
   
   public static void huffmanInfo(String orig, String enc, String dec)
   {
      System.out.println( "Original msg = " + orig );
      System.out.println( "Huffman coded = " + enc );
      System.out.println( "Huffman decoded = " + dec );
      System.out.println( "Number of bits in original msg = " + orig.length() * 8 );
      System.out.println( "Number of bits in Huffman code = " + enc.length() );
   }
   
   public static String huffmanDec(String enc)
   {
      String ret = "";
      String temp = "";
      for(int i = 0; i < enc.length(); i++)
      {
         if(getKeyFromValue(paths, temp) == null)
         {
            temp += enc.charAt(i);
         }
         else
         {
            ret += getKeyFromValue(paths, temp);
            temp = enc.charAt(i) + "";
         }
         if( i == enc.length() - 1)
            ret += getKeyFromValue(paths, temp);

      }  
      return ret;
   }
   /* we can assume a one to one relationship of keys and values */
   public static Character getKeyFromValue(Map<Character, String> map, String value) 
   {
      for (Map.Entry<Character, String> entry : map.entrySet()) 
      {
         if (value.equals(entry.getValue())) 
         {
            return entry.getKey();
         }
      }
      return null;
   }   
   public static String huffmanEnc(String msg)
   {
      String enc = "";
      /* record frequencies for each character */
      Map<Character, Integer> freq = new HashMap<Character, Integer>();
      for( int i=0; i<msg.length(); i++ ) 
      {
         char c = msg.charAt(i);
         if( freq.containsKey( c ) )
         {
            freq.put(c, freq.get(c)+1);
         }
         else
         {
            freq.put(c, 1);
         }
      }
      /* create vertice (tree) list.  Initially, one for each character */
      PriorityQueue<Vert> pq = new PriorityQueue<>();
      /* use an iterator to add each character to our vertice list */      
      Iterator it = freq.entrySet().iterator();
      while( it.hasNext() )
      {
         /* get character/count and store it as a vertice */
         Map.Entry pair = (Map.Entry)it.next();
         Vert v = new Vert((Character)pair.getKey(), (Integer)pair.getValue());
         pq.add(v);         
      }
      /* combine trees until only one left */
      while( pq.size() > 1 )
      {
         Vert v1 = pq.poll();      
         Vert v2 = pq.poll();
         Vert vNew = new Vert((char)0, v1.freq + v2.freq);
         vNew.left = v1;
         vNew.right = v2;
         pq.add(vNew);    
      }  

      /* create a dictionary of bit sequences (paths)
             for each character */
      paths = new HashMap<Character, String>();
      /* traverse our tree and store all the paths */      
      createPaths( pq.poll(), "", paths );
      
      /* let's code the msg */
      for( int i=0; i<msg.length(); i++ ) 
      {
         enc += paths.get(msg.charAt(i));
      }
      return enc;
   }   
   public static void createPaths(Vert v, String path, Map<Character, String> paths)
   {
      /* leaf is a stopping condition */
      if( v.left == null && v.right == null ) 
      {
         paths.put(v.ch, path);
         return;
      }
      createPaths(v.left, path + "0", paths);
      createPaths(v.right, path + "1", paths);
   }   
}