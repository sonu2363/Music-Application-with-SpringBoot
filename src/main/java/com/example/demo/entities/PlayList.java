package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PlayList {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	@ManyToMany
	List<Songs> songs;
	public PlayList() {
		super();
		// TODO Auto-generated constructor stub
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
	public List<Songs> getSongs() {
		return songs;
	}
	public void setSongs(List<Songs> songs) {
		this.songs = songs;
	}
	@Override
	public String toString() {
		return "PlayList [id=" + id + ", name=" + name + ", songs=" + songs + "]";
	}
	
	

}
