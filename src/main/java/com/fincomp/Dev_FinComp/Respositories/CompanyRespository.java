package com.fincomp.Dev_FinComp.Respositories;

import com.fincomp.Dev_FinComp.Entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRespository extends JpaRepository<Company, String> {
}
