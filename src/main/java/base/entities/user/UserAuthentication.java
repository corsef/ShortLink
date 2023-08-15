package base.entities.user;
/*
import base.core.constants.Roles;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor


public class UserAuthentication implements UserDetails {

    private UserInfo userInfo = new UserInfo();

    public boolean loadByEmail (String email,String password ) throws UsernameNotFoundException {
        email = this.getUsername();
        password = this.getPassword();
        if(userInfo.getEmail() == email){
            if(userInfo.getPassword() == password){
            return true;
            }
        }
        throw new UsernameNotFoundException("Giremen Guzum");
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}*/
