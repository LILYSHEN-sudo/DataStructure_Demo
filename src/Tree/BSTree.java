package Tree;

public class BSTree<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int size;

    public BSTree() {
        root = null;
        size = 0;
    }

    //1. add()
    public void add(E e) {
        root = add(root, e);
    }
    private TreeNode<E> add(TreeNode<E> node, E e) {
        if (node == null){
            size++;
            return new TreeNode<>(e);
        }
        if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if(e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    //2.
}
