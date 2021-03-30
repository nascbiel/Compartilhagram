package com.redeSocial.compartilhagram.security;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.redeSocial.compartilhagram.model.Usuario;
import com.redeSocial.compartilhagram.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Optional<Usuario> user = userRepository.findByUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found"));
	
		return user.map(UserDetailsImpl::new).get();
	}
}