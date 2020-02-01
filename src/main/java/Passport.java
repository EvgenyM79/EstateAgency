/**
 * Создание сущности(таблицы) паспорт со связями
 * паспорт 1:1 родитель
 * Используется вложенная сущность ОбластьУлица
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "passport", uniqueConstraints = {@UniqueConstraint(columnNames = {"ser_passport", "n_passport"})})
public class Passport implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passport_id;

    @Column(name = "ser_passport", nullable = false)
    private String ser_passport;

    @Column(name = "n_passport", nullable = false)
    private Integer n_passport;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "n_building", nullable = false)
    private int n_building;

    @Column(name = "n_room")
    private int n_room;

    public Passport(){}

    public Passport(String ser_passport, int n_passport, String street, int n_building, int n_room) {
        this.ser_passport = ser_passport;
        this.n_passport = n_passport;
        this.street = street;
        this.n_building = n_building;
        this.n_room = n_room;
    }

    public int getPassport_id() {
        return passport_id;
    }

    public void setPassport_id(int passport_id) {
        this.passport_id = passport_id;
    }

    public String getSer_passport() {
        return ser_passport;
    }

    public void setSer_passport(String ser_passport) {
        this.ser_passport = ser_passport;
    }

    public Integer getN_passport() {
        return n_passport;
    }

    public void setN_passport(Integer n_passport) {
        this.n_passport = n_passport;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getN_building() {
        return n_building;
    }

    public void setN_building(int n_building) {
        this.n_building = n_building;
    }

    public int getN_room() {
        return n_room;
    }

    public void setN_room(int n_room) {
        this.n_room = n_room;
    }

    @Override
    public String toString(){
        return "{id : " + passport_id + "} {ser passport : " + ser_passport + "} {n passport : " + n_passport + "}{street : " + street + "}{n building : " + n_building + "}{n room : " + n_room + "}\n";
    }

}