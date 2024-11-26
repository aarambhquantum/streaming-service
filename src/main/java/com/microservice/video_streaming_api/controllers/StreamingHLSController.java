package com.microservice.video_streaming_api.controllers;


import com.microservice.video_streaming_api.services.StreamingService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/streaming/hls/")
public class StreamingHLSController {

    private final StreamingService streamingService;

    @GetMapping("master/{videoId}/master.m3u8")
    public ResponseEntity<byte[]> getMasterPlaylist(@PathVariable String videoId) {
        byte[] playlist = streamingService.getMasterPlaylist(videoId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/vnd.apple.mpegurl")
                .body(playlist);
    }
    @GetMapping("{videoId}/{quality}/{segmentName}.ts")
    public ResponseEntity<byte[]> getSegment(
            @PathVariable String videoId,
            @PathVariable String quality,
            @PathVariable String segmentName) {
        byte[] segment = streamingService.getSegment(videoId, quality, segmentName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "video/MP2T")
                .body(segment);
    }

    @GetMapping("{videoId}/{quality}/playlist.m3u8")
    public ResponseEntity<byte[]> getQualityPlaylist(
            @PathVariable String videoId,
            @PathVariable String quality) {
        byte[] playlist = streamingService.getQualityPlaylist(videoId, quality);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/vnd.apple.mpegurl")
                .body(playlist);
    }
}

