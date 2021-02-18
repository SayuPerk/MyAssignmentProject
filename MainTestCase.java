//package com.javatpoint.testcase;

import static org.junit.Assert.assertEquals;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;
//import com.javatpoint.logic.Calculation;
import Main;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MainTestCase {

//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception {
//        System.out.println("before class");
//    }
//    @Before
//    public void setUp() throws Exception {
//        System.out.println("before");
//    }

    ArrayList<String> expectedOutput = new ArrayList<String>();


    @Test
    public void testProcessData(){
        System.out.println("test case find max");
        assertEquals(4,Calculation.findMax(new int[]{1,3,4,2}));
        assertEquals(-2,Calculation.findMax(new int[]{-12,-3,-4,-2}));
    }
    @Test
    public void testCube(){
        System.out.println("test case cube");
        assertEquals(27,Calculation.cube(3));
    }

//    @After
//    public void tearDown() throws Exception {
//        System.out.println("after");
//    }
//
//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//        System.out.println("after class");
//    }

}