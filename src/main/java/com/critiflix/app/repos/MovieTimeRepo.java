package com.critiflix.app.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.critiflix.app.models.MovieTime;

@Repository 
public interface MovieTimeRepo extends CrudRepository<MovieTime, Long>{ 
	List<MovieTime> findAll();
	List<MovieTime> findByplaceidOrderByStarttimeAsc(String placeid);
	List<MovieTime> findByplaceidAndStarttimeGreaterThanOrderByStarttimeAsc(String placeid, Date starttime);



}