package com.astrodust.instaclone.entity;

import com.astrodust.instaclone.enums.RoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Setter
@Getter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column
    private RoleEnum name;

    public Role(RoleEnum roleEnum){
        this.name = roleEnum;
    }
}