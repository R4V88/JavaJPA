package model;

import lombok.*;
import model.enums.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String surname;

    @Column(unique = true)
    private String login;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Note> notes;

    @OneToMany (mappedBy = "user")
    private List<Project> projects;

    public User(String name, String surname, String login, String email, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
