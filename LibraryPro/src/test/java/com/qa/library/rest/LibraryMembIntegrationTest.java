package com.qa.library.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.library.domain.LibraryMemb;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:librarymemb-schema.sql",
		"classpath:librarymemb-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

//@ActiveProfiles("test")
public class LibraryMembIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreateLibraryMemb() throws Exception {

		LibraryMemb requestBody = new LibraryMemb("Jane Bird", "1 Oak Tree Lane, Foreston, Norfolk",
				"Jane.Bird@oakmail.com");
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);

		RequestBuilder request = post("/library/create").contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAsJSON);

		LibraryMemb responseBody = new LibraryMemb(3, "Jane Bird", "1 Oak Tree Lane, Foreston, Norfolk",
				"Jane.Bird@oakmail.com");
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(responseBodyAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetAll() throws Exception {

		RequestBuilder request = get("/library/getAll");
		System.out.println(request);
		ResultMatcher checkStatus = status().isOk();

		LibraryMemb member = new LibraryMemb(1, "Jane Bird", "1 Oak Tree Lane, Foreston, Norfolk",
				"Jane.Bird@oakmail.com");
		LibraryMemb member2 = new LibraryMemb(2, "Lauren Bird", "2 Oak Tree Lane, Foreston, Norfolk",
				"Lauren.Bird@oakmail.com");
		List<LibraryMemb> members = List.of(member, member2);
		String responseBody = this.mapper.writeValueAsString(members);

		ResultMatcher checkBody = content().json(responseBody);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testGetLibraryMembById() throws Exception {

		LibraryMemb member = new LibraryMemb(1, "Jane Bird", "1 Oak Tree Lane, Foreston, Norfolk",
				"Jane.Bird@oakmail.com");

		RequestBuilder request = get("/library/get/1");

		String responseBody = this.mapper.writeValueAsString(member);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(responseBody);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testReplaceLibraryMemb() throws Exception {

		LibraryMemb requestBody = new LibraryMemb("Jane Bird", "1 Oak Tree Lane, Foreston, Norfolk",
				"Jane.Bird@oakmail.com");
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);

		RequestBuilder request = put("/library/replace/1").contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAsJSON);

		LibraryMemb responseBody = new LibraryMemb(1, "Jane Bird", "1 Oak Tree Lane, Foreston, Norfolk",
				"Jane.Bird@oakmail.com");
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(responseBodyAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testRemoveLibraryMemb() throws Exception {

		RequestBuilder request = delete("/library/remove/1");

		ResultMatcher checkStatus = status().isNoContent();

		this.mvc.perform(request).andExpect(checkStatus);
	}

}
