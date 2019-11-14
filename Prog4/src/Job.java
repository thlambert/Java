
/**
 @author Charles Charek
 */

public class Job 
{
   public static int jobCount;
   private int tag;
   private int stamp;
   
   public Job( int temp )
   {
      tag = ++jobCount;
      stamp = temp;
   }
   
   public int getStamp()
   {
      return stamp;
   }
   
   public static void reset()
   {
      jobCount = 0;
   }
         
   @ Override
   public String toString()
   {
      String temp = "J:" + tag + "/T:" + stamp;
      return temp;
   }

}
