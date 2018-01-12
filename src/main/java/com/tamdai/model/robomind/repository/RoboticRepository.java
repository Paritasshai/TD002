package com.tamdai.model.robomind.repository;

import com.tamdai.model.robomind.entity.Robotic;
import com.tamdai.model.robomind.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoboticRepository extends JpaRepository<Robotic, Long> {
    List<Robotic> findByNameGroupContaining(String name);
}
