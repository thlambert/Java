/**
 *
 * @author lambertth
 */

import java.util.Random;

public class Simulation 
{
    private int arr_min, arr_max, sc_min, sc_max, stop, numarr = 0, temp;
    private int nextArrivalTime, servedimme = 0, maxwaittime = 0, curtime; 
    private int numwaiting = 0, nextCompletionTime;
    private Job curProcessed = null;
    private Queue q;
    private Random arrivalRandNumGen = new Random(2345);
    private Random completionRandNumGen = new Random(5432);
    boolean flag = true;
    
    public Simulation(int min, int max, int scmin, int scmax, int stopt)
    {
       q = new Queue(stopt);
       arr_min = min;
       arr_max = max;
       sc_min = scmin;
       sc_max = scmax;
       stop = stopt;
       flag = true;
       temp = arr_min + arrivalRandNumGen.nextInt(arr_max - arr_min + 1);
       nextArrivalTime = temp + curtime;
       nextCompletionTime = -1;
    }
    
    public void runSimulation() throws Exception
    {
       while(flag)
       {
          if(curtime == nextCompletionTime)
          {
             complete();
          }
          if(curtime == nextArrivalTime)
          {
             arrival();
          }
          if(curtime == stop)
          {
             flag = false;
          }
           curtime = nextnumber(nextArrivalTime,  nextCompletionTime, stop);
       }
       Job.reset();
    }
    
    private void complete() throws Exception
    {
       if(q.isEmpty())
       {
          curProcessed = null;
          nextCompletionTime = -1;
       }
       else
       {
          numwaiting--;
          curProcessed = (Job) q.remove();
          if(curtime - curProcessed.getStamp() > maxwaittime )
          {
             maxwaittime = curtime - curProcessed.getStamp();
          }
          nextCompletionTime = sc_min +
                completionRandNumGen.nextInt(sc_max - sc_min + 1) + curtime;
       }
    }
    
    private void arrival() throws Exception
    {
       numarr++;
       Job j1 = new Job(nextArrivalTime);
       if(curProcessed == null)
       {
          servedimme++;
          curProcessed = j1;
          nextCompletionTime = sc_min + 
          completionRandNumGen.nextInt(sc_max - sc_min + 1) + curtime;
       }
       else
       {
          q.add(j1);
          numwaiting++;
       }
       nextArrivalTime = arr_min +  arrivalRandNumGen.nextInt(
             arr_max - arr_min + 1) +  curtime;
    }
    
    private int nextnumber(int a, int c, int s)
    {
       if(c == -1)
       {
          if(a < s)
             return a;
          else
             return s;
       }
       if(a <= c && a <= s)
          return a;
       if(c <= a && c <= s)
          return c;
       return s;
    }
    
    @Override
    public String toString()
    {
       String temp1 = "Current Job: ";
       if(curProcessed != null)
       {
          temp1 += curProcessed + "\n";
       }
       else
       {
          temp1 += "None\n";
       }
       temp1 += "Num Arrived: " + numarr + "\n";
       temp1 += "Num Waiting: " + numwaiting + "\n";
       temp1 += "Num Served Immed: " + servedimme + "\n";
       temp1 += "Max Waiting Time: " + maxwaittime + "\n";
       return temp1;
    }
}
