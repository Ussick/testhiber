package ua.itea.component;

import ua.itea.model.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class UserEntityManager {
    private EntityManager em =
            Persistence.createEntityManagerFactory("market").createEntityManager();

    public UserEntity getUserById(int id) {
        return em.find(UserEntity.class, id);
    }

    public UserEntity insertUser(UserEntity user) {
        em.getTransaction().begin();
        UserEntity res = new UserEntity();
        try {
            em.persist(user);
            em.getTransaction().commit();
            res = user;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            if (em.isOpen()) {
                em.close();
            }
        }
        return res;
    }

    public String getUserByLogin(String login, String password) {
        String result = null;
        try {
            UserEntity user = (UserEntity) em.createNamedQuery("checkUser").setParameter("login", login)
                    .setParameter("password", password).getSingleResult();
            result = "Welcome back " + user.getName();
        } catch (Exception e) {
            e.printStackTrace();
            result = "Your login or password are not correct";
        } finally {
            return result;
        }
    }
}
