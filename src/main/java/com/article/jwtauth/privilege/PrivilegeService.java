package com.article.jwtauth.privilege;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrivilegeService {

    private final PrivilegeRepository privilegeRepository;

    public List<Privilege> getPrivilegesByRoleId(Long roleId) {

        return privilegeRepository.findPrivilegesByRoleId(roleId);
    }
}
