package com.fincomp.Dev_FinComp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plans")
public class Plan implements Serializable {

    @Id
    @Column(name = "id_plan")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlan;

    @Column(name = "plan_name", nullable = false)
    private String planName;

    @Column(name = "plan_price", nullable = false)
    private Double planPrice;

    @Column(name = "plan_description")
    private String planDescription;

/*    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plan")
    private List<Company> company;*/

}
