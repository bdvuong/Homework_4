import org.junit.Test;

import javax.xml.crypto.Data;

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
    IHeap emptyHeap = new MtHeap();
    IHeap heapFourEmpty = new DataHeap(4, emptyHeap, emptyHeap);
    IHeap heapSix = new DataHeap(6, emptyHeap, emptyHeap);
    IHeap heapFour = new DataHeap(4, heapFourEmpty, heapSix);
    IHeap heapTen = new DataHeap(10, emptyHeap, emptyHeap);
    IHeap heapEleven = new DataHeap(11, emptyHeap, emptyHeap);
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

}

