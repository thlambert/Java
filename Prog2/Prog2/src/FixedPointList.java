import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * This class maintains a list of FixedPoint numbers.
 * 
 * This class handles adding to the list, deleting from the list, 
 * getting the min, getting the max and printing from the list.
 * 
 * @author lambertth
 */
public class FixedPointList 
{
    private int num = 0;
    private final int  INITIAL_SIZE = 3;
    private final int GROW_SIZE = 3;
    private FixedPoint listfp[] = new FixedPoint[INITIAL_SIZE];
    private final int large = 999999999;
    private final int small = -999999999;
    
    /**
     * Adds the FixedPoint provided to the list if the list isn't full.
     * If the list is full, it grows the list first and then adds the 
     * FixedPoint number to the list. It also increments num which is 
     * how many numbers are in the list.
     * @param p (FixedPoint to add to the list)
     */
    public void add(FixedPoint p)
    {
        if(num < listfp.length)
        {
            listfp[num++] = p;
        }
        else
        {
            FixedPoint temp[] = new FixedPoint[listfp.length + GROW_SIZE];
            System.arraycopy(listfp, 0, temp, 0, num);
            listfp = temp;
            listfp[num++] = p;
        }
    }
    /**
     * Finds the number in the list. If it finds the number, 
     * it deletes the number from the list.
     * If it can't find the number in the list, returns false.
     * @param p
     * @return true if the number was deleted
     *         false if the number wasn't in the list
     */
    public boolean delete(FixedPoint p)
    {
        int temp = -1;
        for(int i = 0; i < num; i++)
        {
            if(listfp[i].equals(p))
            {
                temp = i;
            }
        }
        if(temp > -1)
        {
            num--;
            for(int i = temp; i < num; i++)
            {
                listfp[i] = listfp[i + 1];
            }
            
            return true;
        }
        return false;
    }
    /**
     * Finds the smallest number in the list.
     * Returns Null is the list is empty.
     * @return FixedPoint(the smallest number in the list)
     *         Null(if the list is empty)
     */
    public FixedPoint min()
    {
        if(num > 0)
        {
            FixedPoint temp = new FixedPoint(large, 0);
            for(int i = 0; i < num; i++)
            {
                if(listfp[i].lessThan(temp))
                {
                    temp = listfp[i];
                }
            }
            return temp;
        }
        return null;
    }
    /**
     * Finds the largest number in the list.
     * Returns Null if the list is empty.
     * @return FixedPoint(the largest number in the list)
     *         Null(The list is empty)
     */
    public FixedPoint max()
    {
        if(num > 0)
        {
            FixedPoint temp = new FixedPoint(small, 0);
            for(int i = 0; i < num; i++)
            {
                if(temp.lessThan(listfp[i]))
                {
                    temp = listfp[i];
                }
            }
            return temp;
        }
        return null;
    }
    /**
     * Adds all the numbers in the list into a single FixedPoint number 
     * and then returns it.
     * @param q (the q value to convert all the numbers to)
     * @return FixedPoint (The sum of all the numbers.)
     *                    (Could also be 0.0 if the list is empty)
     */
    public FixedPoint sum(int q)
    {
        if(num > 0)
        {
            FixedPoint temp = new FixedPoint(0, q);
            for(int i = 0; i < num; i++)
            {
                temp = temp.plus(listfp[i], q);
            }
            return temp;
        }
        return new FixedPoint(0.0, q);
    }
    /**
     * Overrides the toString method from class Object. 
     * @return String of all the numbers in the list with a new line character
     * between each one.
     */
    @Override
    public String toString()
    {
        String temp = "";
        if(num > 0)
        {
            for(int i = 0; i < num; i++)
            {
                temp = temp + '\n' + listfp[i].toString(); //might need to fix
            }
        }
        return temp;
    }
    
/*
    public static void main( String args[]) throws IOException
    {
        Scanner stdin;
        
        Object obj1, obj2;
        FixedPoint p1, p2;
        FixedPointList theList = new FixedPointList();
        
        stdin = new Scanner(System.in);
        
        
        try
        {
            stdin = new Scanner ( new File("Lab6_1.in"));
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        
        
        obj1 = readFixedPointNumber(stdin);
        p1 = readFixedPointNumber(stdin);
        p2 = readFixedPointNumber(stdin);
        
        theList.delete(p1);
        
        verify(theList);
        
        theList.add((FixedPoint) obj1);
        theList.add(p1);
        theList.add(p2);
        
        verify(theList);
        
        obj1 = readFixedPointNumber(stdin);
        theList.add((FixedPoint) obj1); //19
        
        verify(theList);
        
        obj2 = readFixedPointNumber(stdin);
        
        theList.add((FixedPoint) obj2);
        
        verify(theList);
        
        theList.delete(p1);
        theList.delete((FixedPoint) obj2);
        theList.delete((FixedPoint) obj1);
        theList.delete((FixedPoint) obj2);
        
        verify(theList);
    }
    public static void verify(FixedPointList listIn)
    {
        System.out.print("All FixedPoint numbers in the list: ");
        System.out.println(listIn.toString());
        
        System.out.print("The sum of all numbers in th"
                + "e list with qVal 10: ");
        FixedPoint temp = listIn.sum(10);
        System.out.println(temp.toString());
        
        if(listIn.num > 0)
        {
            System.out.print("The smallest number in the list: ");
            FixedPoint temp1 = listIn.min();
            System.out.println(temp1.toString());
            
            temp1 = listIn.max();
            System.out.print("The largest number in the list: ");
            System.out.println(temp1.toString());
        }
    }
    public static FixedPoint readFixedPointNumber(Scanner jin)
    {
       String cmdLine;
       String toks[];
       cmdLine = jin.nextLine();
       
       toks = cmdLine.split(" ");
       double dbl = Double.parseDouble(toks[0]);
       int qval = Integer.parseInt(toks[1]);
       
       FixedPoint temp = new FixedPoint(dbl, qval);
       return temp;
    }
*/
}
