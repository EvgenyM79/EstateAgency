/**
 * Создание сущности(таблицы) Клиент со связями
 * родитель М:М ребенок
 * родитель 1:1 паспорт *
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clients")

public class Clients implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int client_id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_Name")
    private String last_name;

    @Column(name = "address")
    private String address;

    @Column(name = "telophonN")
    private String telophonN;

    @Column(name = "email")
    private String email;

    public Clients(){};

    public Clients(String first_name, String last_name, String address, String telophonN, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.telophonN = telophonN;
        this.email = email;
    }

    public int getId() {
        return client_id;
    }

    public void setId(int id) {
        this.client_id = id;
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
        return address;
    }

    public void setPosition(String position) {
        this.address = position;
    }

    public String getLogin() {
        return telophonN;
    }

    public void setLogin(String login) {
        this.telophonN = login;
    }

    public String getPassword() {
        return email;
    }

    public void setPassword(String password) {
        this.email = password;
    }

    @Override
    public String toString(){
        return "{id : " + client_id + "} {fist_name : " + first_name + "} {last_name : " + last_name + "} {position : " + address + "} {login : " + telophonN + "} {password : " + email + "}\n";
    }
}