package facades;


import entity.Currency;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.xml.sax.helpers.DefaultHandler;


public class CurrencyFacade extends DefaultHandler {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public List<Currency> getCurrenciesFromDB() {
        try {
            Query query = em.createNamedQuery("CurrencyEntity.findAll");
            return query.setMaxResults(1).getResultList();
        } finally {
            em.close();
        }
    }
    
    public void getCurrencyRates(List<Currency> curr) throws MalformedURLException, IOException {
        emf = Persistence.createEntityManagerFactory("CA3PU");
        em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            for(Currency ce : curr){
            em.persist(ce);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public double convertCurrency(double amount, String from, String to){
        Currency curFrom = getCurrency(from);
        Currency curTo = getCurrency(to);
        double amountTo = amount * curFrom.getRate() / curTo.getRate();
        return amountTo;
    }
    
    public Currency getCurrency(String curCode){
        try {
            Query query = em.createNamedQuery("CurrencyEntity.findByCode");
            query.setParameter("code", curCode);
            return (Currency) query.getSingleResult();
        } finally {
            em.close();
        }
    }
    
    
}