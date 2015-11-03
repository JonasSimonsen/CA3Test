/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCreator;

import entity.User;
import facades.UserFacade;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.PasswordHash;

/**
 *
 * @author jonassimonsen
 */
public class DBCreator {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA3PU");
        EntityManager em = emf.createEntityManager();

        UserFacade uf = new UserFacade();
        User u = new User("user", PasswordHash.createHash("test"));
        
        u.AddRole("User");
        uf.saveUser(u);

        User a = new User("admin", PasswordHash.createHash("test"));
        
        a.AddRole("Admin");
        uf.saveUser(a);
    }
}