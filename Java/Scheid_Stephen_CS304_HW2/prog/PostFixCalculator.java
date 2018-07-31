// The PostFixCalculator class that implements a postfix expression calculator
// Your name here

import java.util.Scanner;

public class PostFixCalculator 
{
    // instance variable
    String m_postfix;
    
    // constructor
    public PostFixCalculator()
    {
        m_postfix = "";
    }
    
    // mutator
    public void setPostfix(String postfix)
    {
        m_postfix = postfix;
    }
    
    // evaluate the postfix expression saved in m_postfix
    public int calculate()
    {
        Scanner tokenizer; 
        int result = -1; // This is only an initial value. You will need to update it to the correct value.
        int operand1, operand2, value;
        String operator;
        NumberStack myStack = new ArrayNumberStack(100); 
        tokenizer = new Scanner(m_postfix);
        
        while(tokenizer.hasNext())
        {
            if(tokenizer.hasNextInt())
            {
               //process operand
               value = tokenizer.nextInt();  
               if(myStack.isFull())
                  throw new RuntimeException("Too many operands");            
               myStack.push(value);
            }
            else
            {
               //process operator               
               operator = tokenizer.next();
                               
                //Obtain the second operand
                if(myStack.isEmpty())
                  throw new RuntimeException("Not enough operands");
                operand2 = myStack.top();
                myStack.pop();
                
                //Obtain the first operand from stack
                if(myStack.isEmpty())
                  throw new RuntimeException("Not enough operands");
                operand1 = myStack.top();
                myStack.pop();
              
               //perform operation
                if(operator.equals("/"))
                  result = operand1 / operand2;
                else
                if(operator.equals("*"))
                  result = operand1 * operand2;
                else
                if(operator.equals("+"))
                   result = operand1 + operand2;
                else
                if(operator.equals("-"))
                   result = operand1 - operand2;
                
                //check for illegal symbols
                if(!(operator.equals("+") || operator.equals("/") || operator.equals("-") || operator.equals("*")))
                  throw new RuntimeException("Unrecognized operator: " + operator);
                
                //push result of operation onto stack
                  myStack.push(result);
              } 
        }
                  //throw new RuntimeException("Unrecognized operator");
               //myStack.push(value);
              
        //obtain final result 
        if(myStack.isEmpty())
          throw new RuntimeException("Not enough operands");
        result = myStack.top();
        myStack.pop();
         
         //stack should now be empty
         if(!myStack.isEmpty())
            throw new RuntimeException("Too many operands");      
               
        
         return result;

    }    
}
