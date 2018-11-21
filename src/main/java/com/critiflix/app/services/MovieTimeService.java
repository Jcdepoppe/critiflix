package com.critiflix.app.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.critiflix.app.models.MovieTime;
import com.critiflix.app.repos.MovieTimeRepo;

@Service
public class MovieTimeService {
	private final MovieTimeRepo movieTimeRepo; 

	public MovieTimeService(MovieTimeRepo movieTimeRepo) { 
		this.movieTimeRepo = movieTimeRepo; 
	} 

	// returns all the movie times 
	public List<MovieTime> allMovieTimes() { 
	    return movieTimeRepo.findAll(); 
	} 

	// returns all the movie times 
	public List<MovieTime> allMovieTimesForPlaceId(String placeid) { 
	    return movieTimeRepo.findByplaceidOrderByStarttimeAsc(placeid); 
	} 
	
	// creates a movie time 
	public MovieTime createMovieTime(MovieTime movieTime) { 
	    return movieTimeRepo.save(movieTime); 
	} 

	// retrieves a movie time 
	public MovieTime findMovieTime(Long id) { 
	    Optional<MovieTime> optionalMovieTime = movieTimeRepo.findById(id); 
	    if(optionalMovieTime.isPresent()) { 
	        return optionalMovieTime.get(); 
	    } else { 
	        return null; 
	    } 
	}
	
	public JSONArray GetSampleMovieTimeJSON() throws ParseException {
		
        //JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
        JSONArray movieTimeList = new JSONArray();
                         
        try (FileReader reader = new FileReader("src/main/resources/static/json/98004-11192018.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            movieTimeList = (JSONArray) obj;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return movieTimeList;
	}
}