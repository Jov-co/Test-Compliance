package com.fincomp.Dev_FinComp.Respositories;

import com.fincomp.Dev_FinComp.Entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRespository extends JpaRepository<Plan, Integer> {
}
