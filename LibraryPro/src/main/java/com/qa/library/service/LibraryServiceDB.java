package com.qa.library.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.library.repos.LibraryRepo;

@Primary
@Service
public class LibraryServiceDB implements LibraryService {

	private LibraryRepo repo;

	public LibraryServiceDB(LibraryRepo repo) {
		super();
		this.repo = repo;
	}

}
