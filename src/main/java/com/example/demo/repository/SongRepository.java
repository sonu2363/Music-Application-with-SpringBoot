package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Songs;

public interface SongRepository extends JpaRepository<Songs,Integer> {

	public Songs findByName(String name);

	

}
