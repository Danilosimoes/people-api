package br.com.people.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {

	@Test
	public void contextLoads() {
	}

}

// PESQUISAR - ESTUDAR
//DOCKER BUILD
//DOCKER FILE
//docker rm -f $(docker ps -aq)
// gerar docker file a partir da people-api
//configurar route 53