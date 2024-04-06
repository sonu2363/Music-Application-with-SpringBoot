package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Songs;
import com.example.demo.services.SongService;

@Controller
public class SongController {
	@Autowired
	SongService service;
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Songs song)
	{
		boolean songStatus=service.songExists(song.getName());
		if(songStatus==false)
		{
			service.addSong(song);
			System.out.println("song added successfully");
		}
		return "adminHome";
	}
	@GetMapping("/viewSongs")
	public String viewCustomerSongs(Model model) {
		
		System.out.println("1");
			List<Songs> songslist = service.fetchAllSongs();
			System.out.println("2");
			model.addAttribute("songs", songslist);
			
			System.out.println("3");
			return "displaySongs";
		

	}

}
