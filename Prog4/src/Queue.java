/**
 *
 * @author lambertth
 */

public class Queue<E>
{
   private E[] elements;
   private int front, rear, count;

   public Queue(int size)
   {
      elements = (E[]) new Object[size];
      front = 0;
      rear = 0;
   }
   
   public boolean isEmpty()
   {
      return count < 1;
   }
   
   public boolean isFull()
   {
      return count == elements.length;
   }
   
   public boolean add(Object obj) throws Exception
   {
      if(!isFull())
      {
         count++;
         elements[rear] = (E) obj;
         rear = ++rear % elements.length;
         return true;
      }
      else
      {
          throw new Exception("Stack is full!");
      }
       
   }
   
   public Object remove() throws Exception
   {
      if(!isEmpty())
      {
         count--;
         Object temp = elements[front];
         front = ++front % elements.length;
         return temp;
      }
      else
      {
         throw new Exception("Stack is Empty!");
      }
   }
   
   public static void main(String args[])
   {
      System.out.println ( "Declare j1, j2 and j3 as Job" );
      Job j1, j2, j3;
      
      System.out.println ( "Declare obj as Object" );
      Object obj;
      
      System.out.println ( "Declare jobQ as Queue of class Job with size 5" );
      Queue jobQ = new Queue(5);
      
      System.out.println ( "jobQ is empty, since jobQ.isEmpty() "
              + "is " + jobQ.isEmpty());
      System.out.println ( "jobQ is not full, since "
              + "jobQ.isFull() is " + jobQ.isFull());
      
      System.out.println ( "Create a job with arrival time being 5 and "
              + "assign it to j1");
      j1 = new Job(5);
      
      System.out.println ( "Add j1 to jobQ");
      try
      {
         jobQ.add(j1);
      }
      catch(Exception e)
      {
          
      }
      
      System.out.println ( "jobQ is not empty, since jobQ.isEmpty() "
              + "is " + jobQ.isEmpty());
      System.out.println ( "jobQ is not full, since "
              + "jobQ.isFull() is " + jobQ.isFull());
      
      System.out.println ( "Create a job with arrival time being 15 "
              + "and assign it to obj");
      obj = new Job(15);
      
      System.out.println ( "Add obj to jobQ");
      try
      {
         jobQ.add(obj);
      }
      catch(Exception e)
      {
          
      }
      
      
      System.out.println ( "Create a job with arrival time being "
              + "50 and assign it to j2");
      j2 = new Job(50);
      
      System.out.println ( "Add j2 to jobQ");
      
      try
      {
         jobQ.add(j2);
      }
      catch(Exception e)
      {
          
      }
      
      
      System.out.println ( "Create a job with arrival time being 115 "
              + "and assign it to j3");
      j3 = new Job(115);
      
      System.out.println ( "Add j3 to jobQ");
      try
      {
         jobQ.add(j3);
      }
      catch(Exception e)
      {
          
      }
      
      
      System.out.println ( "jobQ is not empty, since jobQ.isEmpty() "
              + "is " + jobQ.isEmpty());
      System.out.println ( "jobQ is not full, since "
              + "jobQ.isFull() is " + jobQ.isFull());
      
      System.out.println ( "Create a job with arrival time being "
              + "215 and assign it to obj");
      obj = new Job(215);
      
      System.out.println ( "Add obj to jobQ");
      
      try
      {
         jobQ.add(obj);
      }
      catch(Exception e)
      {
          
      }
      
      System.out.println ( "jobQ is not empty, since jobQ.isEmpty() "
              + "is " + jobQ.isEmpty());
      System.out.println ( "jobQ is full, since "
              + "jobQ.isFull() is " + jobQ.isFull());
      
      System.out.println ( "Remove the first job from jobQ and "
              + "assign it to obj");
      
      try
      {
         obj = jobQ.remove();
      }
      catch(Exception e)
      {
          
      }
      
      System.out.println ( "Show obj as a string on a line");
      System.out.println(obj.toString());
      
      System.out.println ( "jobQ is not empty, since jobQ.isEmpty() "
              + "is " + jobQ.isEmpty());
      System.out.println ( "jobQ is not full, since "
              + "jobQ.isFull() is " + jobQ.isFull());
      
      System.out.println ( "Create a job with arrival time being "
              + "250 and assign it to obj");
      obj = new Job(250);
      
      System.out.println ( "Add obj to jobQ");
      
      try
      {
         jobQ.add(obj);
      }
      catch(Exception e)
      {
          
      }
      
      while(!jobQ.isEmpty())
      {
         try
         {
            Object temp = jobQ.remove();
            System.out.println("Job removed: " + temp.toString());
         }
         catch(Exception e)
         {
             
         }
      }
      
      System.out.println ( "jobQ is empty, since jobQ.isEmpty() "
              + "is " + jobQ.isEmpty());
      System.out.println ( "jobQ is not full, since "
              + "jobQ.isFull() is " + jobQ.isFull());
      System.out.println ( "Reset the job count");
      Job.reset();
      
      System.out.println ( "Create a job with arrival time being "
              + "295 and assign it to obj");
      obj = new Job(295);
      
      System.out.println ( "Add obj to jobQ");
      
      try
      {
         jobQ.add(obj);
      }
      catch(Exception e)
      {
          
      }
      
      System.out.println ( "jobQ is not empty, since jobQ.isEmpty() "
              + "is " + jobQ.isEmpty());
      System.out.println ( "jobQ is not full, since "
              + "jobQ.isFull() is " + jobQ.isFull());
      
      System.out.println ( "Create a job with arrival time being 305 and "
              + "assign it to obj");
      obj = new Job(305);
      
      System.out.println ( "Add obj to jobQ");
      
      try
      {
         jobQ.add(obj);
      }
      catch(Exception e)
      {
          
      }
      
      while(!jobQ.isEmpty())
      {
         try
         {
            Object temp = jobQ.remove();
            System.out.println("Job removed: " + temp.toString());
         }
         catch(Exception e)
         {
         
         }
      }
      System.out.println ( "jobQ is empty, since jobQ.isEmpty() "
              + "is " + jobQ.isEmpty());
      System.out.println ( "jobQ is not full, since "
              + "jobQ.isFull() is " + jobQ.isFull());
  }
}