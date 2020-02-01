/**
 * Создание сущности(таблицы) ребенок со связями
 * ребенок М:М родитель
 * ребенок М:1 учебное заведение
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "children")

public class Children implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int child_id;

    @Column(name = "eb_id", insertable = false, updatable = false)
    private int eb_id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "age")
    private int age;

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(name = "parents_has_children",
            joinColumns = { @JoinColumn(name = "idChild") },
            inverseJoinColumns = { @JoinColumn(name = "idParent") })
    private List<Parents> parents = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "eb_id")
    private EducateBuilding educateBuilding;

    public Children(String first_name, String last_name, Integer age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }


    public Children(){};

    public int getId() {
        return child_id;
    }

    public void setId(int id) {
        this.child_id = id;
    }

    public int getEb_id() {
        return eb_id;
    }

    public void setEb_id(int eb_id) {
        this.eb_id = eb_id;
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

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public EducateBuilding getEducateBuilding() {
        return educateBuilding;
    }

    public void setEducateBuilding(EducateBuilding educateBuilding) {
        this.educateBuilding = educateBuilding;
    }

    @Override
    public String toString(){
        return "{id : " + child_id + "} {first_name : " + first_name + "} {last_name : " + last_name + "} {age : " + age + "}\n";
    }
}