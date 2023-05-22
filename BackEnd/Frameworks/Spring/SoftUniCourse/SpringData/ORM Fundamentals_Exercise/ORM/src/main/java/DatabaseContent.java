public interface DatabaseContent <E> {
    boolean persist(E entity) throws Exception;
    Iterable<E> find (Class<E> table) throws Exception;
    Iterable<E> find(Class<E> table,String where) throws Exception;

    E findFirst (Class<E> table) throws Exception;
    E findFirst(Class<E> table,String where) throws Exception;
    void doCreate(Class<E> entityClass) throws Exception;
    void alterTable(E entity) throws Exception;
}
