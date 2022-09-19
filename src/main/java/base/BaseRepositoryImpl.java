package base;


import javax.persistence.EntityManager;
import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseEntity> implements BaseRepository<E> {
    public BaseRepositoryImpl(){
        template = null;
    }
    protected final EntityManager template;

    @Override
    public void save(E e) {
        template.persist(e);
    }

    @Override
    public E update(E e) {
        return template.merge(e);
    }

    @Override
    public void delete(E e) {
        template.remove(e);
    }

    @Override
    public void deleteById(int id) {
        template.createQuery("delete from " + getEntityClass().getSimpleName() + " e where e.id =: id", getEntityClass())
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public E findById(int id) {
        return template.find(getEntityClass(), id);
    }

    @Override
    public List<E> findAll() {
        return template.createQuery("from " + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
    }

    @Override
    public void beginTransAction() {
        if(!template.getTransaction().isActive()){
            template.getTransaction().begin();
        }
    }

    @Override
    public void commitTransAction() {
        if(template.getTransaction().isActive()){
            template.getTransaction().commit();
        }
    }
}
