package com.franc.domain.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=50, unique=true)
    private String email;

    @Column(nullable=false, length=50)
    private String name;

    @Column(nullable=false, unique=true)
    @Setter
    private String userId;

    @Column(nullable=false)
    @Setter
    private String pwd;
}
