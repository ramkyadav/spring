package com.example.demo.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.UserDetails;

@Repository
public interface UserDao extends JpaRepository<UserDetails, Long> {
	
	UserDetails findByEmail(String email);
	
}