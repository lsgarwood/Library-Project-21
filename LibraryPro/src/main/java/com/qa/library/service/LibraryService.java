package com.qa.library.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.qa.library.domain.LibraryMemb;

@Component
public interface LibraryService {

	LibraryMemb createLibraryMemb(LibraryMemb newLibraryMemb);

	List<LibraryMemb> getLibraryMemb();

	LibraryMemb getLibraryMemb(Integer id);

	LibraryMemb replaceLibraryMemb(Integer id, LibraryMemb newLibraryMemb);

	boolean removeLibraryMemb(Integer id);
}
