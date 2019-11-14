/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lambertth
 */
public class RegularMember extends GolfLeagueMember
{
    
    public RegularMember (String inname, int inscore)
    {
        super(inname, inscore);
    }
    
    /**
     * calculates the handicap of this member and returns it
     * @return handicap
     */
    @Override
    public int handicap()
    {
        float total = 0;
        for(int i = 0; i < 5; i++)
        {
            total += scores[i];
        }
        total -= scores[indexOfMax()];
        
        float average = (total/4) - coursePar;
        
        int value = (int) (average * HANDICAP_PERCENT);
        if(value < 0)
            return 0;
        else
            return value;
    }
    /**
     * creates a string and then adds the base class list to the string
     * @return completed score list for this member
     */
    @Override
    public String toString()
    {
        String temp = "Regular Member ";
        return temp + super.toString();
    }
}
