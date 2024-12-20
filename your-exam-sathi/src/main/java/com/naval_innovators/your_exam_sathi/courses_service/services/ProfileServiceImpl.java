package com.naval_innovators.your_exam_sathi.courses_service.services;

import com.naval_innovators.your_exam_sathi.auth_service.models.Course;
import com.naval_innovators.your_exam_sathi.auth_service.models.Profile;
import com.naval_innovators.your_exam_sathi.auth_service.repository.CourseRepository;
import com.naval_innovators.your_exam_sathi.auth_service.repository.ProfileRepository;
import com.naval_innovators.your_exam_sathi.courses_service.dtos.ProfileCourseDTO;
import com.naval_innovators.your_exam_sathi.courses_service.mappers.ProfileCourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final CourseRepository courseRepository;
    private final ProfileRepository profileRepository;
    @Override
    public ProfileCourseDTO addCoursesToProfile(Long profileId, Long courseId) {
       Optional<Profile> user = profileRepository.findById(profileId);
       Optional<Course> course = courseRepository.findById(courseId);
        ProfileCourseMapper profileCourseMapper = new ProfileCourseMapper();
       if (user.isPresent() && course.isPresent()) {
           Profile profile = user.get();
           profile.getCourses().add(course.get());
           profileRepository.save(profile);
           return profileCourseMapper.mapToProfileCourseDTO(profile);
       }else{
           throw new UsernameNotFoundException("User not found");
       }



//        return null;
    }
}
