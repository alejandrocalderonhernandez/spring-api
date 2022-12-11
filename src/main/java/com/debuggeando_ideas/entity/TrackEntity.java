package com.debuggeando_ideas.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;

@Entity
public class TrackEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long trackId;
	private String name;
	private String lycris;
	@JsonIgnoreProperties(value = "tracks")
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "albumId")
	private AlbumEntity album;
	
	public TrackEntity() { }

	public Long getTrackId() {
		return trackId;
	}

	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLycris() {
		return lycris;
	}

	public void setLycris(String lycris) {
		this.lycris = lycris;
	}

	public AlbumEntity getAlbum() {
		return album;
	}

	public void setAlbum(AlbumEntity album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this).toString();
	}
	
	private static final long serialVersionUID = 1786544567L;

}
