package model;

import lombok.*;
import model.enums.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@NoArgsConstructor
@ToString(exclude = {"notes", "projects", "computer"})
@EqualsAndHashCode(exclude = {"notes", "projects", "computer"})
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;

    private String name;

    private String surname;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Note> notes;

    @OneToOne(mappedBy = "user")
    private Computer computer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_projects",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "project"))
    private List<Project> projects;

    @Builder
    public User(String name, String surname, String login, String email, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
