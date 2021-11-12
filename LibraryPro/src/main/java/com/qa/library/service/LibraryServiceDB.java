package com.qa.library.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.library.domain.LibraryMemb;
import com.qa.library.repos.LibraryMembRepo;

@Primary
@Service
public class LibraryServiceDB implements LibraryService {

	private LibraryMembRepo repo;

	public LibraryServiceDB(LibraryMembRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public LibraryMemb createLibraryMemb(LibraryMemb newLibraryMemb) {
		return this.repo.save(newLibraryMemb);
	}

	@Override
	public List<LibraryMemb> getLibraryMemb() {
		return this.repo.findAll();
	}

	@Override
	public LibraryMemb getLibraryMemb(Integer id) {
		return this.repo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No Library Member found with this id: " + id));
	}

	@Override
	public LibraryMemb replaceLibraryMemb(Integer id, LibraryMemb newLibraryMemb) {
		LibraryMemb existing = this.getLibraryMemb(id);

		existing.setName(newLibraryMemb.getName());
		existing.setAddress(newLibraryMemb.getAddress());
		existing.setEmail(newLibraryMemb.getEmail());

		return this.repo.save(existing);
	}

	@Override
	public boolean removeLibraryMemb(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
