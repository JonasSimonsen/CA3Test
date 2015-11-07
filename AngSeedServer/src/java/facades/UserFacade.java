package facades;

import deploy.DeploymentConfiguration;
import entity.User;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import security.PasswordHash;

public class UserFacade {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);

    public UserFacade() {

    }

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public User saveUser(User user) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return em.find(User.class, user.getUserName());
        } finally {
            em.close();
        }
    }

    public User deleteUser(String username) {
        EntityManager em = getEntityManager();
        try {
            User p = em.find(User.class, username);
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    public User getUserByUserId(String userName) {
        EntityManager em = getEntityManager();
        return em.find(User.class, userName);
    }
    /*
     Return the Roles if users could be authenticated, otherwise null
     */

    public List<String> authenticateUser(String userName, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        User user = getUserByUserId(userName);
        //Compares password to the hashed version
        return user != null && PasswordHash.validatePassword(password, user.getPassword()) ? user.getRoles() : null;
    }

    public List<User> getAllUsers() { //finished
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<User> q = em.createQuery("select p from User p", User.class);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
