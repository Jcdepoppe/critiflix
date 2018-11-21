package com.critiflix.app.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.critiflix.app.models.MovieTime;

@Repository 
public interface MovieTimeRepo extends CrudRepository<MovieTime, Long>{ 
	List<MovieTime> findAll();
	List<MovieTime> findByplaceidOrderByStarttimeAsc(String placeid);
	
    @Query("SELECT mt FROM movietimes mt WHERE mt.placeid = :placeid AND mt.starttime >= :starttime ORDER BY mt.starttime ASC")
    List<MovieTime> getAllByplaceidBetweenStartAndEndTimesOrderByStarttimeAsc(@Param("placeid") String placeid, @Param("starttime") Date starttime); 

}