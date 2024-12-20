package com.naval_innovators.your_exam_sathi.courses_service.dtos;

import com.naval_innovators.your_exam_sathi.auth_service.models.Course;
import com.naval_innovators.your_exam_sathi.auth_service.models.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class ProfileCourseDTO {
    private Long id;


    private String firstName;

    private String lastName;


    private String phoneNumber;


    private String avatarUrl;


    private boolean isVerified;


    private boolean isPremium;


    private Gender gender;


    private LocalDate dateOfBirth;

    private List<Course> courses;
}
