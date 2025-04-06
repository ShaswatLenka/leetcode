package solutions.medium;

import utils.binarytree.PreOrderTraversal;
import utils.binarytree.TreeNode;

/**
 * 1123: LCA of deepest leaves
 * Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.
 * Recall that:
 *     The node of a binary tree is a leaf if and only if it has no children
 *     The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
 *     The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.
 *
 */
import javafx.util.Pair;

import java.lang.reflect.ParameterizedType;

public class LCADeepestLeaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
    }

    private Pair<TreeNode, Integer> dfs(TreeNode root) {
        if (root == null) {
            return new Pair<>(null, 0);
        }
        /*
        Start counting depth from leaf nodes. For any node, we compare its left or right subtree and propagate the
        information of the node that has the higher depth till now, to the parent node.
        */

        Pair<TreeNode, Integer> left = dfs(root.left); // used to propagate info of lca node to parent
        Pair<TreeNode, Integer> right = dfs(root.right); // used to propagate info of lca node to parent

        if (left.getValue() > right.getValue()) {
            return new Pair<>(left.getKey(), left.getValue() + 1); // left node is LCA node (possibly)
        }
        if (right.getValue() > left.getValue()) {
            return new Pair<>(right.getKey(), right.getValue() + 1); // right node is LCA node (possibly)
        }
        return new Pair<>(root, right.getValue() + 1); // in this case the current node is the LCA node itself
    }

    public static void main(String[] args) {
        Integer[] input = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = PreOrderTraversal.createTree(input);
        LCADeepestLeaves sol = new LCADeepestLeaves();
        System.out.println(sol.lcaDeepestLeaves(root).val);
    }
}
