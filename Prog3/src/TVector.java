import java.io.*;
import java.util.Scanner;

/**
* This class handles creating, multiplying, adding, subtracting, comparing 
* and outputting TVectors. 
* 
* This class has the constructors to create TVectors. This class handles
* multiplying two TVectors together, adding two TVectors together, subtracting
* two TVectors from each other, checking if two TVectors are equal, and 
* outputting a string value for a TVector.
* 
* @author lambertth
*/

public class TVector 
{
    private final int N = 4;
    private long [] vect = new long[N];
    
    /**
    * Creates a TVector from a string
    * @param v String values to create from
    */
    public TVector(String v)
    {
        String tokens[];
        tokens = v.split("");
        for(int i = 0; i < 4; i++)
        {
            vect[i] = Integer.parseInt(tokens[i]);                    
        }
    }
    /**
    * Creates a blank TVector which doesn't have any values
    */
    public TVector()
    {
        
    }
    /**
    * Creates a TVector from 4 provided integers
    * @param num1 first number in TVector
    * @param num2 second number in TVector
    * @param num3 third number in TVector
    * @param num4 fourth number in TVector
    */
    public TVector(int num1, int num2, int num3, int num4)
    {
        vect[0] = num1;
        vect[1] = num2;
        vect[2] = num3;
        vect[3] = num4;
    }
    /**
    * Copies the numbers from the TVector provided and makes a copy
    * using the numbers
    * @param vectorin TVector to copy
    */
    public TVector(TVector vectorin)
    {
        System.arraycopy(vectorin.vect, 0, vect, 0, 3); // might change 3 to 4
    }
    /**
    * Adds this TVector to another TVector provided
    * Adds each number together corresponding to the position in the TVector
    * EX. first numbers in both TVectors get added together
    * @param vin TVector to add 
    * @return new TVector with values created from adding
    */
    public TVector plus(TVector vin)
    {
        TVector temp = new TVector();
        for(int i = 0; i < 4; i++)
        {
            temp.vect[i] = vin.vect[i] + vect[i];
        }
        return temp;
    }
    /**
    * Subtracts this TVector from a provided TVector
    * Subtracts each number corresponding to the position in the TVector
    * EX. first number in both TVectors are used to subtract
    * @param vin TVector to subtract
    * @return new TVector with new values made from subtracting
    */
    public TVector minus(TVector vin)
    {
        TVector temp = new TVector();
        for(int i = 0; i < 4; i++)
        {
            temp.vect[i] = vin.vect[i] - vect[i];
        }
        return temp;
    }
    /**
    * Multiplies this TVector to a TVector provided
    * Multiplies each number corresponding to the position in the TVector
    * EX. first number in both TVectors get multiplied together
    * @param vin TVector to multiply
    * @return new TVector with new values created from multiplying
    */
    public TVector times(TVector vin)
    {
        TVector temp = new TVector();
        for(int i = 0; i < 4; i++)
        {
            temp.vect[i] = vin.vect[i] * vect[i];
        }
        return temp;
    }
    /**
    * Creates a string with the values in the TVector
    * EX. (1,2,3,4)
    * @return String value of TVector
    */
    @Override
    public String toString()
    {
        String temp;
        temp = "(" + vect[0] + "," + vect[1] 
                +  "," + vect[2] + "," + vect[3] + ")";
        return temp;
    }
    /**
    * Checks if this TVector is equal to the object given
    * If the object isn't a TVector returns false
    * @param obj Object to compare to
    * @return true is they are equal, false is not instance of TVector or 
    * not equal numbers
    */
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof TVector)
        {
            boolean bool = true;
            for(int i = 0; i < 4; i++)
            {
                if(((TVector) obj).vect[i] != vect[i])
                {
                    bool = false;
                }
            }
            if(bool == true)
            {
                return true;
            }
        }
        return false;
    }
}
    /*
    public static void main(String args[])
    {
        System.out.println("Declar three variables "
                + "v1, v2 and v3 of class TVector.");
        TVector v1, v2, v3;
        
        System.out.println("Declare variable obj of class Object.");
        Object obj;
        
        
        System.out.println("Create a TVector with ("
                + "45,3,325,3) and assign it to v1.");
        v1 = new TVector(45,3,325,3);
        
        
        System.out.println("Create a TVector with "
                + "(-4,6,12,9) and assign it to v2.");
        v2 = new TVector(-4,6,12,9);
        
        System.out.println("Display v1 as string");
        System.out.println(v1.toString());
        System.out.println("Display v2 as string");
        System.out.println(v2.toString());
        
        System.out.println("Assign v1 to obj.");
        obj = v1;
        System.out.println("Copy v1 to v3.");
        v3 = v1;
        System.out.println("Display obj as string.");
        System.out.println(obj.toString());
        System.out.println("Display v3 as string.");
        System.out.println(v3.toString());
        
        if(obj == v1)
        {
            System.out.println("obj and v1 point to the same object");
        }
        else
        {
            System.out.println("obj and v1 point to different objects");
        }
        
        if(obj != v3)
        {
            System.out.println("obj and v3 point to the same object");
        }
        else
        {
            System.out.println("obj and v3 point to different objects");
        }
        
        if(obj.equals(v1))
        {
            System.out.println("obj equals v1");
        }
        else
        {
            System.out.println("obj does not equal v1");
        }
        
        if(obj.equals(v3))
        {
            System.out.println("obj equals v3");
        }
        else
        {
            System.out.println("obj does not equal v3");
        }
        
        
        
        System.out.println("Add v1 and v2 and assign the sum to obj");
        obj = v1.plus(v2);
        System.out.println("Display obj as string.");
        System.out.println(obj.toString());
        
        System.out.println("Subtract v2 from v1 and assign the "
                + "difference to v3.");
        v3 = v2.minus(v1);
        System.out.println("Display v3 as string.");
        System.out.println(v3.toString());
        
        System.out.println("Multiple v1 and v2 and assign the product to v3.");
        v3 = v1.times(v2);
        System.out.println("Display v3 as string.");
        System.out.println(v3.toString());
        
        System.out.println("Assign obj an object of Stack of size 3.");
        obj = new Stack(3);
        
        if(obj == v1)
        {
            System.out.println("obj and v1 point to the same object");
        }
        else
        {
            System.out.println("obj and v1 point to different objects");
        }
        
        if(obj.equals(v1))
        {
            System.out.println("obj equals v1");
        }
        else
        {
            System.out.println("obj does not equal v1");
        }
        
        
        System.out.println("Declare a variable myStack of "
                + "class Stack and assign stack obj to it");
        Stack myStack = new Stack(3);
        obj = myStack;
        
        if(myStack.isEmpty())
        {
            System.out.println("myStack is empty");
        }
        else
        {
         System.out.println("myStack is not empty");
        }
        
        if(myStack.isFull())
        {
            System.out.println("myStack is full");
        }
        else
        {
         System.out.println("myStack is not full");
        }
        
        System.out.println("Push v1 to myStack.");
        myStack.push(v1);
        System.out.println("Push v2 to myStack.");
        myStack.push(v2);
        System.out.println("Push v3 to myStack.");
        myStack.push(v3);
        
        if(myStack.isEmpty())
        {
            System.out.println("myStack is empty");
        }
        else
        {
         System.out.println("myStack is not empty");
        }
        
        if(myStack.isFull())
        {
            System.out.println("myStack is full");
        }
        else
        {
         System.out.println("myStack is not full");
        }
        
        System.out.println("Pop an object from myStack and assign it to obj");
        obj = myStack.pop();
        System.out.println("Add obj to v1");
        v1 = v1.plus((TVector)obj);
        System.out.println("push v1 into myStack");
        myStack.push(v1);
        
        System.out.println("Pop an object from myStack and assign it to v1");
        v1 = (TVector) myStack.pop();
        System.out.println("Pop an object from myStack and assign it to obj");
        obj = myStack.pop();
        
        System.out.println("Display v1 as string");
        System.out.println(v1.toString());
        System.out.println("Display obj as string");
        System.out.println(obj.toString());
        
        System.out.println("Assign the product of v1 and obj to v3");
        v3 = v1.times((TVector) obj);
        System.out.println("Assign the different of v1 and obj to v2");
        v2 = ((TVector) obj).minus(v1);
        System.out.println("Assign the sum of v1 and obj to v1");
        v1 = v1.plus((TVector) obj);
        
        System.out.println("Display v1 as string");
        System.out.println(v1.toString());
        System.out.println("Display v2 as string");
        System.out.println(v2.toString());
        System.out.println("Display v3 as string");
        System.out.println(v3.toString());
        
        System.out.println("Pop on object from myStack and assign it to obj");
        obj = myStack.pop();
        System.out.println("Display obj as string");
        System.out.println(obj.toString());
        
        System.out.println("Assign the product of v1 and obj to v3");
        v3 = v1.times((TVector) obj);
        System.out.println("Assign the different of v1 and obj to v2");
        v2 = ((TVector) obj).minus((v1));
        System.out.println("Assign the sum of v1 and obj to v1");
        v1 = v1.plus((TVector) obj);
        
        System.out.println("Display v1 as string");
        System.out.println(v1.toString());
        System.out.println("Display v2 as string");
        System.out.println(v2.toString());
        System.out.println("Display v3 as string");
        System.out.println(v3.toString());
        
        if(myStack.isEmpty())
        {
            System.out.println("myStack is empty");
        }
        else
        {
         System.out.println("myStack is not empty");
        }
        
        if(myStack.isFull())
        {
            System.out.println("myStack is full");
        }
        else
        {
         System.out.println("myStack is not full");
        }
    }
*/