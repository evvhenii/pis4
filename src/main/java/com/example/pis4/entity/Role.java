package com.example.pis4.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    Long id;

    @Column(name = "role_enum")
    @Enumerated(EnumType.STRING)
    RoleEnum roleEnum;
}
