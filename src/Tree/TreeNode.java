package Tree;

//node related
public class TreeNode<E> {
    public E e;
    public TreeNode<E> left, right;

    //constructor
    public TreeNode(E e) {
        this.e = e;
        this.left = null;
        this.right = null;
    }

    //constructor without parameter
    public TreeNode(){
        this(null);
    }
}
