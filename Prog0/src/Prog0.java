import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lambertth
 */
public class Prog0 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ScoresList list = new ScoresList();
        list.print();
        System.out.println("The average of all"
                    + " scores is " + list.average() + ".");
        
        int num1 = sc.nextInt();
        String garbage = sc.nextLine();
        for(int i = 0; i < 2; i++)
        {
            if(i == 1)
            {
                num1 = sc.nextInt();
                garbage = sc.nextLine();
            }
            for(int j = 0; j < num1; j++)
            {
                int num2 = sc.nextInt();
                garbage = sc.nextLine();
                if(list.appendScore(num2))
                {
                    System.out.println("The value " + num2 + " is added "
                        + "to the list.");
                }
                else
                {
                    System.out.println("The value " + num2 + " is not added "
                            + "to the list.");
                }
            }
            
            list.print();
            System.out.println("The average of all"
                    + " scores is " + list.average() + ".");
        
            num1 = sc.nextInt();
            garbage = sc.nextLine();
        
            for (int k = 0; k < num1; k++)
            {
                int num2 = sc.nextInt();
                garbage = sc.nextLine();
                if(list.delete(num2))
                {
                    System.out.println("The value " + num2 + " is deleted "
                        + "from the list.");
                }
                else
                {
                    System.out.println("The value " + num2 + " is not in the "
                            + "list.");
                }
            }
            
            list.print();
            System.out.println("The average of all"
                    + " scores is " + list.average() + ".");
        }
        num1 = sc.nextInt();
        garbage = sc.nextLine();
        for (int k = 0; k < num1; k++)
        {
            int num2 = sc.nextInt();
            garbage = sc.nextLine();
            if(list.delete(num2))
            {
                System.out.println("The value " + num2 + " is deleted "
                    + "from the list.");
            }
            else
            {
                System.out.println("The value " + num2 + " is not in the "
                            + "list.");
            }
        }
        list.print();
        System.out.println("The average of all"
                + " scores is " + list.average() + ".");
    }
}
