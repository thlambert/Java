import java.util.Scanner;
import java.io.File;
import java.io.IOException;
/**
 * This class handles all the possible inputs which are A, D, P, Q, B, M and S.
 * 
 * The A command adds a FixedPoint to the list. The D command deletes a 
 * FixedPoint from the list. The P command prints the list. The Q command
 * changes the qVal of the FixedPoints that are added to the list. The B command
 * prints the largest FixedPoint. The M command prints the smallest FixedPoint.
 * The S command prints the sum of all the FixedPoint numbers in the list.
 * 
 * @author lambertth
 */
public class Prog2 
{
    
    private static int num = 12;
    private static Scanner sc = new Scanner (System.in);
    private static FixedPointList list = new FixedPointList();
    /**
     Creates a new FixedPoint number using the double provided and the current
     * qVal. It then adds the number to the list.
     * @param dbl (double for the FixedPoint number)
     */
    private static void add(double dbl)
    {
        FixedPoint temp = new FixedPoint(dbl, num);
        list.add(temp);
        System.out.println(temp.toString() + " was added to the list.");
    }
    /**
     Creates a FixedPoint number to use to find a matching partner in the list.
     If it does find a match, it deletes the match from the list.
     If there are multiple matches, it deletes the last match.
     * @param dbl (double for the FixedPoint number)
     */
    private static void delete(double dbl)
    {
        FixedPoint temp = new FixedPoint(dbl, num);
        if(list.delete(temp))
        {
            System.out.println("A value equal to " + temp.toString() + " was "
                    + "deleted from the list.");
        }
        else
        {
            System.out.println("No value equals " + temp.toString() + " was in"
                    + " the list.");
        }
    }
    /**
     Calls the toString on the list which prints out all the 
     numbers in the list.
     */
    private static void print()
    {
        System.out.print("All FixedPoint numbers in the list are:");
        System.out.println(list.toString());
    }
    /**
     Changes the qVal to the new qVal 
     * @param num1 (new qVal)
     */
    private static void qval(int num1)
    {
        num = num1;
        System.out.println("Current Q changed to " + num);
    }
    /**
     Calls the function max on list which returns the largest FixedPoint number
     in the list. Prints out the number. If the list is empty, prints out
     "The list is empty" instead.
     */
    private static void largest()
    {
        FixedPoint temp = list.max();
        try
        {
            System.out.println("The largest fixed point "
                + "number is: " + temp.toString());
        }
        catch (Exception ex)
        {
            System.out.println("The list is empty");
        }
        
    }
    /**
     Calls the function min on list which returns the smallest FixedPoint number
     in the list. Prints out the number. If the list is empty, prints out
     "The list is empty" instead.
     */
    private static void smallest()
    {
        
        FixedPoint temp = list.min();
        try
        {
            System.out.println("The smallest fixed point "
                + "number is: " + temp.toString());
        }
        catch (Exception ex)
        {
            System.out.println("The list is empty");
        }
    }
    /**
     Prints out the sum of all the numbers in the list.
     */
    private static void sum()
    {
        FixedPoint temp = list.sum(num);
        System.out.println("The sum is: " + temp.toString());
    }
    public static void main( String args[])
    {
        /*
        try
        {
            Scanner stdin = new Scanner ( new File("Prog2.in"));
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        */
        
        while(sc.hasNext())
       {
           String command = sc.next();
           switch(command)
           {
               case "A":
                   String dbl = sc.next();
                   double dbl1 = Double.parseDouble(dbl);
                   Prog2.add(dbl1);
                   break;
               case "Add":
                   dbl = sc.next();
                   dbl1 = Double.parseDouble(dbl);
                   Prog2.add(dbl1);
                   break;
               case "D":
                   dbl = sc.next();
                   dbl1 = Double.parseDouble(dbl);
                   Prog2.delete(dbl1);
                   break;
               case "P":
                   Prog2.print();
                   break;
               case "Print":
                   Prog2.print();
                   break;
               case "Q":
                   String int1 = sc.next();
                   int int2 = Integer.parseInt(int1);
                   Prog2.qval(int2);
                   break;
               case "B":
                   largest();
                   break;
               case "M":
                   smallest();
                   break;
               case "S":
                   sum();
                   break;
               default:
                   System.out.println(command + " is not a valid command!");
                   break;
           } 
        }
        System.out.println("Normal termination of Program 2!");
    }
}