package Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

    //Method-1: Non-Recursion
    //(1) use two stacks  TC: O(n) SC:O(n)
    public List<Integer> postOrderNR1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> output = new Stack<>();
        //(1) use two stacks  TC: O(n) SC:O(n)
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            output.push(cur.val);
            if(cur.left != null) {
                stack.push(cur.left);
            }
            if(cur.right != null) {
                stack.push(cur.right);
            }
        }
        while(!output.isEmpty()) {
            res.add(output.pop());
        }
        return res;
    }

    //(2) use two stacks  TC: O(n) SC:O(n)
    public List<Integer> postOrderNR(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();

        TreeNode p = root;
        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                stack.push(p);
                output.push(p);
                p = p.right;
            } else {
                p = stack.pop();
                p = p.left;
            }
        }
        while(!output.isEmpty()) {
            res.add(output.pop().val);
        }
        return res;
    }

    //Method-2: Recursion
    private void postOrderR(TreeNode node) {
        if(node == null) {
            return;
        }
        postOrderR(node.left);
        postOrderR(node.left);
        System.out.println(node.val);
    }
}
