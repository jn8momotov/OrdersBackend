package project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import project.model.enums.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderSearchForm {
    private String query;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate birthDayStart;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate birthDayEnd;
    private Gender gender;

    public String getQuery() {
        return query;
    }

    public OrderSearchForm setQuery(String query) {
        this.query = query;
        return this;
    }

    public LocalDate getBirthDayStart() {
        return birthDayStart;
    }

    public OrderSearchForm setBirthDayStart(LocalDate birthDayStart) {
        this.birthDayStart = birthDayStart;
        return this;
    }

    public LocalDate getBirthDayEnd() {
        return birthDayEnd;
    }

    public OrderSearchForm setBirthDayEnd(LocalDate birthDayEnd) {
        this.birthDayEnd = birthDayEnd;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public OrderSearchForm setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}
