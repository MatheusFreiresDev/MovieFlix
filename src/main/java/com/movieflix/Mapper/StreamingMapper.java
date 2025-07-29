package com.movieflix.Mapper;
import com.movieflix.Controller.Request.StreamingRequest;
import com.movieflix.Controller.Response.StreamingResponse;
import com.movieflix.Entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {
    public static Streaming toStreaming(StreamingRequest streamingRequest) {
        return Streaming.builder()
                .name(streamingRequest.name())
                .build();
    }
    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse.builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }

}
