public class HeapChecker {

    public HeapChecker(){};

    public boolean addEltTester(IHeap hOrig, int elt , IBinTree hAdded) {
        if(hOrig.isHeap() && hAdded.isHeap()) {
            if(hOrig.countOccurrences(elt) + 1 == hAdded.countOccurrences(elt)); {
                return true;
            }
        }
        return false;
    }




}
