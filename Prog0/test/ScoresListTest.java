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
public class ScoresListTest {
    
    public ScoresListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of appendScore method, of class ScoresList.
     */
    @Test
    public void testAppendScore() {
        System.out.println("appendScore");
        int score = 0;
        ScoresList instance = new ScoresList();
        boolean expResult = false;
        boolean result = instance.appendScore(score);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of average method, of class ScoresList.
     */
    @Test
    public void testAverage() {
        System.out.println("average");
        ScoresList instance = new ScoresList();
        float expResult = 0.0F;
        float result = instance.average();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ScoresList.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int score = 0;
        ScoresList instance = new ScoresList();
        boolean expResult = false;
        boolean result = instance.delete(score);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class ScoresList.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        ScoresList instance = new ScoresList();
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
