package model;

import lombok.*;
import model.enums.Drive;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@ToString(exclude = "user")
@EqualsAndHashCode(exclude = "user")
@Entity
@Table(name = "computers")
public class Computer {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private long id;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String processor;

    @Column(nullable = false)
    private String ram;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Drive drive;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Computer(String manufacturer, String processor, String ram, Drive drive) {
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ram = ram;
        this.drive = drive;
    }
}
