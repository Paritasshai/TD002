package com.tamdai.model.video.repository;

import com.tamdai.model.video.entity.VideoClip;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Film on 15/10/2559.
 */
public interface VideoClipRepository extends JpaRepository<VideoClip, Long> {

}
