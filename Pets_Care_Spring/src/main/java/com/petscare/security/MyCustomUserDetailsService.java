package com.petscare.security;


import com.petscare.dao.CollaboratorDao;
import com.petscare.dao.UserDao;
import com.petscare.model.Collaborator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyCustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private CollaboratorDao collDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Object admin = getUser(email);

		if (admin != null) {
			User.UserBuilder builder = User.withUsername(email);
			if(admin.getClass()==com.petscare.model.User.class){
				com.petscare.model.User usr = (com.petscare.model.User) admin;
				builder.password(usr.getPassword());
				builder.roles("user");
				return builder.build();
			}
			else{
				Collaborator col = (Collaborator) admin;
				builder.password(col.getPassword());
				builder.roles("collaborator");
				return builder.build();
			}			
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
	}

	public Object getUser(String email){

		Iterable<com.petscare.model.User> usr = userDao.findAll();
		Iterable<Collaborator> col = collDao.findAll();

		Object n = null;

		for(com.petscare.model.User us :usr){
			if(us.getEmail().equals(email)){
				n=us;
			}
		}
		for(Collaborator co :col){
			if(co.getEmail().equals(email)){
				n=co;
			}
		}
		return n;
	} 


}