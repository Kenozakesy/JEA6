package Classes;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Person.findOne", query = "select p from person p where p.personid = :id"),
        @NamedQuery(name = "Person.getAll", query = "select p from person p")
        }
)
public class person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personid;

    @Column
    private String name;

    public person()
    {

    }

    public person(String name)
    {
        this.name = name;
    }


    public int getPeronid() {
        return personid;
    }
    public void setPeronid(int peronid) {
        this.personid = peronid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
