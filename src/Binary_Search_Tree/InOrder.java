package Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    //Method-1: Non-Recursion
    public List<Integer> inOrderNR(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    //Method-2: Recursion
    public List<Integer> inOrderR(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        inOrderR(root.left);
        res.add(root.val);
        inOrderR(root.right);
        return res;
    }
}
