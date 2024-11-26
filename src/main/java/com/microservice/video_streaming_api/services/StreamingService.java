package com.microservice.video_streaming_api.services;

import org.springframework.web.bind.annotation.RequestParam;

public interface StreamingService {
    byte[] getMasterPlaylist(String videoId);
    byte[] getQualityPlaylist(String videoId, String quality);
    byte[] getSegment(String videoId, String quality, String segmentName);
}
