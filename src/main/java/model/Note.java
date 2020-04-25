package model;

import lombok.AllArgsConstructor;
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
    private Integer id;

    private String title;

    @Column(name = "text_field")
    private String textField;

    @ManyToOne
    private User user;

    @ManyToOne
    private Project project;

    public Note(String title, String textField) {
        this.title = title;
        this.textField = textField;
    }
}
