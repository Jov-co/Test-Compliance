package com.fincomp.Dev_FinComp.Respositories;

import com.fincomp.Dev_FinComp.Entities.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRespository extends JpaRepository<DocumentType, Integer> {
}
