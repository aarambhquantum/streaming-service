package com.microservice.video_streaming_api.services_impl;

import com.microservice.video_streaming_api.services.StreamingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;


import static com.microservice.video_streaming_api.configurations.constants.ApplicationConstants.folderName;
import static com.microservice.video_streaming_api.configurations.constants.ApplicationConstants.s3BucketName;

@RequiredArgsConstructor
@Service
@Log4j2
public class StreamingServiceImpl implements StreamingService {
    private final S3Client s3Client;

    @Override
    public byte[] getMasterPlaylist(String videoId) {
        // TODO fetch s3video id from db based on view id
        String internalVideoId = videoId;
        try {
            GetObjectRequest request = GetObjectRequest.builder()
                .bucket(s3BucketName)
                .key(String.format("%s/%s/master.m3u8", folderName, videoId))
                .build();

            return s3Client.getObjectAsBytes(request).asByteArray();
        } catch (Exception e) {
            log.error("Error fetching master playlist: ", e);
            throw new RuntimeException("Failed to fetch master playlist");
        }
    }

    @Override
    public byte[] getQualityPlaylist(String videoId, String quality) {
        // TODO fetch s3video id from db based on view id
        String internalVideoId = videoId;
        try {
            GetObjectRequest request = GetObjectRequest.builder()
                .bucket(s3BucketName)
                .key(String.format("%s/%s/%s/playlist.m3u8", folderName, videoId, quality))
                .build();

            return s3Client.getObjectAsBytes(request).asByteArray();
        } catch (Exception e) {
            log.error("Error fetching quality playlist: ", e);
            throw new RuntimeException("Failed to fetch quality playlist");
        }
    }

    @Override
    public byte[] getSegment(String videoId, String quality, String segmentName) {
        // TODO fetch s3video id from db based on view id
        String internalVideoId = videoId;
        try {
            GetObjectRequest request = GetObjectRequest.builder()
                .bucket(s3BucketName)
                .key(String.format("%s/%s/%s/%s.ts", folderName, videoId, quality, segmentName))
                .build();

            return s3Client.getObjectAsBytes(request).asByteArray();
        } catch (Exception e) {
            log.error("Error fetching segment: ", e);
            throw new RuntimeException("Failed to fetch segment");
        }
    }
}
