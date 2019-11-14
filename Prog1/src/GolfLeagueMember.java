/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lambertth
 */
abstract public class GolfLeagueMember 
{
   protected final int NUM_STORED_SCORES = 5;
   protected final double HANDICAP_PERCENT = 0.96;
   
   protected int coursePar = 72;
   private String name;
   protected int scores[] = new int[NUM_STORED_SCORES];  
   protected int curIndex;
   
   protected GolfLeagueMember(String inname, int inscore)
    {
        name = inname;
        curIndex = 0;
        for(int i = 0; i < 5; i++)
        {
            scores[i] = inscore;
        }
    }
   /**
    * gets the member name
    * @return member name
    */
    public String getName()
    {
        return this.name;
    }
    /**
     * creates the list of scores with the name and returns it
     * @return name of member and list of scores
     */
    @Override
    public String toString()
    {
        String temp = name + ": " + curIndex + "," + scores[0] + "," + scores[1] + 
                "," + scores[2] + "," + scores[3] + "," + scores[4];
        return temp;
    }
    /**
     * adds a score to the list
     * if list is full replaces the first score
     * @param inscore 
     */
    public void addScore(int inscore)
    {
        if(curIndex < 4)
        {
            scores[curIndex++] = inscore;
        }
        else
        {
            scores[curIndex] = inscore;
            curIndex = 0;
        }
    }
    abstract public int handicap();
    /**
     * finds the highest score in the list and returns the index of it
     * @return index of highest score
     */
    protected int indexOfMax()
    {
        int high = -1;
        int highindex = -1;
        for(int i = 0; i < 5; i++)
        {
            if(scores[i] > high)
            {
                highindex = i;
                high = scores[i];
            }
        }
        return highindex;
    }
    /**
     * finds the lowest score in the list and returns the index of it
     * @return index of lowest score
     */
    protected int indexOfMin()
    {
        int low = 100;
        int lowindex = -1;
        for(int i = 0; i< 5; i++)
        {
            if(scores[i] < low)
            {
                lowindex = i;
                low = scores[i];
            }
        }
        return lowindex;
    }
}
