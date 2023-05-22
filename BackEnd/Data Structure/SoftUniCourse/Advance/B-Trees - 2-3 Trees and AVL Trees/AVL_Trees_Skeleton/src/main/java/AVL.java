import java.util.function.Consumer;

public class AVL<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> getRoot() {
        return this.root;
    }

    public boolean contains(T item) {
        Node<T> node = this.search(this.root, item);
        return node != null;
    }

    public void insert(T item) {
        this.root = insert(root, item);


    }

    public void eachInOrder(Consumer<T> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node<T> node, Consumer<T> action) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.left, action);
        action.accept(node.value);
        this.eachInOrder(node.right, action);
    }

    private Node<T> insert(Node<T> node, T item) {
        if (node == null) {
            return new Node<>(item);
        }

        int cmp = item.compareTo(node.value);
        if (cmp < 0) {
            node.left = insert(node.left, item);
        } else if (cmp > 0) {
            node.right = insert(node.right, item);
        }
        UpdHeight(node);
        int result = height(node.left) - height(node.right);
        if(result > 1){

            result = height(node.left.left) - height(node.left.right);
            if(result < 0){
                node.left = SelfBalanceLeft(node.left);
            }

            node = SelfBalanceRight(node);
        }else if (result < -1){

            result = height(node.right.left) - height(node.right.right);
            if(result > 0){
                node.right = SelfBalanceRight(node.right);
            }

           node =  SelfBalanceLeft(node);
        }

        return node;
    }

    private Node<T> SelfBalanceLeft(Node<T> node) {
       Node<T> helper = node;
       node = node.right;
       helper.right = node.left;
       node.left = helper;

       UpdHeight(helper);
       UpdHeight(node);

       return node;
    }

    private Node<T> SelfBalanceRight(Node<T> node) {
        Node<T> Helper = node;
        node = node.left;
        Helper.left = node.right;
        node.right = Helper;

        UpdHeight(Helper);
        UpdHeight(node);

        return  node;

    }

    private int UpdHeight(Node<T> root) {
        return root.height = Math.max(height(root.left) , height(root.right)) +1;
    }
    private int height(Node<T> node){
        if(node == null){
            return 0;
        }else{
            return node.height;
        }
    }



    private Node<T> search(Node<T> node, T item) {
        if (node == null) {
            return null;
        }

        int cmp = item.compareTo(node.value);
        if (cmp < 0) {
            return search(node.left, item);
        } else if (cmp > 0) {
            return search(node.right, item);
        }

        return node;
    }

}
