package ir.maktab.project12.instagram.repositories;

import ir.maktab.project12.instagram.core.config.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.io.Serializable;
import java.util.List;


public abstract class CrudRepository<Entity, ID extends Serializable> {

    protected abstract Class<Entity> getEntityClass();

    private final Session session;

    public CrudRepository(Session session) {
        this.session = session;
    }

    public void save(Entity entity) {
        session.save(entity);
    }

    public void update(Entity entity) {
        session.update(entity);
    }

    public void remove(Entity entity) {
        session.remove(entity);
    }

    public void removeById(ID id) {
        Entity entity = findById(id);
        if (entity != null) {
            session.remove(entity);
        }
    }

    public Entity findById(ID id) {
        Entity entity = session.get(getEntityClass(), id);
        return entity;
    }

    public List<Entity> findAll() {
        Query<Entity> query = session
                .createQuery("from " + getEntityClass().getName(), getEntityClass());
        List<Entity> entities = query.list();

        return entities;
    }

    public List<Entity> findAll(int start, int row) {
        Query<Entity> query = session.createQuery("from " + getEntityClass().getName(), getEntityClass());
        query.setFirstResult(start);
        query.setMaxResults(row);
        List<Entity> entities = query.list();

        return entities;
    }

}
