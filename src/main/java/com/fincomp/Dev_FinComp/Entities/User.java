package com.fincomp.Dev_FinComp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_phone", nullable = false)
    private String phoneNumber;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @ManyToOne(targetEntity = Company.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_company", referencedColumnName = "id_company", nullable = false)
    private Company company;

    @ManyToOne(targetEntity = Role.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)
    private Role role;
}
