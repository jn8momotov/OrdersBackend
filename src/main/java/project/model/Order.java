package project.model;

import project.model.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private LocalDate birthDay;
    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(columnDefinition = "TEXT")
    private String comment;

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public Order setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Order setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Order setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
