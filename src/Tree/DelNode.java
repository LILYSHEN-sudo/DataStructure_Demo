package Tree;

public class DelNode<E extends Comparable<E>> {
    private TreeNode<E> root;;
    private int size;

    public DelNode(){
        root = null;
        size = 0;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }

    public E minimum() {
        if(root == null) {
            throw new IllegalArgumentException("BST is empty");
        }
        TreeNode<E> minNode = minimum(root);
        return minNode.e;
    }
    private TreeNode<E> minimum(TreeNode<E> node) {
        if(node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    private TreeNode<E> removeMin(TreeNode<E> node) {
        if(node.left == null){
            TreeNode<E> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(TreeNode<E> node) {
        if(node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(28);
        TreeNode<Integer> node1 = new TreeNode<>(16);
        TreeNode<Integer> node2 = new TreeNode<>(30);
        TreeNode<Integer> node3 = new TreeNode<>(12);
        TreeNode<Integer> node4 = new TreeNode<>(22);
        TreeNode<Integer> node5 = new TreeNode<>(29);
        TreeNode<Integer> node6 = new TreeNode<>(42);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;


        DelNode<Integer> tree = new DelNode<>();
        tree.setRoot(root);

        System.out.println("Min: " + tree.minimum());
        tree.removeMin();
        System.out.println("After removing min:");
        tree.preOrder();

        System.out.println("Min: " + tree.minimum());
        tree.removeMin();
        System.out.println("After removing min:");
        tree.preOrder();
    }
}
