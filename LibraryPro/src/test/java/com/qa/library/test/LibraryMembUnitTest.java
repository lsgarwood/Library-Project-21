package com.qa.library.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.qa.library.domain.LibraryMemb;

class LibraryMembUnitTest {

	LibraryMemb membTestWithID = new LibraryMemb(1, "Jane Bird", "1 Oak Tree Lane, Foreston, Norfolk",
			"Jane.Bird@oakmail.com");
	LibraryMemb membTest = new LibraryMemb(1, "Jane Bird", "1 Oak Tree Lane, Foreston, Norfolk",
			"Jane.Bird@oakmail.com");

	@Test
	public void getIdTest() {
		assertEquals(1, membTest.getId());
	}

	@Test
	public void setIdTest() {
		assertEquals(1, membTest.getId());
		membTest.setId(2);
		assertEquals(2, membTest.getId());
	}

	@Test
	public void getNameTest() {
		assertEquals("Jane Bird", membTest.getName());
	}

	@Test
	public void setNameTest() {
		assertEquals("Jane Bird", membTest.getName());
		membTest.setName("Vera Lynn");
		assertEquals("Vera Lynn", membTest.getName());
	}

	@Test
	public void getAddressTest() {
		assertEquals("1 Oak Tree Lane, Foreston, Norfolk", membTest.getAddress());
	}

	@Test
	public void setAddressTest() {
		assertEquals("1 Oak Tree Lane, Foreston, Norfolk", membTest.getAddress());
		membTest.setAddress("2 Singsong Drive, Recordville, Fourties");
		assertEquals("2 Singsong Drive, Recordville, Fourties", membTest.getAddress());
	}

	@Test
	public void getEmailTest() {
		assertEquals("Jane.Bird@oakmail.com", membTest.getEmail());
	}

	@Test
	public void setEmailTest() {
		assertEquals("Jane.Bird@oakmail.com", membTest.getEmail());
		membTest.setEmail("vera.lynn@records.co.uk");
		assertEquals("vera.lynn@records.co.uk", membTest.getEmail());
	}

}