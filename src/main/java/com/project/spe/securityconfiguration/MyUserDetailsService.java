package com.project.spe.securityconfiguration;

import com.project.spe.user.User;
import com.project.spe.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByemail(email);
        user.orElseThrow(()->new UsernameNotFoundException("Not Found: "+email));

        return user.map(MyUserDetails::new).get();
    }
}
