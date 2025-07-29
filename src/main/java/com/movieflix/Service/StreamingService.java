package com.movieflix.Service;

import com.movieflix.Entity.Category;
import com.movieflix.Entity.Streaming;
import com.movieflix.Repository.CategoryRepository;
import com.movieflix.Repository.StreamingRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Builder
@Service
public class StreamingService {
        @Autowired
        StreamingRepository streamingRepository;

        public List<Streaming> listStreaming() {
            return streamingRepository.findAll();
        }
        public Streaming create(Streaming streaming) {
            return streamingRepository.save(streaming);
        }

        public Streaming streaming(Long id) {
            return streamingRepository.findById(id).orElse(null);
        }

        public void delete(Long id) {
            streamingRepository.deleteById(id);
        }


}
