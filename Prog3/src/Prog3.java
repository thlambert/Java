import java.util.Scanner;
import java.io.File;
import java.util.Vector;

/**
* This class handles checking if all the expressions are valid, removing 
* expressions after an invalid command, listing all the good values, 
* and handling the input and output.
* 
* This class handles checking if all the expressions are valid by making sure 
* there aren't any invalid commands and there are the correct number of operands
* and operators. This class also handles removing all expressions after an 
* invalid command, listing all the good final results after there isn't anymore 
* input and all the input and output.
* 
* @author lambertth
*/

public class Prog3 
{
   private static final int SIZE = 50;
   private static Scanner sc = new Scanner (System.in);
   private static Vector goodList = new Vector<TVector>(SIZE);
   private int count = 1;
   
   /**
   * This checks if there are any invalid commands or not the correct amount
   * of operators or operands.
   * @param line String with all the expressions
   * @return Same string if valid, if invalid all expressions after what caused
   * it to be invalid are removed
   */
   public static String[] validcheck(String line)
   {
       String toks[] = line.split(" ");
       String temp[] = new String[toks.length];
       int exp = 0, j = 0;
       for(int i = 0; i < toks.length; i++)
       {
           if(toks[i].equals("")) 
               temp[j++] = toks[i];           
           else
           {
                char c = toks[i].charAt(0);
                temp[j++] = toks[i];
                if(c == '(') 
                    exp++;
                else if(c == '+' || c == '-' || c == '*')
                {
                    if(exp < 2) //tests if there are two expressions yet
                    {
                        i = toks.length; //there weren't two expressions yet
                        temp = fillspace(temp);
                    }
                }
                else //token was invalid
                    i = toks.length;
                    temp = fillspace(temp);
           }
       }
       return temp;
    }
   /**
   * This fills an array with blank characters after an invalid command. 
   * This is used when an expression is invalid. You still need to output until 
   * the expression becomes invalid so after it becomes invalid, all expressions
   * afterward are turned into empty spaces.
   * @param stin String array to change
   * @return Array with blank spaces added
   */
   public static String[] fillspace(String[] stin)
   {
       for(int i = 0; i < stin.length; i++)
       {
           if(stin[i] == (null))
           {
               stin[i] = "";
           }
       }
       return stin;
   }
   /**
   * Handles the ending output. After all the expressions have been evaluated,
   * this function is called. This lists all the good answers which have been
   * stored in goodList.
   */
   public static void ending()
   {
       System.out.println("The list of good answers is:");
       for(int i = 0; i < goodList.size(); i++)
       {
           System.out.println(goodList.get(i));
       }
   }
   public static void main(String args[])
   {
      /*try
        {
            Scanner stdin = new Scanner ( new File("Prog3.in"));
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }*/
       Prog3 e = new Prog3();
       while(sc.hasNext())
       {
           RpnEvaluator r = new RpnEvaluator();
           String line = sc.nextLine();
           String list[] = validcheck(line);
           System.out.print("Expression " + e.count++ + " is: " );
           for(int i = 0; i < list.length; i++)
           {
               System.out.print(list[i]);
           }
           System.out.println("");
           if(r.firstcheck(line))
           {
               System.out.println("The value is: " + r.result());
               goodList.add(r.result());
           }
           else
               System.out.println("Invalid Expression");
       }
       ending();
   }
}
