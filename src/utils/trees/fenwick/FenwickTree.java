package utils.trees.fenwick;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Creates a Fenwick Tree (fTree) with methods addToTree and rangeSum methods.
 * Since fTree is a 1-based indexed data structure, it's expected to be called from a context of
 * 0-based index. Hence, all internal indices are incremented by 1 wherever necessary.
 *
 * fTree: A Fenwick tree is a data structure in which the parent of a node is the result of removing the last
 * set bit from its child(ren). Both insertion and query takes O(log n)
 *
 */
public class FenwickTree {
    ArrayList<Integer> fenwickTree;
    Integer n;

    public FenwickTree(Integer n) {
        this.n = n + 1; // Fenwick Tree uses 1 based indexing
        fenwickTree = new ArrayList<>(Collections.nCopies(this.n, 0));
    }

    void addToTree(Integer index, Integer value) {
        index++; // 1 based index
        while (index < n) {
            fenwickTree.set(index, fenwickTree.get(index) + value);
            index += (index & (-index)); // last set bit
        }
    }

    private int sum (Integer index) {
        index++;
        Integer sum = 0;
        while (index != 0) {
           sum += fenwickTree.get(index);
           index -= (index & (-index));
        }
        return sum;
    }

    public int rangeSum(Integer left, Integer right) {
        return sum(right) - sum(left - 1);
    }

    public static void main(String[] args) {
        Integer[] example = {1,2,3,4,5,6,7};
        FenwickTree fTree = new FenwickTree(7);
        for (int i = 0; i<example.length; i++) {
            fTree.addToTree(i, example[i]);
        }
        System.out.println(fTree.rangeSum(3,5));
    }
}

