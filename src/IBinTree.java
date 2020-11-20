import java.lang.Math;
import java.util.ArrayList;
import java.util.HashSet;

interface IBinTree {

 // determines whether element is in the tree
 boolean hasElt(int e);

 // returns number of nodes in the tree; counts duplicate elements as separate items
 int size();

 // returns depth of longest branch in the tree
 int height();

 // Determine if the root of this heap is bigger than the given element
 boolean isBigger(int e);

 // Determine number of occurrences of an element in a given tree
 int countOccurrences(int num);

 // Creates an array list of all elements within the tree
 HashSet<Integer> createElementsList();

 // Determine if the given tree is a heap based on the basic definition of a heap
 boolean isHeap();
}

