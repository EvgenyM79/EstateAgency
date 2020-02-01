/**
 * Создание вложенной сущности ОбластьУлица из двух полей: улица - область
 * Эта сущность будет вставлятся в таблицу с паспортами и учебными заведениями
 */

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class AreaStreet implements Serializable {

    @Column(name = "street", nullable = false, unique = true)
    private String street;

    @Column(name = "as_area", nullable = false)
    private String as_area;

    public AreaStreet() {
    }

    public AreaStreet(String street, String as_area) {
        this.street = street;
        this.as_area = as_area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAs_area() {
        return as_area;
    }

    public void setAs_area(String as_area) {
        this.as_area = as_area;
    }

    @Override
    public String toString(){
        return "{ street : " + street + "} {area : " + as_area + "}\n";
    }
}
