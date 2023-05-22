public class TwoThreeTree<K extends Comparable<K>> {
    private TreeNode<K> root;

    public static class TreeNode<K> {
        private K leftKey;
        private K rightKey;

        private TreeNode<K> leftChild;
        private TreeNode<K> middleChild;
        private TreeNode<K> rightChild;

        private TreeNode(K key) {
            this.leftKey = key;
        }

        boolean isThreeNode() {
            return rightKey != null;
        }

        boolean isTwoNode() {
            return rightKey == null;
        }

        boolean isLeaf() {
            return this.leftChild == null && this.middleChild == null && this.rightChild == null;
        }
    }


    public void insert(K key) {
        if (root == null) {
            root = new TreeNode<>(key);
        } else {
            TreeNode<K> helper = Insert(root, key);
            if (helper != null) {
                root = helper;
            }
        }
    }

    private TreeNode<K> Insert(TreeNode<K> root, K key) {
        if (root.isLeaf()) {
            if (root.isTwoNode()) {
                if (root.leftKey.compareTo(key) > 0) {
                    root.rightKey = root.leftKey;
                    root.leftKey = key;
                } else {
                    root.rightKey = key;
                }
                return null;
            } else {

                if (root.leftKey.compareTo(key) >= 0) {
                    TreeNode<K> toReturn = new TreeNode<>(root.leftKey);
                    toReturn.leftChild = new TreeNode<>(key);
                    toReturn.rightChild = new TreeNode<>(root.rightKey);
                    return toReturn;
                } else if (root.leftKey.compareTo(key) < 0 && root.rightKey.compareTo(key) > 0) {
                    TreeNode<K> toReturn = new TreeNode<>(key);
                    toReturn.leftChild = new TreeNode<>(root.leftKey);
                    toReturn.rightChild = new TreeNode<>(root.rightKey);
                    return toReturn;
                } else {
                    TreeNode<K> toReturn = new TreeNode<>(root.rightKey);
                    toReturn.leftChild = new TreeNode<>(root.leftKey);
                    toReturn.rightChild = new TreeNode<>(key);
                    return toReturn;
                }
            }
        }
        TreeNode<K> toReturn = null;
        if (root.isTwoNode()) {
            if (root.leftKey.compareTo(key) >= 0) {
                toReturn = Insert(root.leftChild, key);
            } else {
                toReturn = Insert(root.rightChild, key);
            }
        } else {
            if (root.leftKey.compareTo(key) >= 0) {
                toReturn = Insert(root.leftChild, key);
            } else if (root.leftKey.compareTo(key) < 0 && root.rightKey.compareTo(key) > 0) {
                toReturn = Insert(root.middleChild, key);
            } else {
                toReturn = Insert(root.rightChild, key);
            }
        }
        if (toReturn != null) {
            if (root.isTwoNode()) {
                if (root.leftKey.compareTo(toReturn.leftKey) >= 0) {
                    root.rightKey = root.leftKey;
                    root.leftKey = toReturn.leftKey;


                    root.leftChild = toReturn.leftChild;
                    root.middleChild = toReturn.rightChild;

                } else {
                    root.rightKey = toReturn.leftKey;
                    root.middleChild = toReturn.leftChild;
                    root.rightChild = toReturn.rightChild;
                }
                return null;
            } else {
                    TreeNode<K> newTree = null;
                if (root.rightKey.compareTo(toReturn.leftKey) <= 0) {
                    newTree = new TreeNode<>(root.rightKey);
                    TreeNode<K> left = new TreeNode<>(root.leftKey);
                    left.leftChild = root.leftChild;
                    left.rightChild = root.middleChild;
                    newTree.leftChild = left;
                    newTree.rightChild = toReturn;
                }else if (root.leftKey.compareTo(toReturn.leftKey) < 0 && root.rightKey.compareTo(toReturn.leftKey) > 0){
                    newTree = new TreeNode<>(toReturn.leftKey);
                    TreeNode<K> left = new TreeNode<>(root.leftKey);
                    left.leftChild = root.leftChild;
                    left.rightChild  = toReturn.leftChild;
                    TreeNode<K> right = new TreeNode<>(root.rightKey);
                    right.leftChild = toReturn.rightChild;
                    right.rightChild = root.rightChild;
                    newTree.leftChild = left;
                    newTree.rightChild = right;
                }else{
                    newTree = new TreeNode<>(root.leftKey);
                    TreeNode<K> right = new TreeNode<>(root.rightKey);
                    right.leftChild = root.middleChild;
                    right.rightChild = root.rightChild;
                    newTree.leftChild = toReturn;
                    newTree.rightChild = right;
                }
                toReturn = newTree;
                return toReturn;
            }
        }else{
            return null ;
        }
    }

    public String getAsString() {
        StringBuilder out = new StringBuilder();
        recursivePrint(this.root, out);
        return out.toString().trim();
    }

    private void recursivePrint(TreeNode<K> node, StringBuilder out) {
        if (node == null) {
            return;
        }
        if (node.leftKey != null) {
            out.append(node.leftKey)
                    .append(" ");
        }
        if (node.rightKey != null) {
            out.append(node.rightKey).append(System.lineSeparator());
        } else {
            out.append(System.lineSeparator());
        }
        if (node.isTwoNode()) {
            recursivePrint(node.leftChild, out);
            recursivePrint(node.rightChild, out);
        } else if (node.isThreeNode()) {
            recursivePrint(node.leftChild, out);
            recursivePrint(node.middleChild, out);
            recursivePrint(node.rightChild, out);
        }
    }
}
