/**
 * Создание сущности(таблицы) Контракты со связями
 * родитель М:М ребенок
 * родитель 1:1 паспорт *
 */

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Table(name = "contracts")

public class Contracts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contract_id;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "cost", nullable = false)
    private Integer cost;

    @Temporal(TemporalType.DATE)
    private Date date_conclusion;

    public Contracts(String status, Integer cost, Date date_conclusion) {
        this.status = status;
        this.cost = cost;
        this.date_conclusion = date_conclusion;
    }

    public Contracts(){};

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Date getDate_conclusion() {
        return date_conclusion;
    }

    public void setDate_conclusion(Date date_conclusion) {
        this.date_conclusion = date_conclusion;
    }

    @Override
    public String toString(){
        return "{id : " + contract_id + "} {status : " + status + "} {cost : " + cost + "} {date_conclusion : " + date_conclusion + "\n";
    }
}