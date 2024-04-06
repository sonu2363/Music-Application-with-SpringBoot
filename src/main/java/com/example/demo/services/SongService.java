package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Songs;
import com.example.demo.entities.Users;

import java.util.List;

import com.example.demo.entities.Songs;


public interface SongService  {
	public String addSong(Songs song);
	public boolean songExists(String name);
	
	public List<Songs> fetchAllSongs();
	
	
	public void updateSong(Songs song);

}