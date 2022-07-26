package com.doctorsarl.doctorsarl.auth;

import com.doctorsarl.doctorsarl.entities.Personne;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private Personne personne;

    public UserDetails(Personne personne){
        this.personne = personne;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

//        extract list of permission (name)
        this.personne.getPermissionList().forEach(p ->{
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorities.add(authority);
        });

        //        extract list of roles (ROLE_name)
        this.personne.getRoleList().forEach(r ->{
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
            authorities.add(authority);
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return personne.getPassword();
    }

    @Override
    public String getUsername() {
        return personne.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName(){
        return personne.getNom() + " " + personne.getPrenom();
    }
}
