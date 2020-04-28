package model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@ToString(exclude = {"user", "project"})
@EqualsAndHashCode(exclude = {"user", "project"})
@Entity
@Table(name = "notes")
public class Note implements Serializable {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    @Column(name = "text_field")
    private String textField;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Note(String title, String textField) {
        this.title = title;
        this.textField = textField;
    }
}
