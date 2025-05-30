package Tree;

public class AddNode<E extends Comparable<E>> {
    private class TreeNode {
        public E e;
        public TreeNode left, right;

        public TreeNode(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;
    private int size;

    public AddNode() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //add element
    public void add(E e) {
        root = add(root, e);
    }

    public TreeNode add(TreeNode root, E e){
        if(root == null) {
            size++;
            return new TreeNode(e);
        }

        if(e.compareTo(root.e) < 0) {
            root.left = add(root.left, e);
        } else if(e.compareTo(root.e) > 0) {
            root.right = add(root.right, e);
        }
        return root;
    }



}
