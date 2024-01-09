package com.Alpha.Alpha.Config;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import com.Alpha.Alpha.Model.Bhakt;
import com.Alpha.Alpha.Service.BhaktService;

@Service
public class customUserDetails implements UserDetailsService {

	@Autowired
	BhaktService bhaktService;

	@Override
	public UserDetails loadUserByUsername(String mobileNo) throws UsernameNotFoundException {
		
		Bhakt bhakt = bhaktService.findByMobileNo(mobileNo);
		
		if (bhakt == null) {
            throw new UsernameNotFoundException(mobileNo);
        }
		
		System.err.println(bhakt.toString());
		
		User user = new User(bhakt.getMobileNo() , bhakt.getHashPassword() , Collections.singleton(new SimpleGrantedAuthority(bhakt.getRole())));
		
		System.err.println(user.toString());
		return user;
	}

}
