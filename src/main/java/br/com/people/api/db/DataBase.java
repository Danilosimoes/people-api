package br.com.people.api.db;

import br.com.people.api.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DataBase {

    // DB Operations https://mkyong.com/spring-boot/spring-boot-jdbc-examples/

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void insert(Person person) {
        jdbcTemplate.update(
                "INSERT INTO PERSON (NAME, AGE) VALUES (?,?)",
                person.getName(),
                person.getAge()
        );
    }

    public Person find(long id) {
        return jdbcTemplate.queryForObject("SELECT ID, NAME, AGE FROM PERSON WHERE ID = ?",
                (rs, rowNum) -> {
                    var person = new Person();
                    person.setId(rs.getLong("ID"));
                    person.setName(rs.getString("NAME"));
                    person.setAge(rs.getInt("AGE"));
                    return person;
                },
                id);
    }


    public int deleteById(long id) {
        return jdbcTemplate.update(
                "delete from person where id = ?",
                deleteById(id),id);
    }


    // crlt + alt + L formata o código


    public int update(Person person) {
        return jdbcTemplate.update("UPDATE PERSON SET NAME = ?, AGE = ? WHERE ID = ?",
                person.getName(),
                person.getAge(),
                person.getId()
        );

    }


}
