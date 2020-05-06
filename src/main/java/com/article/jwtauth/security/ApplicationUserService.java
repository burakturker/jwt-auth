package com.article.jwtauth.security;

import com.article.jwtauth.privilege.Privilege;
import com.article.jwtauth.privilege.PrivilegeService;
import com.article.jwtauth.role.Role;
import com.article.jwtauth.user.User;
import com.article.jwtauth.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final UserService userService;
    private final PrivilegeService privilegeService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        final User user = userService.findByUserName(userName);
        final Role role = user.getRole();

        final List<Privilege> privileges = privilegeService.getPrivilegesByRoleId(role.getId());

        return new ApplicationUser(user, privileges);
    }
}
