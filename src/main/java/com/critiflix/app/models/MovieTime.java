package com.critiflix.app.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="movietimes")
public class MovieTime {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    //@DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm")
    private Date startTime;
    private String title;
    private Long duration; // milliseconds
    private String short_description;
    private String theaterAPIid;
    private String GAPIPlaceID;
    //private String imageUrl;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getTheaterAPIid() {
		return theaterAPIid;
	}
	public void setTheaterAPIid(String theaterAPIid) {
		this.theaterAPIid = theaterAPIid;
	}
	public String getGAPIPlaceID() {
		return GAPIPlaceID;
	}
	public void setGAPIPlaceID(String gAPIPlaceID) {
		GAPIPlaceID = gAPIPlaceID;
	}
    
}