package com.cloud.democlient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudRepository extends JpaRepository<CloudUser, Integer>{
	
	public Optional<CloudUser> findByUsername(String username);

}
