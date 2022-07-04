package ch.bbw.personenVerwaltung.repository;

import ch.bbw.personenVerwaltung.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByFirstname(String firstname);

}
