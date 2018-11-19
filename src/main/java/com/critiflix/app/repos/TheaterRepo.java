package com.critiflix.app.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.critiflix.app.models.Theater;

@Repository
public interface TheaterRepo extends CrudRepository<Theater, Long>{
	List<Theater> findAll(); 
}
