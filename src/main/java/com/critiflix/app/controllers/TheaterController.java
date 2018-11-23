package com.critiflix.app.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.critiflix.app.models.Rating;
import com.critiflix.app.services.MovieTimeService;
import com.critiflix.app.services.RatingService;
import com.critiflix.app.services.TheaterService;
import com.critiflix.app.services.UserService;

@Controller
@RequestMapping("/theaters")
public class TheaterController {
	private final TheaterService theaterService;
	private final UserService userService;
	private final MovieTimeService movieTimeService;
	private final RatingService ratingService;
	
	public TheaterController(TheaterService theaterService, UserService userService, MovieTimeService movieTimeService, RatingService ratingService) {
		this.theaterService = theaterService;
		this.userService = userService;
		this.movieTimeService = movieTimeService;
		this.ratingService = ratingService;
	}
	
	//Display the Entire Zip Code
	@RequestMapping("")
	public String enterzip() {
		return "zip.jsp";
	}

	@RequestMapping(value="/process", method=RequestMethod.POST) 
	public String create(@RequestParam("zipcode") Long zipcode, HttpSession session) { 
		session.setAttribute("zipcode", zipcode);
		return "redirect:/dashboard";
	} 
	
	//Display the dashboard/homepage
	@RequestMapping("/dashboard/{id}")
	public String dashboard(Model model, @PathVariable("id") Long id) {
		
		Rating rating = ratingService.getRatingById(id);
		model.addAttribute("rating", rating);
		return "test.jsp";
	}
	
	//Load sample data
	@RequestMapping("/loadsampledata")
	public void loadData() {
		try {
			JSONArray jsaML = movieTimeService.GetSampleMovieTimeJSON();

	        for (int i = 0; i < jsaML.size(); i++) {
	            JSONObject jso = (JSONObject) jsaML.get(i);
	            System.out.println(">>>>> ======================================================");	            
	            System.out.println("title: " + jso.get("title"));
	            System.out.println("desription: " + jso.get("shortDescription"));
	            System.out.println("runTime: " + jso.get("runTime"));
	            JSONArray jsaShowtimes = (JSONArray) jso.get("showtimes");
	            for (int j = 0; j < jsaShowtimes.size(); j++) {
	            	JSONObject jsoST = (JSONObject) jsaShowtimes.get(j);
	            	JSONObject jsoTheater = (JSONObject) jsoST.get("theatre");
	            	System.out.println("--------- theatreid/name: " + jsoTheater.get("id") + " + " + jsoTheater.get("name"));
					String encodedString = URLEncoder.encode((String) jsoTheater.get("name"), "UTF-8");
	            	System.out.println(encodedString);
	            	System.out.println("--------- dateTime: " + jsoST.get("dateTime"));
	            }
	            System.out.println("<<<<< ======================================================");	            
	        }		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}









