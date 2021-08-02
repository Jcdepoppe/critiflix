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
    private Date starttime;
    private String title;
    private Long duration; // milliseconds
    private String strduration;
    private String shortdescription;
    private String theaterapiid;
    private String placeid;
    private String imageUrl;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public String getShortdescription() {
		return shortdescription;
	}
	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}
	public String getTheaterapiid() {
		return theaterapiid;
	}
	public void setTheaterapiid(String theaterapiid) {
		this.theaterapiid = theaterapiid;
	}
	public String getPlaceid() {
		return placeid;
	}
	public void setPlaceid(String placeid) {
		this.placeid = placeid;
	}
	public String getStrduration() {
		return strduration;
	}
	public void setStrduration(String strduration) {
		this.strduration = strduration;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
   
}