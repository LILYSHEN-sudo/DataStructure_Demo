package Tree;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;              //root
        public Node left;        //left node
        public Node right;       //right node

        //create constructor
        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //1. add()
    public void add(E e) {
        if(root == null) {
            root = new Node(e);
            size++;
        }else{
            add_1(root, e);
        }
    }

    //add the new element to BST, and do not return the Node
    private void add_1(Node node, E e) {
        if(e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if(e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        if(e.compareTo(node.e) < 0) {
            add(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            add(node.right, e);
        }
    }
    //improvement: add()
    //[recursion]add new element e to the BST with the root node, and return the root
    private Node add(Node node, E e) {
        if(node == null) {
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    //2. Search()
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if(node == null)  return false;

        if(e.compareTo(node.e) == 0) {
            return true;
        } else if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {  //e.compareTo(node.e) > 0
            return contains(node.right, e);
        }
    }

    //3. Traversal: preOrder()
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //3. Traversal: inOrder()
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //3. Traversal: postOrder()
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //3. [stack]Traversal: preOrder() Non-recursion method
    public void preOrderNR() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //4. [Queue]Traversal: levelOrder()
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left != null) {
                q.add(cur.left);
            }
            if(cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    //5. Minimum element in the BST
    public E minimum() {
        if(size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node minNode = minimum(root);
        return minNode.e;
    }
    private Node minimum(Node node) {
        if(node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //6. Maximum element in the BST
    public E maximum() {
        if(size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node maxNode = maximum(root);
        return maxNode.e;
    }
    private Node maximum(Node node) {
        if(node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    //7. Delete the minimum element in the BST
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    private Node removeMin(Node node) {
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //8. Delete the maximum element in the BST
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }
    private Node removeMax(Node node) {
        if(node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
     }

     //9. remove()
    public void remove(E e) {
        root = remove(root, e);
    }
    private Node remove(Node node, E e) {
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if(e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node suc = minimum(node.right);
            suc.right = removeMin(node.right);
            suc.left = node.left;
            node.left = node.right = null;
            return suc;
        }
    }

    //System method
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateString(root, 0 ,res);
        return res.toString();
    }

    private void generateString(Node node, int depth, StringBuilder res) {
        if(node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
}



























