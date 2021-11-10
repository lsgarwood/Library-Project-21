package com.qa.library.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.library.domain.LibraryMemb;
import com.qa.library.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

	private LibraryService service;

	public LibraryController(LibraryService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<LibraryMemb> createLibraryMemb(@RequestBody LibraryMemb newLibraryMemb) {
		LibraryMemb responseBody = this.service.createLibraryMemb(newLibraryMemb);
		return new ResponseEntity<LibraryMemb>(responseBody, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<LibraryMemb>> getLibraryMemb() {
		return ResponseEntity.ok(this.service.getLibraryMemb());
	}

	@GetMapping("/get/{id}")
	public LibraryMemb getLibraryMemb(@PathVariable Integer id) {
		return this.service.getLibraryMemb(id);
	}

	@PutMapping("/replace/{id}")
	public ResponseEntity<LibraryMemb> replaceLibraryMemb(@PathVariable Integer id,
			@RequestBody LibraryMemb newLibraryMemb) {
		System.out.println("Replacing Library Member with id " + id + " with " + newLibraryMemb);
		LibraryMemb body = this.service.replaceLibraryMemb(id, newLibraryMemb);
		return new ResponseEntity<LibraryMemb>(body, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeLibraryMemb(@PathVariable Integer id) {
		System.out.println("Removing Library Member with id " + id);
		boolean removed = this.service.removeLibraryMemb(id);

		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}