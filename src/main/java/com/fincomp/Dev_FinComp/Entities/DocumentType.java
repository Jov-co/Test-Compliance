package com.fincomp.Dev_FinComp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @Entity @Table(name = "document_types")
public class DocumentType {

    @Id
    @Column(name = "id_doc_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocType;

    @Column(name = "doc_type", nullable = false)
    private String docTypeName;

}
