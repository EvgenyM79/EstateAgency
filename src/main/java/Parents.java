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
@Table(name = "parents")

public class Parents implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parent_id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_Name", nullable = false)
    private String last_name;

    @Column(name = "age", nullable = false)
    private int age;

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(name = "parents_has_children",
            joinColumns = { @JoinColumn(name = "idParent") },
            inverseJoinColumns = { @JoinColumn(name = "idChild") })
    private List<Children> children = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "passport_id", nullable = false)
    private Passport passport;

    public Parents(String first_name, String last_name, Integer age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public Parents(){};

    public int getId() {
        return parent_id;
    }

    public void setId(int id) {
        this.parent_id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //public Set<Children> getChild() {
    public List<Children> getChildren() {
        return children;
    }
    //public void setChild(Set<Children> children ) {
    public void setChild(List<Children> children ) {
        this.children = children;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString(){
        return "{id : " + parent_id + "} {fist_name : " + first_name + "} {last_name : " + last_name + "} {age : " + age + "}\n";
    }
}