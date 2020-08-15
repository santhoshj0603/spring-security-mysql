package com.cloud.democlient.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cloud.democlient.repository.CloudRepository;
import com.cloud.democlient.repository.CloudUser;

@Service
public class CloudUserDetailsService implements UserDetailsService {
	
	@Autowired
	CloudRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CloudUser user = repository.findByUsername(username).get();
		return new CloudUserDetails(user);
	}
	
	public void saveUser(CloudUser user) {
		repository.save(user);
	}

	public List<CloudUser> findAll() {
		return repository.findAll();
	}
	
}
