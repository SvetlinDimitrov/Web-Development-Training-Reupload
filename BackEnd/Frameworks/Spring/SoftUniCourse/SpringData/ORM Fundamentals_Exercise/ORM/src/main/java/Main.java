import entity.Cat;

public class Main {
    public static void main(String[] args) throws Exception {

        EntityManager<Cat> catEntityManager = new EntityManager<>();
//        catEntityManager.doCreate(Cat.class);
//        catEntityManager.alterTable(Cat.class);
        catEntityManager.deleteTable(Cat.class);
//        Cat catToInsert = new Cat("Gosho", 12);
//        catEntityManager.persist(catToInsert);


    }
}
