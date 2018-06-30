package cn.lunatic.springboot.security.facade.model;

import cn.lunatic.springboot.security.persistence.auto.model.RoleInfo;
import cn.lunatic.springboot.security.persistence.auto.model.UserInfo;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 认证用户信息Model
 *
 * @see UserDetails
 */
@Data
public class LoginUser extends UserInfo implements UserDetails {
    private List<RoleInfo> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<RoleInfo> roles = getRoles();

        roles.forEach(role -> {
            auths.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return auths;
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


}
