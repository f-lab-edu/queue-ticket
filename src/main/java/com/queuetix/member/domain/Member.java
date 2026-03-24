package com.queuetix.member.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String loginId;
    @Column
    private String password;
    @Column
    private String name;
    @Column(unique = true)
    private String email;
    @Column
    private String phone;
    @Column
    private String address;
}
