package org.example.spring.data.dao;

import org.example.spring.data.entities.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaSpeakerRepository extends JpaRepository<Speaker, Long> {

    List<Speaker> findByName(String name);

    List<Speaker> findByNameContainingIgnoreCase(String name);

}
