package utils.binarytree;

import solutions.medium.LCADeepestLeaves;

import java.util.LinkedList;
import java.util.Queue;

public class PreOrderTraversal {

    public static TreeNode createTree (Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        // create root
        TreeNode root = new TreeNode(arr[0]);

        // queue to keep track of level order insertion
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i=1; i<arr.length; i+=2) {
            TreeNode current = queue.poll();

            // create left child
            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }

            // create right child
            if (i+1 < arr.length && arr[i+1] != null) {
                current.right = new TreeNode(arr[i+1]);
                queue.offer(current.right);
            }
        }
        return root;
    }

    public static void traverse(TreeNode root) {
       if (root == null) return;
       System.out.println(root.val);
       traverse(root.left);
       traverse(root.right);
    }

    public static void main(String[] args) {
        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = PreOrderTraversal.createTree(arr);
        traverse(root);
    }
}
