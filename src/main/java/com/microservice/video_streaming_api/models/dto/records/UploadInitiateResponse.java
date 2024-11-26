package com.microservice.video_streaming_api.models.dto.records;

import java.time.Instant;

public record UploadInitiateResponse(String filename, String uploadId, Instant expiryDate) {
}
