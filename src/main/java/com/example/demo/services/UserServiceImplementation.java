package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Songs;
import com.example.demo.entities.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UserServiceImplementation implements UsersService{
	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
		return null;
	}

	@Override
	public boolean emailExists(String email) {
		// TODO Auto-generated method stub
		if(repo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{			
			return true;
		}
	}
	public boolean validateUser(String email, String password)
	{
		Users user=repo.findByEmail(email);
		String db_pass=user.getPassword();
		if(password.equals(db_pass))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		// TODO Auto-generated method stub
		Users user=repo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
	}

	

}
