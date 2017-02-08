package main.java.services.dao.interfaces;

public interface Dao<E> {

    void persist(E entity);
    
    void remove(E entity);
    
    E findById(Integer id);
}
