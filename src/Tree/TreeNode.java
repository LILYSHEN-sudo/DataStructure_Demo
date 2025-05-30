package Tree;

public class TreeNode {
    public int val;              //root
    public TreeNode left;        //left node
    public TreeNode right;       //right node

    //create constructor
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode root;
    public int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

