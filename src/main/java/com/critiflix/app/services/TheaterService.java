package com.critiflix.app.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

@Service 
public class TheaterService {
	private final String USER_AGENT = "Mozilla/5.0";
	private final String GAPIKEY = "AIzaSyA_aOK49a2Rm00tCPaeNE6d23F0y2O7BL4";
	
	public String sendURLViaGET(String url) throws Exception {
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
		// Send get request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//return result
		return response.toString();
	}
	
	public String sendURLViaPOST(String url, String urlParameters) throws Exception {
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//return result
		return response.toString();
	}
	
	// https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=Regal+Thornton+Place+Stadium+14+%2B+IMAX&inputtype=textquery&fields=name,formatted_address,place_id&key=AIzaSyA_aOK49a2Rm00tCPaeNE6d23F0y2O7BL4
	public JSONObject getJSOViaTheaterName(String theaterName) {
		
		String urlPrefix = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=";
		String urlPostfix = "&inputtype=textquery&fields=name,formatted_address,place_id&key=";
		String encodedName = UriUtils.encode(theaterName, "UTF-8");
		String encodedUrl = urlPrefix + encodedName + urlPostfix + this.GAPIKEY;

		JSONObject jso = null;
		
		try {
			JsonReader jsr = new JsonReader();
			jso = jsr.readJsonFromUrl(encodedUrl);
			System.out.println(jso);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jso;
	}

	// https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=Regal+Thornton+Place+Stadium+14+%2B+IMAX&inputtype=textquery&fields=name,formatted_address,place_id&key=AIzaSyA_aOK49a2Rm00tCPaeNE6d23F0y2O7BL4
	public JSONObject getLatLongViaZipCode(String zipCode) {
		
		String urlPrefix = "https://maps.googleapis.com/maps/api/geocode/json?address=";
		String urlPostfix = "&key=";
		String encodedUrl = urlPrefix + zipCode + urlPostfix + this.GAPIKEY;

		JSONObject jso = null;
		
		try {
			JsonReader jsr = new JsonReader();
			jso = jsr.readJsonFromUrl(encodedUrl);
			System.out.println(jso);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jso;
	}
	
	//https://maps.googleapis.com/maps/api/place/nearbysearch/json?type=movie_theater&radius=16000&location=47.543914,-122.018032&radius=50&key=AIzaSyA_aOK49a2Rm00tCPaeNE6d23F0y2O7BL4
	public JSONObject getJSOTheatersViaLatLong(String lat, String lng) {
		
		String urlPrefix = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?type=movie_theater&location=";
		String urlPostfix = "&radius=5000&key=";
		String encodedUrl = urlPrefix + lat + "," + lng + urlPostfix + this.GAPIKEY;

		JSONObject jso = null;
		
		try {
			JsonReader jsr = new JsonReader();
			jso = jsr.readJsonFromUrl(encodedUrl);
			System.out.println(jso);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jso;
	}
	
	
	

}













