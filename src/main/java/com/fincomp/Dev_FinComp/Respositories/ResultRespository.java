package com.fincomp.Dev_FinComp.Respositories;

import com.fincomp.Dev_FinComp.Entities.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRespository extends JpaRepository<Result, Integer> {
}
