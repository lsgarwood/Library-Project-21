package com.qa.library.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.library.domain.LibraryMemb;

@Repository
public interface LibraryRepo extends JpaRepository<LibraryMemb, Integer> {

}
