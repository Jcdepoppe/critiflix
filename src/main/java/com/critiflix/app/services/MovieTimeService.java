package com.critiflix.app.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
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

	// returns all the songs 
	public List<MovieTime> allSongs() { 
	    return movieTimeRepo.findAll(); 
	} 

	// creates a song 
	public MovieTime createSong(MovieTime movieTime) { 
	    return movieTimeRepo.save(movieTime); 
	} 

	// retrieves a song 
	public MovieTime findMovieTime(Long id) { 
	    Optional<MovieTime> optionalMovieTime = movieTimeRepo.findById(id); 
	    if(optionalMovieTime.isPresent()) { 
	        return optionalMovieTime.get(); 
	    } else { 
	        return null; 
	    } 
	}
	
	public JSONArray GetSampleMovieTimeJSON() throws org.json.simple.parser.ParseException, ParseException {
		
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
        }
        return movieTimeList;
	}
}