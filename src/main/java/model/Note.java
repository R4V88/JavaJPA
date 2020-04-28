package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "notes")
public class Note implements Serializable {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(name = "text_field")
    private String textField;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    private Project project;

    public Note(String title, String textField) {
        this.title = title;
        this.textField = textField;
    }
}
