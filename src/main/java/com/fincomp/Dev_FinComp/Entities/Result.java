package com.fincomp.Dev_FinComp.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "results")

public class Result implements Serializable {

    @Id
    @Column(name = "id_result")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResult;

    @ManyToOne(targetEntity = Consult.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_consult", referencedColumnName = "id_consult")
    private Consult consult;

    @Column(name = "page")
    private String page;

    @Column(name = "page_name")
    private String pageName;

    @Column(name = "status_search")
    private String statusSearch;

    @Column(name = "identification_number_search")
    private String identificationNumberSearch;

    @Column(name = "name")
    private String name;

    @Column(name = "entity_type")
    private String entityType;

    @Column(name = "programs")
    private String programs;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state_province")
    private String stateProvince;

    @Column(name = "country")
    private String country;
    

}
