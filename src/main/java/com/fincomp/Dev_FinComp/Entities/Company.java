package com.fincomp.Dev_FinComp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companys")
public class Company implements Serializable {

    @Id
    @Column(name = "id_company")
    private String idCompany;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @ManyToOne(targetEntity = Plan.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_plan", nullable = false, referencedColumnName = "id_plan")
    private Plan plan;

}
