package com.critiflix.app.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.critiflix.app.models.MovieTime;
import com.critiflix.app.models.TheaterLocation;
import com.critiflix.app.models.User;
import com.critiflix.app.services.MovieTimeService;
import com.critiflix.app.services.TheaterService;
import com.critiflix.app.services.UserService;

@Controller
@RequestMapping("/theaters")
public class TheaterController {
	private final TheaterService theaterService;
	private final UserService userService;
	private final MovieTimeService movieTimeService;
	private final String GAPIKEY = "AIzaSyA_aOK49a2Rm00tCPaeNE6d23F0y2O7BL4";
	
	public TheaterController(TheaterService theaterService, UserService userService, MovieTimeService movieTimeService) {
		this.theaterService = theaterService;
		this.userService = userService;
		this.movieTimeService = movieTimeService;
	}
	
	//Display the Entire Zip Code
	@RequestMapping("")
	public String enterzip() {
		return "zip.jsp";
	}	
	
	@RequestMapping(value="/selectshowing", method=RequestMethod.POST) 
	public String selectshowing(@RequestParam("showid") Long showid, @RequestParam("placeid") String placeid, HttpSession session, Model model) { 
		System.out.println("============================================selectshowing()");
		System.out.println(showid);
		System.out.println(placeid);

		MovieTime movietime = movieTimeService.findMovieTime(showid);
		System.out.println(movietime.getTitle());
		Date newtime = movietime.getStarttime();
	
		System.out.println("==-==-=-==-=-==" + newtime);
		List<MovieTime> movieTimes = movieTimeService.getMovieTimes2(placeid, newtime);
		model.addAttribute("movieTimes", movieTimes);		
		
		return "redirect:/theaters/" + placeid;
	} 	
	
	 @RequestMapping("/{placeid}")
	 public String showTheater(@PathVariable("placeid") String placeid, HttpSession session, Model model ) {

		 User loggedInUser = (User) session.getAttribute("user");
		 if ((loggedInUser.equals(null))) {
			 return "redirect:/";
		 }
		 
		 System.out.println(placeid);
		 session.setAttribute("placeid", placeid);
		 
		 // List<MovieTime> movieTimes = movieTimeService.allMovieTimesForPlaceId(placeid);
		 Date datenow = new Date();
		 List<MovieTime> movieTimes = movieTimeService.getMovieTimes2(placeid, datenow);
		 model.addAttribute("movieTimes", movieTimes);
		 
		 return "/showtheater.jsp";
	 }	
	
	@RequestMapping(value="/getzipcode", method=RequestMethod.POST) 
	public String create(@RequestParam("zipcode") String zipcode, HttpSession session) { 
		List<TheaterLocation> theaterlocations = new ArrayList<TheaterLocation>();
		
		JSONObject jso = theaterService.getLatLongViaZipCode(zipcode);
		JSONArray jsaZipCodeResponse = (JSONArray) jso.get("results");
		JSONObject jso1 = (JSONObject) jsaZipCodeResponse.get(0);
		JSONObject jso1a = (JSONObject) jso1.get("geometry");
		JSONObject jso1b = (JSONObject) jso1a.get("location");
		
		String lat = jso1b.get("lat").toString();
		System.out.println("lat: " + lat);
		String lng = jso1b.get("lng").toString();
		System.out.println("lng: " + lng);		
		
		JSONObject jsoAreaTheaters = (JSONObject) theaterService.getJSOTheatersViaLatLong(lat, lng);
		JSONArray jsaAreaTheaters = (JSONArray) jsoAreaTheaters.get("results");

        for (int i = 0; i < jsaAreaTheaters.size(); i++) {
        	JSONObject jsoAT = (JSONObject) jsaAreaTheaters.get(i);
        	JSONObject jsoTheaterGeometry = (JSONObject) jsoAT.get("geometry");
        	String theater_place_id = (String) jsoAT.get("place_id");
        	String vicinity = (String) jsoAT.get("vicinity");
        	System.out.println(theater_place_id);
        	String theater_name = (String) jsoAT.get("name");
        	System.out.println(theater_name);
        	JSONObject jsoTheaterLocation = (JSONObject) jsoTheaterGeometry.get("location");
        	String theater_lat = jsoTheaterLocation.get("lat").toString();
        	System.out.println(theater_lat);
        	String theater_lng = jsoTheaterLocation.get("lng").toString();
        	System.out.println(theater_lng);
        	
        	TheaterLocation theaterLocation = new TheaterLocation(theater_name, theater_lat, theater_lng, theater_place_id, vicinity);
        	System.out.println(theaterLocation.getName());
        	theaterlocations.add(theaterLocation);
        }
		
		session.setAttribute("zipcode", zipcode);
		session.setAttribute("theaterlocations", theaterlocations);
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		session.setAttribute("user", user);
		
		return "redirect:/theaters/dashboard";
	} 
	
