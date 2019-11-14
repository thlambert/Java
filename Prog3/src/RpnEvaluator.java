/**
* This class handles the operators, getting the result of all the expressions, 
* and adding TVectors to the stack.
* 
* This class handles determining what each operator does, determining what 
* the final value is after all the expressions, and handles adding and removing
* TVectors from the stack.
* 
* @author lambertth
*/

public class RpnEvaluator 
{
    private final int N = 5;
    Stack s = new Stack(N);
    TVector result;
    
    public String[] split(String line)
    {
       String toks[];
       toks = line.split(" ");
       String temp[] = new String[toks.length];
       int j = 0;
       for(int i = 0; i < toks.length; i++)
       {
           if(toks[i].equals(""))
           {
               temp[j++] = toks[i];
           }
           else
           {
                char c = toks[i].charAt(0);
                if(c == '+' || c == '-' || c == '*')
                {
                temp[j++] = toks[i];
                }
                else if(c == '(')
                {
                    temp[j++] = toks[i];
                }
                else
                {
                    temp[j++] = toks[i];
                    i = toks.length;
                    for(int z = j; z < toks.length; z++)
                    {
                        temp[z] = "";
                    }
                }
           }
       }
       return temp;
    }

    /**
    * Gets a line of expressions and splits it into tokens. Then it determines 
    * if each token is an operator, a TVector or an invalid token.
    * @param st String with all the expressions
    * @return true is the expression is valid, false if the expression 
    * is invalid
    */
    public boolean firstcheck(String st)
    {
        String toks[] = st.split(" ");
        for(int i = 0; i < toks.length; i++)
        {
            if(!toks[i].equals(""))
            {
                char c = toks[i].charAt(0);
                if(c == '(')
                {
                   s.push(operand(toks[i]));
                }
                else if(c == '+' || c == '-' || c == '*')
                {
                    if(!operator(toks[i]))
                    {
                        return false;
                    }
                }
                else
                    return false;
            }
        }
        if(!lastexp())
        {
            return false;
        }
        result = (TVector) s.pop();
        return true;
    }
    /**
    * Handles the Expressions. Gets a string which is a set of four 
    * numbers in a format like this (1,2,3,4). Removes the commas and 
    * parenthesis from the string and then creates a TVector with the four 
    * numbers.
    * @param st String of Expression EX. (1,2,3,4)
    * @return TVector created from the four numbers
    */
    public TVector operand(String st)
    {
        String num[] = st.split(",");
        String num1[], num4[];
        
        num1 = num[0].split("\\("); //Removes the ( from the numbers
        num4 = num[3].split("\\)");
        
        int number1 = Integer.parseInt(num1[1]);
        int number2 = Integer.parseInt(num[1]);
        int number3 = Integer.parseInt(num[2]);
        int number4 = Integer.parseInt(num4[0]);
        
        TVector temp = new TVector(number1, number2, number3, number4);
        return temp;
        
        
    }
    /**
    * Handles the operators. It tries popping two TVectors and then adding, 
    * subtracting or multiplying based upon the operator. If it throws an 
    * Exception, there weren't two operands in the stack.
    * @param st Operator to use
    * @return true is it added subtracted or multiplied successfully, false
    * is there weren't two TVectors in the stack.
    */
    public boolean operator(String st)
    {
        try
        {
            TVector v1 = (TVector) s.pop();
            TVector v2 = (TVector) s.pop();
            if(st.equals("+"))
            {
               s.push(v1.plus(v2));
            }
            else if(st.equals("-"))
            {
               s.push(v1.minus(v2));
            }
            else
            {
                s.push(v1.times(v2));
            }
            return true;
        }
        catch(Exception ex)
        {
            //There weren't two vectors
            return false;
        }
    }
    /**
    * Checks to see if there is one and only one TVector left in the stack
    * @return true if there is only one TVector, false if there is none or more 
    * than one
    */
    public boolean lastexp()
    {
        if(s.isEmpty())
        {
            return false;
        }
        TVector temp = (TVector) s.pop();
        if(!s.isEmpty())
        {
            return false;
        }
        s.push(temp);
        return true;
    }
    /**
    * Gets the final answer after all the operators are done
    * Only used if it is a Valid Expression
    * @return 
    */
    public TVector result()
    {
        return result;
    }
}
