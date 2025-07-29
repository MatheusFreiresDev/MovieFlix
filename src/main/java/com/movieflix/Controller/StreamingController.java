package com.movieflix.Controller;

import com.movieflix.Controller.Request.StreamingRequest;
import com.movieflix.Controller.Response.StreamingResponse;
import com.movieflix.Entity.Streaming;
import com.movieflix.Mapper.StreamingMapper;
import com.movieflix.Service.StreamingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streaming")
@RequiredArgsConstructor
public class StreamingController {

    @Autowired
    private StreamingService streamingService;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> listStreamings() {
        List<Streaming> streamings = streamingService.listStreaming();
        return ResponseEntity.ok(
                streamings.stream()
                        .map(StreamingMapper::toStreamingResponse)
                        .toList()
        );
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> createStreaming(@Valid @RequestBody StreamingRequest streamingRequest) {
        Streaming streaming = streamingService.create(StreamingMapper.toStreaming(streamingRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(streaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getStreamingById(@PathVariable Long id) {
        Streaming streaming = streamingService.streaming(id);
        if (streaming != null) {
            return ResponseEntity.status(HttpStatus.OK).body(StreamingMapper.toStreamingResponse(streaming));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStreaming(@PathVariable Long id) {
        streamingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
