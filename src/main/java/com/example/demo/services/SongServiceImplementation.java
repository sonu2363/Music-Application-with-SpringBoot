package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Songs;
import com.example.demo.entities.Users;
import com.example.demo.repository.SongRepository;

@Service
public class SongServiceImplementation implements SongService{
	@Autowired 
	SongRepository repo;

	@Override
	public String addSong(Songs song) {
		repo.save(song);
		return "Song is added";
		
	}

	@Override
	public List<Songs> fetchAllSongs() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean songExists(String name) {
		// TODO Auto-generated method stub
		Songs song=repo.findByName(name);
		if(song==null)
		{
			return false;
		}
		else
		{
			return true;
			
		}
	}

	@Override
	public void updateSong(Songs song) {
		// TODO Auto-generated method stub
		repo.save(song);
	}

	
	

	

	
 
}
