package org.example.spring.data.dao;

import org.example.spring.data.BaseTest;
import org.example.spring.data.entities.Speaker;
import org.example.spring.data.entities.Talk;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MongoSpeakerRepositoryTest extends BaseTest {

    @Autowired
    private MongoSpeakerRepository mongoSpeakerRepository;

    @Before
    @Rollback(false)
    public void setUp() {
        Speaker dmitriiCheremisin = new Speaker("Dmitrii Cheremisin");
        Speaker markCheremisin = new Speaker("Mark Cheremisin");

        dmitriiCheremisin.addTalk(new Talk(LocalDateTime.of(2020, 7, 15, 19, 0),"SpringBoot the good parts"));
        dmitriiCheremisin.addTalk(new Talk(LocalDateTime.of(2018, 7, 15, 20, 0), "Java 9 modules"));
        markCheremisin.addTalk(new Talk(LocalDateTime.of(2021, 7, 15, 18, 0), "Java 11 new features"));

        mongoSpeakerRepository.saveAll(Arrays.asList(dmitriiCheremisin, markCheremisin));
    }

    @Test
    public void testCount() {
        System.out.println("----- Number of speakers TEST -----");
        System.out.println("Speakers count: " + mongoSpeakerRepository.count());
        System.out.println("-----------------------------------");
    }

    @Test
    public void testFindAll() {
        System.out.println("----- All speakers ------");
        List<Speaker> allSpeaker = mongoSpeakerRepository.findAll();
        allSpeaker.forEach(speaker -> System.out.println(speaker.getName()));
        System.out.println("-------------------------");
    }

    @Test
    public void testFindByName() {
        System.out.println("----- All talks of Dmitrii Cheremisin -----");
        Speaker speaker = mongoSpeakerRepository.findByName("Dmitrii Cheremisin").get(0);
        speaker.getTalks().forEach(talk -> System.out.println(talk.toString()));
        assertEquals(2, speaker.getTalks().size());
        System.out.println("---------------------------------------");
    }

    @Test
    public void testFindByNameLike() {
        System.out.println("----- All talks of Dmitrii Cheremisin -----");
        List<Speaker> speakers = mongoSpeakerRepository.findByNameContainingIgnoreCase("cheremisin");
        speakers.forEach(System.out::println);
        assertEquals(2, speakers.size());
        System.out.println("---------------------------------------");
    }

    @After
    public void clean() {
        mongoSpeakerRepository.deleteAll();
    }
}
