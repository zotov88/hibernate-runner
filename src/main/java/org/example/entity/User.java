package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;

    private String firstname;

    private String lastname;

//    @Convert(converter = BirthDayConverter.class)
    @Column(name = "birth_date")
    private BirthDate birthDate;

    @Enumerated(EnumType.STRING)
    private Role role;
}