package Set_Map;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
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

    //add element into BST
    public void add(E e) {
        root = add(root, e);
    }
    private Node add(Node node, E e) {
        if(node == null) {
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if(e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    //contains in BST
    public boolean contains(E e) {
        return contains(root, e);
    }
    private boolean contains(Node node, E e) {
        if(node == null) {
            return false;
        }
        if(e.compareTo(node.e) == 0) {
            return true;
        }else if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }else { //e.compareTo(root.e) > 0
            return contains(node.right, e);
        }
    }

    //PreOrder
    //Method-1 Recursion
    public void preOrder() {
        preOrder(root);
    }
    public void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    //Method-2 Non-Recursion
    public void preOrderNR() {
        preOrderNR(root);
    }
    private void preOrderNR(Node node) {
        if(node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //InOrder
    //Method-1 Recursion
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
    //Method-2 Non-Recursion


    //PostOrder
    //Method-1 Recursion
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
    //Method-2 Non-Recursion


    //LevelOrder
    public void levelOrder() {
        levelOrder(root);
    }
    public void levelOrder(Node node) {
        if(node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    //search the minimum element in the BST
    public E minimum() {
        if(size ==0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node res = minimum(root);
        return res.e;
    }
    private Node minimum(Node node) {
        if(node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //search the maximum element in the BST
    public E maximum() {
        if(size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node res = maximum(root);
        return res.e;
    }
    private Node maximum(Node node) {
        if(node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    //Delete the minimum element and return the value
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    private Node removeMin(Node node) {
        //树只有右边节点的情况，最小值是root本身
        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //Delete the maximum element and return the value
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

    //Delete element in BST
    public void remove(E e) {
        root = remove(root, e);
    }
    private Node remove(Node node, E e) {
        if(node == null) {
            return null;
        }
        if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { //e.compareTo(node.e) == 0
            //if node.left == null
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //if node.right == null
            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //if node.left != null && node.right != null
            //找到比待删节点大的最小节点，即右子树的最小节点，用其顶替待删节点的位置
            Node temp = minimum(node.right);
            temp.right = removeMin(node.right);
            temp.left = node.left;
            node.left = node.right = null;
            return temp;
        }
    }

//    @Override
//    public String toString(){
//        StringBuilder res = new StringBuilder();
//        generateBSTString(root, 0, res);
//        return res.toString();
//    }

//    // 生成以node为根节点，深度为depth的描述二叉树的字符串
//    private void generateBSTString(Node node, int depth, StringBuilder res){
//        if(node == null){
//            res.append(generateDepthString(depth) + "null\n");
//            return;
//        }
//        res.append(generateDepthString(depth) + node.e + "\n");
//        generateBSTString(node.left, depth + 1, res);
//        generateBSTString(node.right, depth + 1, res);
//    }
//    private String generateDepthString(int depth){
//        StringBuilder res = new StringBuilder();
//        for(int i = 0 ; i < depth ; i ++)
//            res.append("--");
//        return res.toString();
//    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for(int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();  //5 3 2 4 6 8
        bst.preOrderNR();
        System.out.println();
        bst.inOrder();
        System.out.println();  //2 3 4 5 6 8
        bst.postOrder();
        System.out.println();  //2 4 3 8 6 5
        bst.levelOrder();
        System.out.println();  //5 3 6 2 4 8
    }
    /////////////////
    //      5      //
    //    /   \    //
    //   3    6    //
    //  / \    \   //
    // 2  4     8  //
    /////////////////

//    public void add(E e) {
//        if(root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
//
//    }
//    public void add(Node node, E e) {
//        if(e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if(e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if(e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else {
//            add(node.right, e);
//        }
//    }
}
