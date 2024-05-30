package web.AppWithSpringBoot.dao;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import web.AppWithSpringBoot.model.User;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User showUserId(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User updatedUser) {
        em.merge(updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }
}
