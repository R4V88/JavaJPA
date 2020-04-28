package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.enums.Drive;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "computers")
public class Computer implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String manufacturer;
    private String processor;
    private String ram;

    @Enumerated(EnumType.STRING)
    private Drive drive;

    @OneToOne(mappedBy = "computer")
    private User user;

    public Computer (String manufacturer, String processor, String ram){
        this.manufacturer = manufacturer;
        this.processor = processor;
        this. ram = ram;
    }
}
