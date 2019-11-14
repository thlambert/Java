/**
Java class to manipulate a list of scores.
This program allows manipulation of a list of scores: 
   Adding, Deleting, Finding, Printing, Average
@author Thomas Lambert
*/

public class ScoresList
{
   public final int MAX_SIZE = 10;
   private int scores[] = new int[MAX_SIZE];
   private int numScores = 0;

   /**
   Adds a score to the end of the list if the list is not full.
   Time needed: O(1)
   @param score to add to the end of the scores list
   @return true if score is successfully added, false otherwise
   */
   public boolean appendScore ( int score )
   {
      // Write the function body
       if (numScores < MAX_SIZE)
       {
           scores[numScores++] = score;
           return true;
       }
       return false;
   }

   /**
   Calculates the float average of the scores stored in the list.
   Time needed: O(N)
   @return average of scores in the list, 0.0 if no scores in the list.
   */
   public float average()
   {
      float ave = 0.0F; // Floating point constants are doubles without the F
      int sum = 0;

      // Complete the function
      if (numScores > 0)
      {
          for(int i = 0; i < numScores; i++)
          {
              sum += scores[i];
          }
          return ave = (float)sum/(numScores);
      }
      else
      {
          return 0.0f;
      }
   }

   /**
   Deletes the LAST occurrence of score from the scores list, if it exists.
   Moves all scores up, maintaining relative positions, if it is deleted.
   Time needed: O(N)
   @param score to delete
   @return true if the score is successfully deleted, false otherwise
   */
   public boolean delete ( int score )
   {
      // Write the function body
      // You must use one and only one for loop inside the function.
      int num1 = find(score);
      if(num1 > -1)
      {
          numScores--;
          for(int i = num1; i < numScores; i++)
              scores[i] = scores[i + 1];
          
          return true;
      }
      else
      {
          return false;
      }
   }

   /**
   Tries to find the LAST occurrence of score in the list of scores.
   Time needed: O(N)
   @param score to find
   @return 0-based position of the LAST occurrence of score, -1 if not found
   */
   private int find ( int score )
   {
      // Write the function body
      // You must use one and only one for loop inside the function.
       for(int i = numScores - 1; i > -1; i--)
       {
           if (scores[i] == score)
           {
               return i;
           }
       }
       return -1;
   }

   /**
   Prints the list of scores to System.out, one score per line.
   Time needed: O(N)
   */
   public void print()
   {
      // Complete the function body
      System.out.println( "The list of scores is:" );
      for(int i = 0; i < numScores; i++)
      {
          System.out.println(scores[i]);
      }
      
   }

}  // class ScoresList