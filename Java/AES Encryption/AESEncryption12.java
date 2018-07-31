import javax.crypto.*;
import java.security.*;
import java.io.*;
import javax.crypto.spec.*;
import java.util.*;

public class AESEncryption12
{
   public static void main(String[] args)
   {
      boolean validInput = false;
      
      while (!validInput)
      {
         System.out.print("Enter E for encryption or D for decryption: ");
         Scanner kb = new Scanner(System.in);
         String s = kb.next();
         
         if (s.charAt(0) == 'E')
         {
            encrypt();
            validInput = true;
         }
         else if (s.charAt(0) == 'D')
         {
            decrypt();
            validInput = true;
         }
      }
   }
   
   public static void encrypt()
   {
      try   
      {   
         KeyGenerator keyGen = KeyGenerator.getInstance("AES");
         keyGen.init(128);
         SecretKey key = keyGen.generateKey();
         
         Cipher c = Cipher.getInstance("AES");
         c.init(Cipher.ENCRYPT_MODE, key);
         
         System.out.print("Enter the complete filename of the file to encrypt: ");
         Scanner kb = new Scanner(System.in);
         String filename = kb.next();
         
         File f = new File(filename);
         FileInputStream in = new FileInputStream(f);
         
         int length = (int) f.length();
         byte[] fileBytes = new byte[length];
         
         in.read(fileBytes);
         in.close();
         
         byte[] encrypted = c.doFinal(fileBytes);
         
         File f1 = new File("encrypted.txt");
         FileOutputStream out1 = new FileOutputStream(f1);
         out1.write(encrypted);
         out1.close();
         
         byte[] keyBytes = key.getEncoded();
         
         File f2 = new File("key.txt");
         FileOutputStream out2 = new FileOutputStream(f2);
         out2.write(keyBytes);
         out2.close();
         
      }
      catch (NullPointerException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (GeneralSecurityException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (InvalidParameterException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (UnsupportedOperationException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (FileNotFoundException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (SecurityException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (IOException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (IllegalStateException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
   }
   
   public static void decrypt()
   {
      try   
      {            
         System.out.print("Enter the complete filename of the file to decrypt: ");
         Scanner kb = new Scanner(System.in);
         String filename = kb.next();
         kb.nextLine();
         
         System.out.print("Enter the complete filename of the key file: ");
         String keyFile = kb.next();
         
         File f = new File(filename);
         FileInputStream in = new FileInputStream(f);
         
         int length = (int) f.length();
         byte[] fileBytes = new byte[length];
         
         in.read(fileBytes);
         in.close();
         
         File f1 = new File(keyFile);
         FileInputStream in1 = new FileInputStream(f1);
         
         int keyLength = (int) f1.length();
         byte[] keyBytes = new byte[keyLength];
         
         in1.read(keyBytes);
         in1.close();
         
         SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
         
         Cipher c = Cipher.getInstance("AES");
         c.init(Cipher.DECRYPT_MODE, key);
         
         byte[] decrypted = c.doFinal(fileBytes);
         
         File f2 = new File("decrypted.txt");
         FileOutputStream out = new FileOutputStream(f2);
         out.write(decrypted);
         out.close();         
      }
      catch (NullPointerException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (FileNotFoundException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (SecurityException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (IOException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (IllegalArgumentException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (GeneralSecurityException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (UnsupportedOperationException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
      catch (IllegalStateException e)
      {
         System.out.println("ERROR: " + e.toString());
      }
   }
}