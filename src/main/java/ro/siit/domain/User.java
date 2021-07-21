package ro.siit.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(
        name = "unique_email", columnNames = {"email"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column
    @GeneratedValue
    private Long id;


    @Column
    private String email;

    @Column(length = 64)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;
}

