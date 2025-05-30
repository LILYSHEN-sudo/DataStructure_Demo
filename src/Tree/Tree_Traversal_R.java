package Tree;

public class Tree_Traversal_R {

    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;
    private int size;

    public static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
    public static void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(28);
        TreeNode node1 = new TreeNode(16);
        TreeNode node2 = new TreeNode(30);
        TreeNode node3 = new TreeNode(13);
        TreeNode node4 = new TreeNode(22);
        TreeNode node5 = new TreeNode(29);
        TreeNode node6 = new TreeNode(42);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println("Pre-order Traversal: ");
        Tree_Traversal_R.preOrder(root);
        System.out.println("In-order Traversal: ");
        Tree_Traversal_R.inOrder(root);
        System.out.println("Post-order Traversal: ");
        Tree_Traversal_R.postOrder(root);
    }
}