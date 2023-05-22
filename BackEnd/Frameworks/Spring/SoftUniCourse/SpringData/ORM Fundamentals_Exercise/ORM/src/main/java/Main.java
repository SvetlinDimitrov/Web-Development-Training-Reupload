
public class Main {
    public static void main(String[] args) throws Exception {

        EntityManager<Cat> catEntityManager = new EntityManager<>();
        catEntityManager.doCreate(Cat.class);
    }
}
