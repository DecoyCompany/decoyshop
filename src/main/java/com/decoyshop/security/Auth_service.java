package com.decoyshop.security;

import com.decoyshop.entities.Kullanici;
import com.decoyshop.repositories.Kullanici_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Auth_service implements UserDetailsService
{
    @Autowired
    private Kullanici_repo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        Kullanici kullanici = repo.findByemail(email);

        if (kullanici == null) {
            throw new UsernameNotFoundException("User with email " + email + " not found");
        }

        return new org.springframework.security.core.userdetails.User(
                kullanici.getEmail(),
                kullanici.getSifre(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}
