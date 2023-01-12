package com.fincomp.Dev_FinComp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "consults")

public class Consult implements Serializable {

    @Id
    @Column(name = "id_consult")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsult;

    @Column(name = "consultation_date")
    private LocalDateTime consultationDate;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identification_number")
    private String identificationNumber;

    @ManyToOne(targetEntity = DocumentType.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_doc_type", referencedColumnName = "id_doc_type")
    private DocumentType documentType;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

}
