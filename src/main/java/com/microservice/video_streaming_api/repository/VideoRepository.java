package com.microservice.video_streaming_api.repository;

import com.microservice.video_streaming_api.models.entities.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, String> {
}
