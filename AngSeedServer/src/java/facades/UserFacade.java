package facades;

import entity.User;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.PasswordHash;

public class UserFacade {
private EntityManagerFactory emf;

    
    public UserFacade() {
        emf = Persistence.createEntityManagerFactory("CA3PU");
    }
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
        
    }

//    public UserFacade() {
//        //Test Users
//        emf = Persistence.createEntityManagerFactory("CA3PU");
//        EntityManager em = emf.createEntityManager();
//
//        UserEntity user = new UserEntity("user", "test");
//        user.AddRole("User");
//        users.put("user", user);
//
//        UserEntity admin = new UserEntity("admin", "test");
//        admin.AddRole("Admin");
//        
//
//        UserEntity both = new UserEntity("user_admin", "test");
//        both.AddRole("User");
//        both.AddRole("Admin");
//        users.put("user_admin", both);
//
//        em.getTransaction().begin();
//        em.persist(user);
//        em.persist(admin);
//        em.persist(both);
//        em.getTransaction().commit();
//    }

    public void createUser(String name, String password, String role) throws NoSuchAlgorithmException, InvalidKeySpecException {
        EntityManager em = getEntityManager();
        try {
            
            User user = new User();
            user.setUserName(name);
            user.setPassword(password);
            user.AddRole(role);
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit(); 
        } finally {
            em.close();
        }

    }

    public User getUserByUserId(String id) {
        EntityManager em = getEntityManager();
        return em.find(User.class, id);
    }

    public List<String> authenticateUser(String userName, String password) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, userName);
        return user != null && user.getPassword().equals(password) ? user.getRoles() : null;
    }

//    public UserEntity getUserByUsername(String username) {
//        EntityManager em = getEntityManager();
//        try {
//            Query query = em.createNamedQuery("CarEn.findByUsername").setParameter("username", username);
//            return (UserEntity) query.getSingleResult();
//        } finally {
//            em.close();
//        }
//    }

//    public void createUser() throws NoSuchAlgorithmException, InvalidKeySpecException {
//        EntityManager EM = getEntityManager();
//
//        try {
//            UserEntity user = new UserEntity("testuser", PasswordHash.createHash("test"));
//            EM.getTransaction().begin();
//            EM.persist(user);
//            EM.getTransaction().commit(); // Year and Date are not accepted into the database due to them being reserver MySQL keywords.
//        } finally {
//            EM.close();
//        }
//    }


  
}
