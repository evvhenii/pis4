package com.example.pis4.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cashier {
    @Id
    @GeneratedValue
    Long id;
    String name;
    Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    Role role;

    String password;
}
