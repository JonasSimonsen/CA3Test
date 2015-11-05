package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jonas Simonsen
 */
@NamedQueries({
    @NamedQuery(name = "CurrencyRates.findAll", query = "SELECT q FROM CurrencyRates q"),
    @NamedQuery(name = "CurrencyRates.findByDesc", query = "SELECT q.rate FROM CurrencyRates q WHERE q.code = :code")})
@Entity
public class CurrencyRates implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String code;
    private String description;
    private Double rate;
    private String date;

    public CurrencyRates() {
    }

    public CurrencyRates(String code, String description, Double rate, String date) {
        this.code = code;
        this.description = description;
        this.rate = rate;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}