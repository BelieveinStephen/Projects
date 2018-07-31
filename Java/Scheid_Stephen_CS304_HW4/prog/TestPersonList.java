// Test driver for the SortedPersonList class
// Do not make any changes to this file!
// Xiwei Wang

public class TestPersonList 
{
    public static void main(String[] args)
    {
        SortedPersonList myList = new SortedPersonList();      
        int numPassedTests = 0;
        int numTotalTests = 0;
        String testResult;
        
        // Test 1
        numTotalTests++;
        int iReturn = -1;
        testResult = "[Failed]";
        String eMsg = "N/A";
        try
        {
            iReturn = myList.size();
            
            if (iReturn == 0)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": size() ==> " + testResult + "\n Expected: 0" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 2
        numTotalTests++;
        boolean bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.add(1003, "Xiwei Wang");
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": add(1003, \"Xiwei Wang\") ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 3
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.isEmpty();
            
            if (bReturn == false)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": isEmpty() ==> " + testResult + "\n Expected: false" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 4
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.add(1005, "Neil Moore");
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": add(1005, \"Neil Moore\") ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 5
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.add(1001, "Peter Kimmel");
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": add(1001, \"Peter Kimmel\") ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n"); 
        
        // Test 6
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myList.size();
            
            if (iReturn == 3)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": size() ==> " + testResult + "\n Expected: 3" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");

        // Test 7
        numTotalTests++;
        String sReturn = "";
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            sReturn = myList.toString();
            
            if (sReturn.equals("[1001 | Peter Kimmel] [1003 | Xiwei Wang] [1005 | Neil Moore] "))
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": toString() ==> " + testResult + "\n Expected: [1001 | Peter Kimmel] [1003 | Xiwei Wang] [1005 | Neil Moore] " );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + sReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 8
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.contains(1001);
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": contains(1001) ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 9
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.contains(1002);
            
            if (bReturn == false)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": contains(1002) ==> " + testResult + "\n Expected: false" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n"); 
        
        // Test 10
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.contains(1003);
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": contains(1003) ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");          
        
        // Test 11
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.contains(1005);
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": contains(1005) ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 12
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.remove(1004);
            
            if (bReturn == false)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": remove(1004) ==> " + testResult + "\n Expected: false" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 13
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.remove(1001);
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": remove(1001) ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");   

        // Test 14
        numTotalTests++;
        sReturn = "";
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            sReturn = myList.toString();
            
            if (sReturn.equals("[1003 | Xiwei Wang] [1005 | Neil Moore] "))
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": toString() ==> " + testResult + "\n Expected: [1003 | Xiwei Wang] [1005 | Neil Moore] " );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + sReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 15
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.contains(1001);
            
            if (bReturn == false)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": contains(1001) ==> " + testResult + "\n Expected: false" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n"); 
        
        // Test 16
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.add(1002, "David Brown");
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": add(1002, \"David Brown\") ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");   
        
        // Test 17
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.add(1006, "Kung Fu Panda");
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": add(1006, \"Kung Fu Panda\") ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");

        // Test 18
        numTotalTests++;
        PersonNode pReturn = null;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            pReturn = myList.get(1005);
            
            if (pReturn.getName().equals("Neil Moore"))
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": get(1005).getName() ==> " + testResult + "\n Expected: \"Neil Moore\"" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: \"" + pReturn.getName() + "\"\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 19
        numTotalTests++;
        pReturn = null;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            pReturn = myList.get(1002);
            
            if (pReturn.getName().equals("David Brown"))
            {
                pReturn.setName("Hassan Alomran");
                iReturn = myList.size();
                
                if (iReturn == 4)
                {
                    numPassedTests++;
                    testResult = "[Passed]";
                }
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": get(1002).setName(\"Hassan Alomran\") and then size() ==> " + testResult + "\n Expected: 4" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");        

        // Test 20
        numTotalTests++;
        sReturn = "";
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            sReturn = myList.toString();
            
            if (sReturn.equals("[1002 | Hassan Alomran] [1003 | Xiwei Wang] [1005 | Neil Moore] [1006 | Kung Fu Panda] "))
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": toString() ==> " + testResult + "\n Expected: [1002 | Hassan Alomran] [1003 | Xiwei Wang] [1005 | Neil Moore] [1006 | Kung Fu Panda] " );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + sReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 21
        numTotalTests++;
        pReturn = null;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            pReturn = myList.get(1008);
            
            if (pReturn == null)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": get(1008) ==> " + testResult + "\n Expected: null" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + pReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");

        // Test 22
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.add(1005, "Xiwei Wang");
            
            if (bReturn == false)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": add(1005, \"Xiwei Wang\") ==> " + testResult + "\n Expected: false" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n"); 
        
        // Test 23
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            myList.remove(1002);
            myList.remove(1003);
            myList.remove(1005);
            myList.remove(1006);
            
            bReturn = myList.isEmpty();
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": remove({1002, 1003, 1005, 1006}) and then isEmpty() ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 24
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myList.size();
            
            if (iReturn == 0)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": size() ==> " + testResult + "\n Expected: 0" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 25
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.add(1006, "Erich Smith");
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": add(1006, \"Erich Smith\") ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 26
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.add(1003, "Damon Caskey");
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": add(1003, \"Damon Caskey\") ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");  
        
        // Test 27
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.add(1004, "Jeremy Wells");
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": add(1004, \"Jeremy Wells\") ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 28
        numTotalTests++;
        sReturn = "";
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            sReturn = myList.toString();
            
            if (sReturn.equals("[1003 | Damon Caskey] [1004 | Jeremy Wells] [1006 | Erich Smith] "))
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": toString() ==> " + testResult + "\n Expected: [1003 | Damon Caskey] [1004 | Jeremy Wells] [1006 | Erich Smith] " );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + sReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 29
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.contains(1004);
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": contains(1004) ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");          
        
        // Test 30
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.contains(1005);
            
            if (bReturn == false)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": contains(1005) ==> " + testResult + "\n Expected: false" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");

        // Test 31
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.remove(1002);
            
            if (bReturn == false)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": remove(1002) ==> " + testResult + "\n Expected: false" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n"); 
        
        // Test 32
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            bReturn = myList.remove(1003);
            
            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": remove(1003) ==> " + testResult + "\n Expected: true" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");         
        
        // Test 33
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myList.size();
            
            if (iReturn == 2)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": size() ==> " + testResult + "\n Expected: 2" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        System.out.println("Total test cases: " + numTotalTests + "\nCorrect: " + numPassedTests + "\nWrong: " + (numTotalTests - numPassedTests));        
    }    
}
