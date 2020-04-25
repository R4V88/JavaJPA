package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String title;

    private String description;

    @OneToMany(mappedBy = "project")
    private List<Note> notes;

    @ManyToOne
    private User user;

    public Project(String title, String description){
        this.title = title;
        this.description = description;
    }
}
