package com.jh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jh.domain.Vereador;
import com.jh.repositories.VereadorRepository;
import com.jh.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private VereadorRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Vereador vereador = repo.findByEmail(email);
		if (vereador == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(vereador.getCodVereador(), vereador.getEmail(), vereador.getSenha(), vereador.getPerfis());
	}
}
