package Tree;

public class Main {
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