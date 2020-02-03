package org.example.spring.data.dao;


import org.example.spring.data.entities.Talk;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

//@RepositoryDefinition(domainClass = Talk.class, idClass = Long.class)
public interface TalkRepository extends Repository<Talk, Long> {

    List<Talk> findByTitleContainingIgnoreCase(String title);

    Talk save(Talk talk);

    Iterable<Talk> saveAll(Iterable<Talk> talks);

    Optional<Talk> findById(Long id);

    boolean existsById(Long id);

    Iterable<Talk> findAll();

    Iterable<Talk> findAllById(Iterable<Long> id);

    long count();

    void deleteById(Long id);

    void delete(Talk talk);

    void deleteAll(Iterable<Talk> talk);

    void deleteAll();
}
