public class HeapChecker {

    public HeapChecker(){}

    public boolean addEltTester(IHeap hOrig, int elt , IBinTree hAdded) {
        if(hOrig.isHeap() && hAdded.isHeap()) {
            for(int i : hAdded.createElementsList()) {
                if(i == elt) {
                    if(hOrig.countOccurrences(elt) + 1 == hAdded.countOccurrences(elt)) {
                        continue;
                    }
                }
                else if(hOrig.countOccurrences(i) == hAdded.countOccurrences(i)) {
                    continue;
                }
                else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }




}
