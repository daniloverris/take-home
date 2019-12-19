package com.boschchicagoconnectory.takehome.joan2ndProblem;

import com.boschchicagoconnectory.takehome.joan2ndProblem.controller.BookController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class Joan2ndProblemApplicationTests {

	@Autowired
	private BookController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}


}
