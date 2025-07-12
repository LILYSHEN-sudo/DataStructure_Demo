package Binary_Search_Tree;
import java.util.ArrayList;
import java.util.List;

public class IsBST {
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

     //Method-1: inOrder and print all values, then compare its values
    public boolean isValidBST1(TreeNode root) {
        if(root == null) {
            return true;
        }
        List<Integer> res = inOrderTraversal1(root);
        for(int i = 0; i < res.size() - 1; i++) {
            if(res.get(i) > res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> inOrderTraversal1(TreeNode root) {
         List<Integer> list = new ArrayList<>();
         inOrder1(root, list);
         return list;
    }
    public void inOrder1(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        inOrder1(root.left, list);
        list.add(root.val);
        inOrder1(root.right, list);
    }

    //Method-2: inOrder but not print all values, but only the prevNode
    private TreeNode prev = null;
    private boolean isValid = true;
    public boolean isValidBST2(TreeNode root) {
         if(root == null) {
             return true;
         }
         prev = null;
         isValid = true;
         inOrder2(root);
         return isValid;
    }

    public void inOrder2(TreeNode node) {
        if(node == null) {
            return;
        }
        inOrder2(node.left);
        if(prev != null && node.val <= prev.val) {
            isValid = false;
        }
        prev = node;
        inOrder2(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        IsBST solution = new IsBST();
        System.out.println(solution.isValidBST1(root));
        System.out.println(solution.isValidBST2(root));
    }

}

