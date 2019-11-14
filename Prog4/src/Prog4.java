/**
@author Charles Charek
*/

import java.util.Scanner;

/**
 *
 * @author lambertth
 */
public class Prog4 
{
    static int arr_min = 0;
    static int arr_max = 0;
    static int sc_min = 0;
    static int sc_max = 0;
    static int stop_time = 0;
    static Scanner sc = new Scanner(System.in);
    
    private static void assign()
    {
       arr_min = sc.nextInt();
       arr_max = sc.nextInt();
       sc_min = sc.nextInt();
       sc_max = sc.nextInt();
       stop_time = sc.nextInt();
    }
    
    public static void main(String args[])
    {
       /*try
       {
           Scanner stdin = new Scanner ( new File("Prog4.in"));
       }
       catch (Exception ex)
       {
          System.out.println(ex.toString());
       }*/ 
       
       Simulation sim;
       while(sc.hasNext())
       {
          assign();
          sim = new Simulation(arr_min, arr_max, sc_min, sc_max, stop_time);
          try
          {
             sim.runSimulation();
          }
          catch(Exception e)
          {
          }
          System.out.println(sim.toString());
       }
       System.out.println("Normal Termination!");
    }
}
