package Binary_Search_Tree;

import java.util.*;

public class PreOrder {
    //Method-1: Non-Recursion
    public List<Integer> preOrderNR(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }


    //Method-2: Recursion
    public void preOrderR(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderR(root.left);
        preOrderR(root.right);
    }
}
