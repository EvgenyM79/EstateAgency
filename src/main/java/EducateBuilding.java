/**
 * Создание сущности(таблицы) учебное заведение со связями
 * учебное заведение 1:М ребенок
 * ребенок М:1 учебное заведение
 * Используется вложенная сущность ОбластьУлица
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ebuilding")
public class EducateBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ebuilding_id;

    @Column(name = "eb_name", nullable = false, unique = true)
    private String eb_name;

    @Column(name = "eb_street", nullable = false)
    private String eb_street;

    @Column(name = "eb_n", nullable = false)
    private int eb_n;

    @OneToMany (mappedBy = "eb_id", fetch = FetchType.LAZY)
    private Set<Children> children = new HashSet<>();

    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "as_area", insertable = false, updatable = false, nullable = false)) })
    private AreaStreet areaStreet;

    public EducateBuilding(){}

    public EducateBuilding(String eb_name, String eb_street, int eb_n, AreaStreet areaStreet) {
        this.eb_name = eb_name;
        this.eb_street = eb_street;
        this.eb_n = eb_n;
        this.areaStreet = areaStreet;
    }

    public int getEb_id() {
        return ebuilding_id;
    }

    public void setEb_id(int ebuilding_id) {
        this.ebuilding_id = ebuilding_id;
    }

    public String getEb_name() {
        return eb_name;
    }

    public void setEb_name(String eb_name) {
        this.eb_name = eb_name;
    }

    public String getEb_street() {
        return eb_street;
    }

    public void setEb_street(String eb_street) {
        this.eb_street = eb_street;
    }

    public int getEb_n() {
        return eb_n;
    }

    public void setEb_n(int eb_n) {
        this.eb_n = eb_n;
    }

    public Set<Children> getChildren() {
        return children;
    }

    public void setChildren(Set<Children> children) {
        this.children = children;
    }

    public AreaStreet getAreaStreet() {
        return areaStreet;
    }

    public void setAreaStreet(AreaStreet areaStreet) {
        this.areaStreet = areaStreet;
    }

    @Override
    public String toString(){
        return "{" + ebuilding_id+ "} {" + eb_name + "}{Район : " + areaStreet.getAs_area() + "}{" + eb_street + "} {" + eb_n + "}\n";
    }

}
