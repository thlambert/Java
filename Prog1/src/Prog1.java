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
public class Prog1 
{
   private static GolfLeague league = new GolfLeague();
   private static Scanner sc = new Scanner (System.in);
   
   /**
   Adds an instance of GolfLeagueMember to league.
   The method reads in two strings for name and group
   and an integer for score, invokes the add method 
   on league, and displays a message according to the
   return result of the add method.
   */
   private static void addMember()   
   {
       String name = sc.next();
       String group = sc.next();
       int score = sc.nextInt();
       //String garbage = sc.nextLine();
       if(group.equals("Regular"))
       {
           if(league.add(new RegularMember(name, score)))
           {
               System.out.println("Regular Member " + name + " is added");
           }
           else
           {
               System.out.println(name + " is not added");
           }
       }
       if(group.equals("Senior"))
       {
           if(league.add(new SeniorMember(name, score)))
           {
               System.out.println("Senior Member " + name + " is added");
           }
           else
           {
               System.out.println(name + " is not added");
           }
       }
       if(group.equals("Youth"))
       {
           if(league.add(new YouthMember(name, score)))
           {
               System.out.println("Youth Member " + name + " is added");
           }
           else
           {
               System.out.println(name + " is not added");
           }
       }
   }

   /**
   Deletes a member from league.
   The method reads in a string for name, invokes method
   delete on league, and displays a message according to 
   the return result of the delete method.
   */
   private static void deleteMember() 
   {
       String name = sc.next();
       //String garbage = sc.nextLine();
       if(league.delete(name))
       {
           System.out.println(name + " is deleted");
       }
       else
       {
           System.out.println(name + " is not deleted");
       }
   }
      
   /**
   Adds a score for a member in league.
   The method reads in a string for name and an integer 
   for score, invokes method enterScore on league, and 
   displays a message according to the return result of 
   the enterScore method.
   */
   private static void addScore()
   {
       String name = sc.next();
       int score = sc.nextInt();
       //String garbage = sc.nextLine();
       if(league.enterScore(name, score))
       {
           System.out.println("Score of " + score + " is stored for " + name);
       }
       else
       {
           System.out.println("Score was not added");
       }
   }

   /**
   Displays the handicap for a member in league.
   The method reads in a string for name, invokes method 
   getHandicap on league, and displays a message according 
   to the return result of the getHandicap method.
   */
   private static void displayHandicap()
   {
       String name = sc.next();
       System.out.println(name + " has a handicap of " + 
               league.getHandicap(name));
   }
   public static void main(String args[])
   {
       while(sc.hasNext())
       {
           String command = sc.next().toLowerCase();
           switch(command)
           {
               case "add":
                   Prog1.addMember();
                   break;
               case "delete":
                   Prog1.deleteMember();
                   break;
               case "score":
                   Prog1.addScore();
                   break;
               case "handicap":
                   Prog1.displayHandicap();
                   break;
               case "print":
                   System.out.println(Prog1.league.toString());
                   break;
           }
       }
   }
}
