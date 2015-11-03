package facades;

import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserFacade
{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA3PU");

//  private final  Map<String, Users> users = new HashMap<>();

    public UserFacade()
    {
        //Test Users
//    Users user = new Users("user","test");
//    user.AddRole("Users");
//    users.put(user.getUserName(),user );
//    Users admin = new Users("admin","test");
//    admin.AddRole("Admin");
//    users.put(admin.getUserName(),admin);
//    
//    Users both = new Users("user_admin","test");
//    both.AddRole("Users");
//    both.AddRole("Admin");
//    users.put(both.getUserName(),both );
    }

    EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public User saveUser(User user)
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return em.find(User.class, user.getUserName());
        } finally
        {
            em.close();
        }
    }

    public User getUserByUserId(String userName)
    {
        EntityManager em = getEntityManager();
        return em.find(User.class, userName);
    }
    /*
     Return the Roles if users could be authenticated, otherwise null
     */

    public List<String> authenticateUser(String userName, String password)
    {
        User user = getUserByUserId(userName);
        return user != null && user.getPassword().equals(password) ? user.getRoles() : null;
    }

}