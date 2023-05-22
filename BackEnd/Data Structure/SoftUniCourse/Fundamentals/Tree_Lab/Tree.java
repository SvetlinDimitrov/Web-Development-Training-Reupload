package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {
    private E element;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E element, Tree<E>... child) {
        this.element = element;
        children = new ArrayList<>();

        for (Tree<E> tree : child) {
            children.add(tree);
            tree.parent = this;
        }
    }

    @Override
    public List<E> orderBfs() {
        List<E> toReturn = new ArrayList<>();
        ArrayDeque<Tree<E>> queTree = new ArrayDeque<>();
        queTree.offer(this);

        while (!queTree.isEmpty()){
           Tree<E> parent = queTree.poll();
           toReturn.add(parent.element);
           List<Tree<E>> child = parent.children;
            for (Tree<E> tree : child) {
                queTree.offer(tree);
            }
        }
        return toReturn;
    }

    @Override
    public List<E> orderDfs() {
        List<E> toReturn  = new ArrayList<>();
        deepSearch(this , toReturn);
        return toReturn;
    }

    private void deepSearch(Tree<E> tree, List<E> toReturn) {
        for (Tree<E> child : tree.children) {
            deepSearch(child , toReturn);
        }
        toReturn.add(tree.element);
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
//        deepSearchAdd(this , parentKey , child);
        ArrayDeque<Tree<E>> que = new ArrayDeque<>();
        que.offer(this);

        while (!que.isEmpty()){
            Tree<E> parent = que.poll();
            if(parent.element.equals(parentKey)){
                parent.children.add(child);
                child.parent = parent;
                return;
            }
            for (Tree<E> tree : parent.children) {
                que.offer(tree);
            }

        }
    }

//    private void deepSearchAdd(Tree<E> tree, E parentKey, Tree<E> child) {
//        for (Tree<E> children : tree.children) {
//            deepSearchAdd(children , parentKey , child);
//        }
//        if(tree.element.equals(parentKey)){
//            tree.children.add(child);
//        }
//    }

    @Override
    public void removeNode(E nodeKey) {
        Tree<E> Remove = null;
//        Tree<E> toRemove  = deepScanToRemove(this,nodeKey);
//        if(toRemove != null){
//            toRemove.children.clear();
//            Tree<E> leader = toRemove.parent;
//            leader.children.remove(toRemove);
//        }
        ArrayDeque<Tree<E>> que = new ArrayDeque<>();
        que.offer(this);


        while (!que.isEmpty()){
            Tree<E> parent = que.poll();

            if(parent.element.equals(nodeKey)){
                Remove = parent;
            }

            for (Tree<E> child : parent.children) {
                que.offer(child);
            }
        }
        if(Remove != null){
            Remove.children.clear();
            Tree<E> Leader = Remove.parent;
            Leader.children.remove(Remove);
        }else{
            throw new IllegalArgumentException();
        }
    }

    private Tree<E> deepScanToRemove(Tree<E> tree, E nodeKey) {
        Tree<E>treeToReturn = null;
        for (Tree<E> child : tree.children) {
            deepScanToRemove(child , nodeKey);
        }

        if(tree.element.equals(nodeKey)){
            treeToReturn = tree;
            return treeToReturn;
        }
            return null;
    }

    @Override
    public void swap(E firstKey, E secondKey) {
        ArrayDeque<Tree<E>> que = new ArrayDeque<>();
        Tree<E> one = null;
        Tree<E> two = null;
        que.offer(this);

        while(!que.isEmpty()){
            Tree<E> parent = que.poll();
            if(parent.element.equals(firstKey)){
                one = parent;
                one.children = parent.children;
            }

            if(parent.element.equals(secondKey)){
                two = parent;
                two.children = parent.children;
            }
            for (Tree<E> child : parent.children) {
                que.offer(child);
            }
        }

        Tree<E> parentOne = one.parent;
        Tree<E> parentTwo = two.parent;

        if(parentOne == null){
            this.element = two.element;
            two.parent = null;
            this.children = two.children;
            return;

        }else if (parentTwo == null){
            this.element = one.element;
            one.parent = null;
            this.children = one.children;
            return;
        }
        one.parent = parentTwo;
        two.parent = parentOne;

        int firstIndex = parentOne.children.indexOf(one);
        int secondIndex = parentTwo.children.indexOf(two);

        parentOne.children.set(firstIndex , two);
        parentTwo.children.set(secondIndex,one);

    }
}



