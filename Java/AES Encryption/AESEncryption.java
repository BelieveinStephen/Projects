import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.util.*;

public class AESEncryption
{
   public static void main(String[] args)//main method
   {
      boolean e = false;
      
      while(!e)
      {
         System.out.print("Enter E for encryption or D for decryption: ");
         Scanner kb = new Scanner(System.in);
         String f = kb.next();
         if (f.charAt(0) == 'E')
         {
            encrypt();
            e = true;
         }
         else if (f.charAt(0) == 'D')
         {
            decrypt();
            e = true;
         }

      }   
   }
   
   public static void encrypt() //method that returns void and does not take any parameter
   {
      try
      {
         Scanner kb = new Scanner(System.in);
         KeyGenerator keyGen = KeyGenerator.getInstance("AES"); 
         keyGen.init(128);
         SecretKey key = keyGen.generateKey();
         Cipher cipher = Cipher.getInstance("AES");
         cipher.init(Cipher.ENCRYPT_MODE, key);
         
         System.out.print("Enter the filename you wish to encrypt: ");
         String fn = kb.next();
         
         File f = new File(fn);
         FileInputStream in = new FileInputStream(f);
         
         
         byte[] size = new byte[(int)f.length()]; 
         
         in.read(size);//c5
         in.close();
         
         byte[] end = cipher.doFinal(size); //c6
         
         File e = new File("encrypted.txt");
         
         
         FileOutputStream out = new FileOutputStream(e);
         out.write(end); //d1
         out.close();
         
         
         byte[] keyBytes = key.getEncoded();
         File k = new File("key.txt");
         FileOutputStream x = new FileOutputStream(k);
         x.write(keyBytes);
         x.close();
         
         
      }
      catch (NullPointerException e)
      {
         e.printStackTrace();
      }
      catch(FileNotFoundException e)
      {
         e.printStackTrace();
      }
      catch(GeneralSecurityException e)
      {
         e.printStackTrace();
      } 
      catch(IOException e)
      {
         e.printStackTrace();
      }
      catch(IllegalStateException e)
      {
         e.printStackTrace();
      }
      catch(InvalidParameterException e)
      {
         e.printStackTrace();
      }
      catch(UnsupportedOperationException e)
      {
         e.printStackTrace();
      }
      catch(SecurityException e)
      {
         e.printStackTrace();
      }
   }
   
   
   
    
   public static void decrypt() //method that returns void and does not take any parameter
   {
      try
      {
         Scanner kb = new Scanner(System.in);
         System.out.print("Enter the file you wish to decrypt: ");
         String fn = kb.next();
         File f = new File(fn);
         FileInputStream in = new FileInputStream(f);
         byte[] fileBytes = new byte[(int)f.length()]; 
         
         kb.nextLine();
         
         System.out.print("Enter the name of the special key file: ");
         String keyN = kb.next();
         in.read(fileBytes);//c5
         in.close();
         
         File f1 = new File(keyN);
         FileInputStream in2 = new FileInputStream(f1);
         byte[] keyBytes = new byte[(int)f1.length()];
         
         in2.read(keyBytes); //d1
         in2.close();
                           
         
         SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
         
         Cipher cipher = Cipher.getInstance("AES");
         cipher.init(Cipher.DECRYPT_MODE, key);
         
         byte[] decrypted = cipher.doFinal(fileBytes);
         File d = new File("decrypted.txt");
         FileOutputStream x = new FileOutputStream(d);
         x.write(decrypted);
         x.close();

      }
      catch(FileNotFoundException e)
      {
         e.printStackTrace();
      }
      catch(GeneralSecurityException e)
      {
         e.printStackTrace();
      } 
      catch(IOException e)
      {
         e.printStackTrace();
      }
      catch(IllegalStateException e)
      {
         e.printStackTrace();
      }
      catch(InvalidParameterException e)
      {
         e.printStackTrace();
      }
      catch(UnsupportedOperationException e)
      {
         e.printStackTrace();
      }
      catch(SecurityException e)
      {
         e.printStackTrace();
      }
   }

}
