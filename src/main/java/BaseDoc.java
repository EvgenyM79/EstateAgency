import java.sql.Blob;

import javax.persistence.*;


@Entity
@Table(name = "PERSON")
public class BaseDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bd_id;

    @Column(name = "name_doc", nullable = false)
    private String name_doc;

    @Column(name = "doc", nullable = false)
    private Blob doc;

    public BaseDoc() {
    }

    public BaseDoc(String name_doc, Blob doc) {
        this.name_doc = name_doc;
        this.doc = doc;
    }





}
