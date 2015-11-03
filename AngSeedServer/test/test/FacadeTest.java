/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import facades.UserFacade;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 *
 * @author Andreas
 */
public class FacadeTest {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        UserFacade uf = new UserFacade();
        uf.getEntityManager();
        uf.createUser("Andreas", "asd", "User");
        uf.createUser("Christian", "chris", "Admin");
        uf.createUser("Jonas","joe","admin_user");
        
        
    }
}
