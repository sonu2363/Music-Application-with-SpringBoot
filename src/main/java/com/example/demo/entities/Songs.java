package com.example.demo.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Songs {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
    String name;
    String genre;
    String link;
    @ManyToMany
    List<PlayList> playlists;
	public Songs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Songs(int id, String name, String genre, String link, List<PlayList> playlists) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.link = link;
		this.playlists = playlists;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", genre=" + genre + ", link=" + link + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<PlayList> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<PlayList> playlists) {
		this.playlists = playlists;
	}
    
}
