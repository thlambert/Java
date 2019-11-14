/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lambertth
 */
public class FixedPointTest {
    /**
     * Test of toDouble method, of class FixedPoint.
     */
    @Test
    public void testToDouble() 
    {
        System.out.println("toDouble");
        FixedPoint instance = new FixedPoint(243.15, 6);
        
        double expResult = 243.15;
        double result = instance.toDouble();
        assertNotEquals(expResult, result, 0.0); //1
        
        expResult = 243.140625;
        assertEquals(expResult, result, 0.0); //2
        
        instance = new FixedPoint(243.125, 5);
        expResult = 243.125;
        result = instance.toDouble();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class FixedPoint.
     */
    @Test
    public void testToString() 
    {
        System.out.println("toString");
        FixedPoint instance = new FixedPoint(128.125, 6);
        String expResult = "8200,6: 128.125000";
        String result = instance.toString();
        assertEquals(expResult, result); //1
        
        instance = new FixedPoint(128.125, 10);
        expResult = "131200,10: 128.125000";
        result = instance.toString();
        assertEquals(expResult, result); //2
        
        instance = new FixedPoint(128.125, 3);
        expResult = "1025,3: 128.125000";
        result = instance.toString();
        assertEquals(expResult, result); //3
    }

    /**
     * Test of equals method, of class FixedPoint.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new FixedPoint(128.125, 10);
        FixedPoint instance = new FixedPoint(128.125, 6);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result); //1
        
        instance = new FixedPoint(128.15, 6);
        obj = new FixedPoint(128.15, 10);
        expResult = false;
        result = instance.equals(obj);
        assertEquals(expResult, result); //2
    }
    
    /**
     * Test of plus method, of class FixedPoint.
     */
    
    @Test
    public void testPlus() 
    {
        System.out.println("plus");
        FixedPoint instance = new FixedPoint(100.0625, 4);
        FixedPoint p = new FixedPoint(128.125, 6);
        int expResult = 7302;
        
        FixedPoint result =  instance.plus(p, 5);
        assertEquals(expResult, result.intVal); //1
        
        expResult = 233664;
        result = instance.plus(p, 10);
        assertEquals(expResult, result.intVal); //2
        
        expResult = 912;
        result = instance.plus(p, 2);
        assertEquals(expResult, result.intVal); //3
    }
    /**
     * Test of lessThan method, of class FixedPoint.
     */
    @Test
    public void testLessThan() {
        System.out.println("lessThan");
        
        FixedPoint instance = new FixedPoint(128.125, 6);
        FixedPoint p = new FixedPoint(128.125, 10);
        boolean expResult = false;
        boolean result = instance.lessThan(p);
        assertEquals(expResult, result); //1
        
        result = p.lessThan(instance);
        assertEquals(expResult, result); //2
        
        p = new FixedPoint(128.124, 10);
        expResult = true;
        result = p.lessThan(instance);
        assertEquals(expResult, result); //3
        
        instance = new FixedPoint(128.124999999, 6);
        p = new FixedPoint(128.1249999, 10);
        expResult = false;
        result = p.lessThan(instance);
        assertEquals(expResult, result); //4
    }
}