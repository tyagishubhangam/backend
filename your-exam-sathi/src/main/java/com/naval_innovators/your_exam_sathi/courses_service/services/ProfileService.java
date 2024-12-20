package com.naval_innovators.your_exam_sathi.courses_service.services;

import com.naval_innovators.your_exam_sathi.auth_service.models.Profile;
import com.naval_innovators.your_exam_sathi.courses_service.dtos.ProfileCourseDTO;

public interface ProfileService {
    public ProfileCourseDTO addCoursesToProfile(Long profileId, Long courseId);
}
