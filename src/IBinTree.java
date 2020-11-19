import java.lang.Math;

interface IBinTree {
 // determines whether element is in the tree
 boolean hasElt(int e);
 // returns number of nodes in the tree; counts duplicate elements as separate items
 int size();
 // returns depth of longest branch in the tree
 int height();

 boolean isBigger(int e);
 // Determine number of occurrences of an element (dev note: can technically just start at a subtree and continue down technically...?)
 int countOccurrences(int num);

 boolean isHeap();
}

