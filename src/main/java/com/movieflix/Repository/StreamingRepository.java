package com.movieflix.Repository;

import com.movieflix.Entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.StreamSupport;
@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
