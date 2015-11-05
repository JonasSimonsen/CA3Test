package facades;


import entity.CurrencyRates;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class CurrencyFacade {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA3PU");
    private EntityManager em = emf.createEntityManager();
    
    public void addCurrenciesToDB(List<CurrencyRates> currencyRates) {
        em.getTransaction().begin();
        for (CurrencyRates currencyRate : currencyRates) {
            em.persist(currencyRate);
        }
        em.getTransaction().commit();      
    }
    
    public List<CurrencyRates> getCurrencies() {
        Query query = em.createNamedQuery("CurrencyRates.findAll");
        return query.getResultList();
    }
    
    public Double calculateCurrencies(Double amount, String firstCur, String secondCur) {
        Double firstRate;
        Double secondRate;
        
        Query query = em.createNamedQuery("CurrencyRates.findByDesc");
        query.setParameter("code", firstCur);
        
        firstRate = (Double) query.getResultList().get(0);
        query.setParameter("code", secondCur);
        secondRate = (Double) query.getResultList().get(0);
        
        return (firstRate/secondRate)*amount;
    }
    

}