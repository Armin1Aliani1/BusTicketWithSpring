package base;

import java.util.List;

public interface BaseRepository<E> {
    int save(E e);

    void update(E e);

    void delete(E e);

    void deleteById(int id);

    E findById(int id);

    List<E> findAll();

    Class<E> getEntityClass();
}
