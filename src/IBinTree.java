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

class MtBT implements IBinTree {
 MtBT(){}

 // returns false since empty tree has no elements
 public boolean hasElt(int e) {
  return false;
 }

 // returns 0 since enpty tree has no elements
 public int size() {
  return 0;
 }

 // returns 0 since empty tree has no branches
 public int height() {
  return 0;
 }

 public boolean isBigger(int e) {
  return true;
 }

 // returns 0 because an empty heap contains no elements
 public int countOccurrences(int num) {
  return 0;
 }
 public boolean isHeap() {
  return true;
 }
}

class DataBT implements IBinTree {
 int data;
 IBinTree left;
 IBinTree right;

 DataBT(int data, IBinTree left, IBinTree right) {
  this.data = data;
  this.left = left;
  this.right = right;
 }
 
 // an alternate constructor for when both subtrees are empty
 DataBT(int data) {
   this.data = data;
   this.left = new MtBT();
   this.right = new MtBT();
 }

 // determines whether this node or node in subtree has given element
 public boolean hasElt(int e) {
  return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
 }

 // adds 1 to the number of nodes in the left and right subtrees
 public int size() {
  return 1 + this.left.size() + this.right.size();
 }

 // adds 1 to the height of the taller subtree
 public int height() {
  return 1 + Math.max(this.left.height(), this.right.height());
 }

 public boolean isBigger(int e) {
  return (this.data >= e);
 }

 public int countOccurrences(int num) {
  if(num == this.data) {
   return 1 + this.right.countOccurrences(num) + this.left.countOccurrences(num);
  }
  else
   return 0 + this.right.countOccurrences(num) + this.left.countOccurrences(num);
 }

 public boolean isHeap() {
  return this.left.isBigger(this.data) && this.right.isBigger(this.data) && this.left.isHeap() && this.right.isHeap();
 }
}