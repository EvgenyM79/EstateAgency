/**
 * Создание сущности(таблицы) взрослый со связями
 * родитель М:М ребенок
 * родитель 1:1 паспорт *
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")

public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employee_id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_Name")
    private String last_name;

    @Column(name = "position")
    private String position;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public Employee(){};

    public Employee(String first_name, String last_name, String position, String login, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return employee_id;
    }

    public void setId(int id) {
        this.employee_id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastname) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "{id : " + employee_id + "} {fist_name : " + first_name + "} {last_name : " + last_name + "} {position : " + position + "} {login : " + login + "} {password : " + password + "}\n";
    }
}