package org.example.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String language;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {
        user.setProfile(this);
        this.user = user;
    }
}
