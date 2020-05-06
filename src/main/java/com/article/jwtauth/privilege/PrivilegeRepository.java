package com.article.jwtauth.privilege;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    List<Privilege> findPrivilegesByRoleId(Long roleId);
}
