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
                "INSERT INTO PERSON (NAME, AGE, SEX) VALUES (?,?,?)",
                person.getName(),
                person.getAge(),
                person.getSex()
        );
    }

    public Person find(long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT ID, NAME, AGE, SEX FROM PERSON WHERE ID = ?",
                    (rs, rowNum) -> {
                        var person = new Person();
                        person.setId(rs.getLong("ID"));
                        person.setName(rs.getString("NAME"));
                        person.setAge(rs.getInt("AGE"));
                        person.setSex(rs.getString("SEX"));
                        return person;
                    },
                    id);
        } catch (Exception ex) {
            return null;
        }

    }


    public int deleteById(long id) {
        return jdbcTemplate.update(
                "delete from PERSON where ID = ?",
                id);
    }


    public int update(Person person) {
        return jdbcTemplate.update("UPDATE PERSON SET NAME = ?, AGE = ?, SEX = ? WHERE ID = ?",
                person.getName(),
                person.getAge(),
                person.getSex(),
                person.getId()
        );

    }
}
