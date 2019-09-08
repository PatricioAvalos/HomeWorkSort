/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import mergesort.MergeSortParallel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
 
import java.util.Arrays;
import java.util.Random;



/**
 *
 * @author D4C
 */
public class test {
    
    public test() {
        
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

    @Test
    public void performanceTest() {
        int[] serial = new Random().ints(1000000).toArray();
 
        MergeSortParallel sorter = new MergeSortParallel(serial);
        long start = System.currentTimeMillis();
        start = System.currentTimeMillis();
        sorter.sort();
        System.out.println("Parallel Merge Sort done in: "
                + (System.currentTimeMillis()-start));
    }
}
