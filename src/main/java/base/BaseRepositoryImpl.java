package base;


import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseEntity> implements BaseRepository<E> {
    org.springframework.orm.hibernate3.HibernateTemplate template;

    public BaseRepositoryImpl(org.springframework.orm.hibernate3.HibernateTemplate hibernateTemplate) {
        this.template = template;
    }

    @Override
    public int save(E e) {
        return (int) template.save(e);
    }

    @Override
    public void update(E e) {
        template.update(e);
    }

    @Override
    public void delete(E e) {
        template.delete(e);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public E findById(int id) {
        return (E) template.get(getEntityClass(), id);
    }

    @Override
    public List<E> findAll() {
        return template.loadAll(getEntityClass());
    }

}
