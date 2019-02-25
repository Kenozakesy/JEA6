package Repositories;

import Classes.person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import static javax.transaction.Transactional.TxType.REQUIRED;

/**
 * Created by Gebruiker on 18-2-2019.
 */

@Stateless
public class PersonRepository {

    @PersistenceContext(unitName = "payaraHibernate")
    private EntityManager em;

    @SuppressWarnings("JpaQlInspection")
    public List<person> getAll() {
        return em.createQuery("SELECT p FROM person p ", person.class).getResultList();
    }

    public person getByID(Long id) {
        return em.find(person.class, id);
    }

    @Transactional(REQUIRED)
    public void addperson(person person) {
        em.persist(person);
    }
}
