package com.naval_innovators.your_exam_sathi.courses_service;

import com.naval_innovators.your_exam_sathi.auth_service.models.Course;
import com.naval_innovators.your_exam_sathi.auth_service.models.Profile;
import com.naval_innovators.your_exam_sathi.courses_service.dtos.ProfileCourseDTO;
import com.naval_innovators.your_exam_sathi.courses_service.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/myapi/user/{profileId}")
@RequiredArgsConstructor
public class CoursesController {
   private final ProfileService profileService;

    @PostMapping("/enroll/{courseId}")
    public ResponseEntity<ProfileCourseDTO> enrollCourse(@PathVariable Long profileId, @PathVariable Long courseId) {
        ProfileCourseDTO profile = profileService.addCoursesToProfile(profileId,courseId);

        if (profile == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {

            return new ResponseEntity<>(profile, HttpStatus.CREATED);
        }


    }
    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        return ResponseEntity.ok("Hello World");
    }
}
