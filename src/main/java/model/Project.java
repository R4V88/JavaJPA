package model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
@ToString(exclude = {"notes", "users"})
@EqualsAndHashCode(exclude = {"notes", "users"})
@Entity
@Table(name = "projects")
public class Project implements Serializable {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    @Column()
    private String description;

    @Setter
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Note> notes;

    @Setter
    @ManyToMany
    private List<User> users;

    public Project(String title, String description){
        this.title = title;
        this.description = description;
    }
}
