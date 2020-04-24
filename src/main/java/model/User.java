package model;

import lombok.*;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.io.Serializable;


@Builder
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
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

    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Note> notes;

}
