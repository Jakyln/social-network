package com.mesiproject.socialnetwork.security;

import com.mesiproject.socialnetwork.model.Role;
import com.mesiproject.socialnetwork.model.User;
import com.mesiproject.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.trim().isEmpty()){
            throw new UsernameNotFoundException("le nom d'utilisateur est vide");
        }
        User user = userService.findByUsernameOrEmail(username);

        if(user==null){
            throw new UsernameNotFoundException("L'utilisateur "+ username + " n'existe pas");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Role role = user.getRole();
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return authorities;
    }
}
