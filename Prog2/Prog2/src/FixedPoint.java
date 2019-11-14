/**
 * This class handles creating, evaluating and changing FixedPoint numbers.
 * 
 * This class has the constructors to create FixedPoint numbers. This class 
 * handles converting the FixedPoint numbers to actual Double numbers. 
 * This class can add two FixedPoint numbers together, can change the qVal of a
 * FixedPoint number, can check if two FixedPoint numbers are equal, can check
 * if one FixedPoint number is less than another FixedPoint number, and can
 * print out the FixedPoint number as the intVal, qVal and Double value together
 * as one line.
 * 
 * @author lambertth
 */
public class FixedPoint
{
   protected int intVal;
   private int qVal;
   /**
    * Creates a FixedPoint number using a Double and a Integer
    * @param x (Double)
    * @param q (Integer which is the qVal)
    */
   public FixedPoint(double x, int q)
   {
      intVal = (int)(x * Math.pow(2, q));
      qVal = q;
   }
   /**
    * Copy Constructor - creates a FixedPoint number 
    * using another FixedPoint number
    * @param inpoint (FixedPoint number to copy)
    */
   public FixedPoint(FixedPoint inpoint)
   {
       intVal = inpoint.intVal;
       qVal = inpoint.qVal;
   }
   /**
    * Creates a FixedPoint number using two integers
    * @param x (Integer)
    * @param y (Integer)
    */
   public FixedPoint(int x, int y)
   {
       intVal = x;
       qVal = y;
   }
   /**
    * Converts this FixedPoint number to a double
    * @return (Double)
    */
   public double toDouble()
   {
       double temp = (intVal / Math.pow(2, qVal));
       return temp;
   }
   /**
    * Changes the qVal to a new qVal
    * @param newq (new qVal)
    * @return (FixedPoint with the new qVal)
    */
   private FixedPoint toqVal(int newq)
   {
       int move = qVal - newq;
       if(move > 0)
       {
           
           //increasing q
           /*
           double temp = intVal / Math.pow(2, qVal);
           int temp1 = intVal; 
           temp1 = (int)(temp * Math.pow(2, newq));
           */
           int newint = intVal >> move;
           return new FixedPoint(newint ,newq);
       }
       else
       {
           //decreasing q
           /*
           double temp = intVal / Math.pow(2, qVal);
           int temp1 = intVal;
           temp1 = (int) (temp * Math.pow(2, newq));
           */
           move = move * -1;
           int newint = intVal << move;
           return new FixedPoint(newint, newq);
       }
   }
   /**
    * Overrides the toString method from class Object. 
    * @return String of the integer value, the qVal and the Double value.
    */
   @Override
   public String toString()
   {
       return String.format( "%d,%d: %.6f", intVal, qVal, toDouble() );
   }
   /**
    * Overrides the equals method from class Object. 
    * Checks if the object is a FixedPoint value.
    * If the object isn't a FixedPoint number, it returns false.
    * 
    * If the object is a FixedPoint number, it creates two tests where 
    * it changes the the first number's qVal to the second numbers qVal and 
    * then the second number's qVal to the first number's qVal and then checks
    * both cases to see if they are equal.
    * 
    * @param obj (Object to check if equal to)
    * @return true (the numbers are equal)
    *         false (obj isn't a FixedPoint number, or the numbers aren't equal)
    */
   @Override
   public boolean equals(Object obj)
   {
       if( obj instanceof FixedPoint)
       {
           FixedPoint temp = ((FixedPoint) obj);
           FixedPoint temp1 = this;
           
           
           FixedPoint test1 = temp.toqVal(qVal);
           FixedPoint test2 = temp1.toqVal(temp.qVal);
           
           if(test1.intVal == temp1.intVal)
           {
               if(test2.intVal == temp.intVal)
               {
                   return true;
               }
           }
       }
       return false;
   }
   /**
    * Adds one FixedPoint number to another.
    * @param p (FixedPoint to add)
    * @param resultQ (qVal to set the result to)
    * @return FixedPoint (result of adding the numbers together)
    */
   public FixedPoint plus(FixedPoint p, int resultQ)
   {
       FixedPoint temp = new FixedPoint(p);
       FixedPoint temp1 = new FixedPoint(this);
       
       temp = temp.toqVal(resultQ);
       temp1 = temp1.toqVal(resultQ);
       
       int temp2 = temp.intVal + temp1.intVal;
       
       FixedPoint yes = new FixedPoint(temp2, resultQ);
       
       return yes;
   }
   /**
    * Checks if this FixedPoint number is less than the one given 
    * in the parameters. If this number is lower, returns true.
    * Otherwise returns false.
    * If the numbers have different qVals, it changes the qVals to the 
    * smaller qVal
    * @param p (FixedPoint number to check if smaller than)
    * @return true(this number is smaller than the number provided)
    *         false(this number isn't smaller than the number provided)
    */
   public boolean lessThan (FixedPoint p)
   {
       FixedPoint temp = new FixedPoint(p);
       FixedPoint temp1 = new FixedPoint(this);
       if(temp1.qVal > temp.qVal)
       {
           temp1 = temp1.toqVal(temp.qVal);
       }
       else
       {
           temp = temp.toqVal(temp1.qVal);
       }
       if(temp1.intVal < temp.intVal)
       {
           return true;
       }
        return false;
   }
   
   /*
   private static void verify(FixedPoint fpt1, FixedPoint fpt2)
   {
       System.out.println("fpt1: " + fpt1.toString());

       System.out.println("fpt2: " + fpt2.toString());
       
       System.out.println("(fpt1 + fpt2) of qVal 5: " + fpt1.plus(fpt2, 5));
       
       System.out.println("(fpt1 + fpt2) of qVal 10: " + fpt1.plus(fpt2, 10));
       
       if (fpt1.lessThan(fpt2))
          System.out.println("fpt1 is less than fpt2");
       else
          System.out.println("fpt1 is not less than fpt2");
       
       if (fpt1.equals(fpt2))
          System.out.println("fpt1 equals fpt2");
       else
          System.out.println("fpt1 does not equal fpt2");
       
       if (fpt1 == fpt2)
          System.out.println("fpt1 and fpt2 point to the same object");
       else
          System.out.println("fpt1 and fpt2 point to different objects");
      
      System.out.println();
       
   }
   public static void main( String args[])
   {
       Object obj1, obj2;
       FixedPoint p1, p2;
       double x = 243.15;
       double y = 243.13;
       
       p1 = new FixedPoint(x, 6);
       p2 = new FixedPoint(y, 5);
       
       verify(p1, p2);
       
       verify(p2, p1);
       
       p2 = new FixedPoint(y, 8);
       
       verify(p1, p2);
       verify(p2, p1);
       
       obj1 = new FixedPoint(x, 4);
       
       verify((FixedPoint) obj1, p1);
       verify(p1, (FixedPoint) obj1);
       
       p2 = new FixedPoint(x, 8);
       
       verify(p1, p2);
       
       obj2 = p2.toqVal(13);
       
       verify((FixedPoint) obj2, p2);
       
       obj2 = p2.toqVal(5);
       
       verify((FixedPoint) obj2, p2);
       
       obj1 = new FixedPoint(p1);
       
       verify((FixedPoint) obj1, p1);
       
       obj2 = p1;
       
       verify((FixedPoint) obj2, p1);
   }
    */
}