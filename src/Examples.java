import org.junit.Before;
import org.junit.Test;

import javax.xml.crypto.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

public class Examples {
    HeapChecker HT = new HeapChecker();


    /*
    Random Heap I made up
                     2
                   /   \
                  8     4
                 / \   / \
                10 11 4   6
     */

    IHeap heapFourEmpty = new DataHeap(4);
    IHeap heapSix = new DataHeap(6);
    IHeap heapFour = new DataHeap(4, heapFourEmpty, heapSix);
    IHeap heapTen = new DataHeap(10);
    IHeap heapEleven = new DataHeap(11);
    IHeap heapEight = new DataHeap(8, heapTen, heapEleven);
    IHeap rootHeap = new DataHeap(2, heapEight, heapFour);

    /*
       Random Heap I made up but the root does not uphold the LAW
                       100
                      /   \
                     8     4
                    / \   / \
                   10 11 4   6
     */
    IHeap badHeap = new DataHeap(100, heapEight, heapFour);

    /*
   Heap where all the elements are the same
                    4
                  /   \
                 4     4
                / \   / \
               4   4 4   4
    */
    IHeap heapFourFour = new DataHeap(4, heapFourEmpty, heapFourEmpty);
    IHeap sameHeap = new DataHeap(4, heapFourFour, heapFourFour);


    /*
    Random Heap I made up
                     2
                   /   \
                  4     4
                 / \   / \
                8  11 4   6
               /
              10
     */
    IHeap edgeLevelTwoRLeft = new DataHeap(4);
    IHeap edgeLevelTwoRRight = new DataHeap(6);
    IHeap edgeRightRootHeap = new DataHeap(4,edgeLevelTwoRLeft, edgeLevelTwoRRight);
    IHeap edgeLevelTwoLLeft = new DataHeap(8, new DataHeap(10), new MtHeap());
    IHeap edgeLeftRootHeap = new DataHeap(4, edgeLevelTwoLLeft, new DataHeap(11));
    IHeap edgeCaseRootHeap = new DataHeap(2, edgeLeftRootHeap,edgeRightRootHeap);

    public Examples() {
    }


    @Test
    public void testGoodHeap() {
        assertTrue(rootHeap.isHeap());
    }

    @Test
    public void testBadHeap() {
        assertFalse(badHeap.isHeap());
    }

    @Test
    public void testSameHeap() {
        assertTrue(sameHeap.isHeap());
    }

    @Test
    public void countOccurrencesSameHeap4() {
        assertEquals(7, sameHeap.countOccurrences(4));
    }

    @Test
    public void countOccurrencesSameHeap0() {
        assertEquals(0, sameHeap.countOccurrences(0));
    }

    @Test
    public void countOccurrencesRootHeap4() {
        assertEquals(2, rootHeap.countOccurrences(4));
    }

    @Test
    public void countOccurrencesEdgeCase() {
        assertEquals(3, edgeCaseRootHeap.countOccurrences(4));
    }

    @Test
    public void addEltTesterTest1(){
        assertTrue(HT.addEltTester(rootHeap, 2 , rootHeap.addElt(2)));
    }

    @Test
    public void addEltBadHeapTesterTest(){
        assertFalse(HT.addEltTester(rootHeap, 4, badHeap.addElt(2)));
    }

    @Test
    public void addEltsToListRootHeap1() {
        HashSet<Integer> expectedResult = new HashSet<>();
        expectedResult.add(2);
        expectedResult.add(8);
        expectedResult.add(10);
        expectedResult.add(11);
        expectedResult.add(4);
        expectedResult.add(6);
        assertEquals(expectedResult, rootHeap.createElementsList());
    }
    @Test
    public void addEltTesterReturnABadHeap() {
        //assertFalse(HT.addEltTester());
    }

    @Test
    public void addEltSameHeapTester() {

    }
}

