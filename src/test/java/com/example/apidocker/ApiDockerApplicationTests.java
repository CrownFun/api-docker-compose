package com.example.apidocker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
class ApiDockerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test() throws Exception {

		this.mockMvc.perform(get("/api/country/test"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Egypt")));
	}
}

