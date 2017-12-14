package com.tamdai.model.robomind.repository;

import com.tamdai.model.robomind.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobomindRepository extends JpaRepository<StudentProfile, Long> {
    StudentProfile findByStId(String stId);
    StudentProfile findByStFirstnameAndStDateContainingAllIgnoreCase(String username, String date);
}
