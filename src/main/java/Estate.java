/**
 * Создание сущности(таблицы) Контракты со связями
 * родитель М:М ребенок
 * родитель 1:1 паспорт *
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "estate")

public class Estate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int estate_id;

    @Column(name = "type_estate", nullable = false)
    private String type_estate;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "cost", nullable = false)
    private Integer cost;

    @Column(name = "specification", nullable = false)
    private String specification;


    public Estate(String type_estate, String address, Integer cost, String specification) {
        this.type_estate = type_estate;
        this.address = address;
        this.cost = cost;
        this.specification = specification;
    }

    public Estate(){};

    public int getEstate_id() {
        return estate_id;
    }

    public void setEstate_id(int estate_id) {
        this.estate_id = estate_id;
    }

    public String getType_estate() {
        return type_estate;
    }

    public void setType_estate(String type_estate) {
        this.type_estate = type_estate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString(){
        return "{id : " + estate_id + "} {address : " + address + "} {address : " + address + "} {cost : " + cost + "} {specification : " + specification + "\n";
    }
}