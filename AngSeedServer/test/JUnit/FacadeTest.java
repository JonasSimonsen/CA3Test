/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import entity.CurrencyRates;
import entity.User;
import facades.CurrencyFacade;
import facades.UserFacade;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import security.PasswordHash;

/**
 *
 * @author Andreas
 */
public class FacadeTest {

    private UserFacade uf;
    private CurrencyFacade cf;
    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setup() {
        try {
            uf = new UserFacade();
            cf = new CurrencyFacade();
            emf = Persistence.createEntityManagerFactory("CA3PU");
            em = emf.createEntityManager();
            System.out.println("Setup running");
        } catch (Exception e) {
            System.out.println("Error in setup");
        }
    }

    @After
    public void teardown() {
        try {
            uf.deleteUser("Hans");
            uf.deleteUser("Andreas");
            uf.deleteUser("Bo");
            uf.deleteUser("Karl");

            System.out.println("Removing dummy user from DB");
            em.close();
        } catch (Exception e) {
            System.out.println("Error in closing entity manager");
        }
    }

    // USERFACADE TESTS
    @Test
    public void saveUserTest() {
        User u = new User("Hans", "123");
        u.AddRole("user");
        uf.saveUser(u);
        User u1 = em.find(User.class, "Hans");
        assertEquals(u.getUserName(), u1.getUserName());

    }

    @Test
    public void deleteUserTest() {
        User u = new User("Hans", "123");
        u.AddRole("user");
        //Saving Hans
        uf.saveUser(u);
        //Deleting Hans
        uf.deleteUser(u.getUserName());
        //Is hans there?
        User u1 = em.find(User.class, "Hans");
        //I don't think so :(
        assertEquals(null, u1);
    }

    @Test
    public void getUserByIdTest() {
        User u = new User("Hans", "123");
        u.AddRole("user");
        uf.saveUser(u);
        User u1 = uf.getUserByUserId("Hans");
        assertEquals(u.getUserName(), u1.getUserName());
    }

    @Test
    public void authenticateUserTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
        //Create new user
        User u = new User("Hans", PasswordHash.createHash("123"));
        u.AddRole("user");
        uf.saveUser(u);
        //Authenticating user returns List of user roles
        List<String> hansRoles = uf.authenticateUser("Hans", "123");
        //Creating user to compare
        User u1 = new User("Bo", "123");
        u1.AddRole("user");
        System.out.println(hansRoles);
        //Compare u1 roles to the Authenticated list
        assertEquals(u1.getRoles(), hansRoles);
    }

    @Test
    public void getAllUsersTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
        //Initiliazing 2 users
        User u = new User("Hans", "123");
        User u1 = new User("Andreas", "123");
        u.AddRole("user");
        u1.AddRole("user");
        //Saving users to Database
        uf.saveUser(u);
        uf.saveUser(u1);
        //Creating ArrayList from users in DB
        List<User> DBList = uf.getAllUsers();
        //Manually adding user to a testList
        List<User> testList = new ArrayList();
        testList.add(u);
        testList.add(u1);
        //Entity goes through changes when it gets inserted into the Database, but keeps all the property values.
        //Therefore you can't directly compare the Lists to eachother, since you'd be comparing the containing entity
        assertEquals(testList.contains(u.getUserName() + testList.contains(u1.getUserName())), DBList.contains(u.getUserName()) & DBList.contains(u1.getUserName()));
    }

    //CURRENCYFACADE TESTS
    @Test
    public void addCurrenciesToDBTest() {
        //Creating 2 Currency entities
        double d = 1337;
        CurrencyRates c = new CurrencyRates("A", "TestA", d, "05-11-2015");
        CurrencyRates c1 = new CurrencyRates("B", "TestB", d, "05-11-2015");
        //Initializing CurrencyList and adding entities
        List<CurrencyRates> CurrencyList = new ArrayList();
        CurrencyList.add(c);
        CurrencyList.add(c1);
        //Adding CurrencyList to Database
        cf.addCurrenciesToDB(CurrencyList);
        //Creating a currency entity equal to entity in Database
        CurrencyRates testCurrency = em.find(CurrencyRates.class, c.getId());
        //Comparing the 2 entities
        assertEquals(c.getDescription(), testCurrency.getDescription());
    }

    @Test
    public void getAllCurrenciesFromDBTest() {
        //Creating 2 Currency entities
        double d = 1337;
        CurrencyRates c = new CurrencyRates("A", "TestA", d, "05-11-2015");
        CurrencyRates c1 = new CurrencyRates("B", "TestB", d, "05-11-2015");
        //Initializing CurrencyList and adding entities
        List<CurrencyRates> CurrencyList = new ArrayList();
        CurrencyList.add(c);
        CurrencyList.add(c1);
        //Adding CurrencyList to Database
        cf.addCurrenciesToDB(CurrencyList);
        //Initializing a List and adding Currency entities from Database
        List<CurrencyRates> CurrencyFromDB = cf.getCurrencies();
        //Initializing a Test List to hold the 2 entities
        List<CurrencyRates> CurrencyTestList = new ArrayList();
        CurrencyTestList.add(c);
        CurrencyTestList.add(c1);
        //Comparing list from Database to Test List
        assertEquals(CurrencyTestList.contains(c.getDescription()) & CurrencyTestList.contains(c1.getDescription()), CurrencyFromDB.contains(c.getDescription()) & CurrencyFromDB.contains(c1.getDescription()));
    }

    @Test
    public void calculateCurrenciesTest() {
        double d = 1337;
        double amount = 1337;

        //Creating testResult from facade method
        double testResult = cf.calculateCurrencies(amount, em.find(CurrencyRates.class, 1).getCode(), em.find(CurrencyRates.class, 2).getCode());
        //Creating actualResult with math
        double actualResult = em.find(CurrencyRates.class, 1).getRate() / em.find(CurrencyRates.class, 2).getRate() * amount;
        //Appearently there's a 3rd value in assertEquals when it comes to floating point numbers
        assertEquals(testResult, actualResult, 1e-8);

    }
}
