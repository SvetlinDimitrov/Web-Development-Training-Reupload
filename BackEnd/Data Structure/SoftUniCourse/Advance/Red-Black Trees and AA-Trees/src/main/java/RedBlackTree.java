import java.util.Comparator;
import java.util.function.Consumer;

public class RedBlackTree<T extends Comparable<T>> {
    private final static boolean RED = true;
    private Node<T> root;

    public RedBlackTree() {
    }

    private RedBlackTree(Node<T> node) {
        this.preOrderCopy(node);
    }

    private void preOrderCopy(Node<T> node) {
        if (node == null) {
            return;
        }

        this.insert(node.value);
        this.preOrderCopy(node.left);
        this.preOrderCopy(node.right);
    }

    public int getNodesCount() {
        return this.getNodesCount(this.root);
    }

    private int getNodesCount(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return node.count;
    }

    // TODO:
    //  Insert using iteration over the nodes
    //  You can make a recursive one it is up to you
    //  The difference is that the recursive call should
    //  return Node
    public void insert(T value) {
        this.root = insert(value , root);
        this.root.color = false;
    }
    private Node<T> insert (T value , Node<T> node){
        if(node == null){
            return new Node<>(value);
        }

        if(node.value.compareTo(value) > 0){
            node.left = insert(value , node.left);
        }else if(node.value.compareTo(value) < 0){
            node.right = insert(value , node.right);
        }else{
            return node;
        }

        if(isRed(node.right) && !isRed(node.left)){
            node = RotateLeft(node);
        }
        if(isRed(node.left) && isRed(node.left.left)){
            node = RotateRight(node);
        }
        if(isRed(node.left) && isRed(node.right)){
            changeColor(node);
        }

        return node;

    }

    private void changeColor(Node<T> node) {
        node.left.color = false;
        node.right.color = false;
        node.color = RED;


        node.left.count = getNodesCount(node.left.left) + getNodesCount(node.left.right) +1;
        node.right.count = getNodesCount(node.right.left) + getNodesCount(node.right.right) +1;
        node.count = getNodesCount(node.left) + getNodesCount(node.right) +1;
    }

    private Node<T> RotateRight(Node<T> node) {
        Node<T> newNode = node.left;
        node.left = node.right;
        newNode.right = node;

        newNode.color = false;
        node.color = RED;

        node.count = getNodesCount(node.left) + getNodesCount(node.right) +1;
        newNode.count = getNodesCount(newNode.left) + getNodesCount(newNode.right) +1;

        return newNode;
    }

    private Node<T> RotateLeft(Node<T> node) {
        Node<T> newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;

        node.color = RED;
        newNode.color = false;

        node.count = getNodesCount(node.left) + getNodesCount(node.right) +1;
        newNode.count = getNodesCount(newNode.left) + getNodesCount(newNode.right) +1;

        return newNode;
    }

    private boolean isRed(Node<T> node) {
        if(node == null){
            return false;
        }

        return node.color;
    }

    public boolean contains(T value) {
        return this.findElement(value) != null;
    }

    public RedBlackTree<T> search(T item) {
        return new RedBlackTree<>(this.findElement(item));
    }

    private Node<T> findElement(T item) {
        Node<T> current = this.root;
        while (current != null) {
            if (item.compareTo(current.value) < 0) {
                current = current.left;
            } else if (item.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                break;
            }
        }
        return current;
    }

    public void eachInOrder(Consumer<T> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.left, consumer);
        consumer.accept(node.value);
        this.eachInOrder(node.right, consumer);
    }

    public static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;
        private boolean color;
        private int count;

        public Node(T value) {
            this.value = value;
            this.color = RED;
            this.count = 1;
        }
    }
}

