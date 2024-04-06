package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;
import com.example.demo.services.SongService;
import com.example.demo.entities.Songs;
import java.util.*;

@Controller
public class UsersController {
	@Autowired
	UsersService userv;
	
	@Autowired
	SongService songserv;
	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user) {
		
		boolean userStatus=userv.emailExists(user.getEmail());
		if(userStatus==false)
		{
			userv.addUser(user);
            System.out.println("user added");
		}
		else
		{
			System.out.println("user already added");
		}
		return "home";	
		     
	}
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,
			               @RequestParam("password") String password)
{
		System.out.println("Hello");
	if(userv.validateUser(email,password)==true)
	{
		String role=userv.getRole(email);
		if(role.equals("admin"))
		{			
			return "adminHome";
		}
		else
		{
			return "customerHome";
		}
	}
	else
	{
		return "login";
	}
	
	
}
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session, Model model) {
		
			
			
			
				List<Songs> songslist = songserv.fetchAllSongs();
				model.addAttribute("songs", songslist);
				return "displaysongs";
			
			
	}
}		




