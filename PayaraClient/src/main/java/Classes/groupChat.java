package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gebruiker on 28-2-2019.
 */
public class groupChat {

    private String name;
    private List<person> people;

    public groupChat()
    {
        people = new ArrayList<person>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<person> getPeople() {
        return people;
    }
    public void setPeople(List<person> people) {
        this.people = people;
    }
}
