//package entity;
//
//import java.io.Serializable;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "currency")
//@NamedQueries({
//    @NamedQuery(name = "CurrencyEntity.findByCode", query = "SELECT i FROM CurrencyEntity i WHERE i.code = :code"),
//    @NamedQuery(name = "CurrencyEntity.findAll", query = "SELECT i FROM CurrencyEntity i ORDER BY i.id DESC"),
//})
//public class Currency implements Serializable {
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String code;
//    private String description;
//    private String dates;
//
//    public String getDate() {
//        return dates;
//    }
//
//    public void setDate(String date) {
//        this.dates = date;
//    }
//    
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public double getRate() {
//        return rate;
//    }
//
//    public void setRate(double rate) {
//        this.rate = rate;
//    }
//    private double rate;
//
//    public Currency() {
//
//    }
//}