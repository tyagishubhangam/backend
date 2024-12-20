package com.naval_innovators.your_exam_sathi.courses_service.mappers;

import com.naval_innovators.your_exam_sathi.auth_service.models.Profile;
import com.naval_innovators.your_exam_sathi.courses_service.dtos.ProfileCourseDTO;

public class ProfileCourseMapper {

    public ProfileCourseDTO mapToProfileCourseDTO(Profile profile){
        ProfileCourseDTO profileCourseDTO = new ProfileCourseDTO();
        profileCourseDTO.setId(profile.getId());
        profileCourseDTO.setFirstName(profile.getFirstName());
        profileCourseDTO.setLastName(profile.getLastName());
        profileCourseDTO.setGender(profile.getGender());
        profileCourseDTO.setPremium(profile.isPremium());
        profileCourseDTO.setAvatarUrl(profile.getAvatarUrl());
        profileCourseDTO.setPhoneNumber(profile.getPhoneNumber());
        profileCourseDTO.setDateOfBirth(profile.getDateOfBirth());
        profileCourseDTO.setVerified(profile.isVerified());
        profileCourseDTO.setCourses(profile.getCourses().stream().toList());

        return profileCourseDTO;

    }
}