	//Display the dashboard/homepage
	@RequestMapping("/dashboard")
	public String dashboard(HttpSession session) {
		System.out.println(session.getAttribute("user"));
		return "dashboard.jsp";
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
	            
	            String strRTRaw = (String) jso.get("runTime");
	            if (strRTRaw == null) {
	            	continue;
	            }
	            String strRT = strRTRaw.substring(2);
	            
	            JSONObject jsoPImage = (JSONObject) jso.get("preferredImage");
	            String strImageUrl = (String) jsoPImage.get("uri");
	            
	            SimpleDateFormat sdf = new SimpleDateFormat("hh'H'mm'M'");
	            Date date = sdf.parse(strRT);
	            System.out.println(date);
	            	            
	            JSONArray jsaShowtimes = (JSONArray) jso.get("showtimes");
	            for (int j = 0; j < jsaShowtimes.size(); j++) {
	            	JSONObject jsoST = (JSONObject) jsaShowtimes.get(j);
	            	JSONObject jsoTheater = (JSONObject) jsoST.get("theatre");
	            	System.out.println("--------- theatreid/name: " + jsoTheater.get("id") + " + " + jsoTheater.get("name"));
	            	System.out.println("--------- dateTime: " + jsoST.get("dateTime"));

		            
		            SimpleDateFormat sdfst = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		            Date dateST = sdfst.parse((String)jsoST.get("dateTime"));
		            System.out.println(dateST);	            	
	            	
	            	JSONObject jsoTheaterInfo = theaterService.getJSOViaTheaterName((String)jsoTheater.get("name"));
	            	JSONArray jsaTheaterResponse = (JSONArray) jsoTheaterInfo.get("candidates");
	            	if (jsaTheaterResponse.size() > 0) {
	            		JSONObject jsoCandidate = (JSONObject) jsaTheaterResponse.get(0);
		            	if (jsoCandidate.size() > 0) {
			            	System.out.println(jsoCandidate.get("place_id"));
			            	
			            	MovieTime movieTime = new MovieTime();
			            	movieTime.setPlaceid((String)jsoCandidate.get("place_id"));
			            	movieTime.setTheaterapiid((String)jsoTheater.get("id"));
			            	movieTime.setStarttime(dateST);
			            	movieTime.setTitle((String) jso.get("title"));
			            	movieTime.setImageUrl(strImageUrl);
			            	Long millis = date.getTime();
			            	movieTime.setDuration(millis);
			            	
			            	
			            	// New date object from millis
			            	Date millidate = new Date(millis);
			            	// formattter 
			            	SimpleDateFormat formatter= new SimpleDateFormat("HH:mm");
			            	formatter.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
			            	// Pass date object
			            	String strDuration = formatter.format(millidate);
			            	movieTime.setStrduration(strDuration);
			            	
			            	movieTime.setShortdescription((String) jso.get("shortDescription")); 
			            	movieTimeService.createMovieTime(movieTime);
			            	
			            	
		            	}
	            	}
	            }
	            System.out.println("<<<<< ======================================================");	            
	        }		
		} catch (ParseException e) {
			e.printStackTrace();
		}  catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} 
	}
	
	
}









