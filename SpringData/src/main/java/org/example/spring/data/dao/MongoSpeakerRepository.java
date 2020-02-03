package org.example.spring.data.dao;

import org.example.spring.data.entities.Speaker;
import org.example.spring.data.entities.Talk;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface MongoSpeakerRepository extends MongoRepository<Speaker, Long> {

    Speaker findByName(String name);

    List<Speaker> findByTalksTitleLikeIgnoreCase(String partOfTalkTitle);

    List<Speaker> findByTalksDateTimeBetween(LocalDateTime from, LocalDateTime to);

    @Query(fields = "{talks.title:1}")
    List<Speaker> findTalksByTalksDateTimeBetween(LocalDateTime from, LocalDateTime to);

    default List<Talk> findTalkBetween(LocalDateTime from, LocalDateTime to) {
        List<Speaker> speakers = findByTalksDateTimeBetween(from, to);
        return speakers.stream()
                .map(Speaker::getTalks)
                .flatMap(Collection::stream)
                .filter(talk -> isBetween(from, to, talk))
                .collect(Collectors.toList());
    }

    default boolean isBetween(LocalDateTime from, LocalDateTime to, Talk talk){
        return talk.getDateTime().isAfter(from) && talk.getDateTime().isBefore(to);
    }
}
