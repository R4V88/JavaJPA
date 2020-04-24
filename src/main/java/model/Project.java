package model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "projects")
public class Project implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String description;

    @OneToMany(mappedBy = "project")
    private List<Note> notes;


    //TODO
    //add a private Project field in Note.
}
