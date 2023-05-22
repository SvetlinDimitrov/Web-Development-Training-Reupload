package implementations;

import interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree<E> implements AbstractTree<E> {

    private Tree<E> parent ;
    private List<Tree<E>> children;
    private E value;

    public Tree(E value , Tree<E>...trees) {
       children = new ArrayList<>();
       this.value = value;
        for (Tree<E> tree : trees) {
            tree.parent = this;
            children.add(tree);
        }
    }

    @Override
    public List<E> orderBfs() {

        List<E> toReturn = new ArrayList<E>();
        ArrayDeque<Tree<E>> que = new ArrayDeque<>();
        que.offer(this);

        while(!que.isEmpty()){
            Tree<E> parent = que.poll();
            toReturn.add(parent.value);

            for (Tree<E> child : parent.children) {
                que.offer(child);
            }
        }
        return toReturn;
    }

    @Override
    public List<E> orderDfs() {
        List<E> toReturn = new ArrayList<E>();
        deepSearch(this , toReturn);
        return toReturn;
    }


    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> King = BFS(parentKey);

        if(null == King){
            throw new IllegalArgumentException();
        }

        child.parent = King;
        King.children.add(child);

    }


    @Override
    public void removeNode(E nodeKey) {
        Tree<E> nodeToRemove = BFS(nodeKey);

        if(null == nodeToRemove){
            throw new IllegalArgumentException();
        }else if (null == nodeToRemove.parent) {
            this.value = null;
            this.parent = null;
            this.children.clear();
        }else {
            Tree<E> parent = nodeToRemove.parent;
            nodeToRemove.children.clear();
            parent.children.remove(nodeToRemove);
        }

    }

    @Override
    public void swap(E firstKey, E secondKey) {

        Tree<E> firstSwap = BFS(firstKey);
        Tree<E> secondSwap = BFS(secondKey);

        if (null == firstSwap || null == secondSwap) {
            throw new IllegalArgumentException();
        } else {
            Tree<E> firstParent = firstSwap.parent;
            Tree<E> secondParent = secondSwap.parent;

            if(null == firstParent){
                this.value = secondSwap.value;
                this.children = secondSwap.children;
                this.parent = null;
                return;
            }else if(null == secondParent){
                this.value = firstSwap.value;
                this.children = firstSwap.children;
                this.parent =null;
            }

            firstSwap.parent = secondParent;
            secondSwap.parent = firstParent;

            int indexFirst = firstParent.children.indexOf(firstSwap);
            int indexSecond = secondParent.children.indexOf(secondSwap);

            firstParent.children.set(indexFirst , secondSwap);
            secondParent.children.set(indexSecond , firstSwap);
        }
    }
    private Tree<E> BFS(E key) {
        ArrayDeque<Tree<E>> que = new ArrayDeque<>();
        que.offer(this);

        while(!que.isEmpty()){
            Tree<E> parent = que.poll();
            if(parent.value.equals(key)){
                return parent;
            }
            for (Tree<E> child : parent.children) {
                que.offer(child);
            }
        }
        return null;
    }

    private void deepSearch(Tree<E> tree, List<E> list) {
        for (Tree<E> child : tree.children) {
            deepSearch(child , list);
        }
        list.add(tree.value);
    }
}



