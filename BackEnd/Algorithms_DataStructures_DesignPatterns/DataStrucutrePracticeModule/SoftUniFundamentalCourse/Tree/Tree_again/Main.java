import implementations.Tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>( 1, new Tree<Integer>(2),
        new Tree<>(3 , new Tree<>(5)));
        System.out.println();
        tree.addChild(2 , new Tree<>(4));
        tree.addChild(2, new Tree<>(6));
        tree.swap(1 ,5 );
        tree.orderBfs().forEach(e->System.out.println(e));
    }
}
