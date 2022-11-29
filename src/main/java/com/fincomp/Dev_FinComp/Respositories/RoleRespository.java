package com.fincomp.Dev_FinComp.Respositories;

import com.fincomp.Dev_FinComp.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRespository extends JpaRepository<Role, Integer> {
}
