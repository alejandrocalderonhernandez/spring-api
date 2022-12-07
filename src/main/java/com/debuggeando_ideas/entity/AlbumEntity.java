package com.debuggeando_ideas.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;

@Entity
public class AlbumEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long albumId;
	private String name;
	private String autor;
	private Double price;
	@JsonIgnoreProperties(value = "albums", allowSetters = true)
	@ManyToOne(cascade = CascadeType.ALL)
	private RecordCompanyEntity recordCompany;
	@JsonIgnoreProperties(value = "album", allowSetters = true)
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL,  orphanRemoval = true)
	private Set<TrackEntity> tracks;
	
	public AlbumEntity() { 
		this.tracks = new HashSet<>();
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public RecordCompanyEntity getRecordCompany() {
		return recordCompany;
	}

	public void setRecordCompany(RecordCompanyEntity recordCompany) {
		this.recordCompany = recordCompany;
	}
	
	public Set<TrackEntity> getTracks() {
		return tracks;
	}

	public void setTracks(Set<TrackEntity> tracks) {
		this.tracks.clear();
		tracks.forEach(this::addTrack);
	}
	
	public void addTrack(TrackEntity track) {
		this.tracks.add(track);
		track.setAlbum(this);
	}

	@Override
	public String toString() {
		return new Gson().toJson(this).toString();
	}

	private static final long serialVersionUID = -8277318435297709390L;

}
