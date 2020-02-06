package project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import project.model.enums.Gender;
import project.util.validation.Validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDate;


public class OrderDTO {
    @Null(groups = {Validation.New.class})
    @NotNull(groups = {Validation.Exist.class})
    private Long id;
    @NotNull(groups = {Validation.New.class, Validation.Exist.class})
    private String name;
    @ApiModelProperty(example = "01.01.1986")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate birthDay;
    private Gender gender;
    @Size(max = 2048)
    private String comment;

    public Long getId() {
        return id;
    }

    public OrderDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public OrderDTO setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public OrderDTO setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public OrderDTO setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
