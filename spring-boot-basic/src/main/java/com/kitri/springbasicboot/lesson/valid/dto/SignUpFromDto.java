package com.kitri.springbasicboot.lesson.valid.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
public class SignUpFromDto {
    @NotEmpty
    String name;
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$")
    String email;
    @Size(min = 8)
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z]).{8,}")
    String password;
    @Past
    LocalDate date;
    @NotEmpty
    String gender;
}
