package org.example.spring.data.dao;

import org.example.spring.data.BaseTest;
import org.example.spring.data.entities.Talk;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Transactional
public class TalkRepositoryTest extends BaseTest {

    @Autowired
    private TalkRepository talkRepository;

    @Before
    @Rollback(false)
    public void setUp() {
        Talk springBoot = new Talk(LocalDateTime.of(2019, 7, 15, 19, 0), "SpringBoot the good parts");
        Talk springFramework = new Talk(LocalDateTime.of(2019, 7, 15, 19, 0), "Spring Framework in depth");
        Talk java9 = new Talk(LocalDateTime.of(2019, 7, 15, 20, 0), "Java 9 modules");
        Talk java11 = new Talk(LocalDateTime.of(2019, 7, 15, 18, 0), "Java 11 new features");
        talkRepository.saveAll(Arrays.asList(springBoot, springFramework, java9, java11));
    }

    @Test
    public void testFindByName() {
        System.out.println("----- All Spring Talks -----");
        List<Talk> talkList = talkRepository.findByTitleContainingIgnoreCase("spRinG");
        talkList.forEach(System.out::println);
        assertEquals(2, talkList.size());
        System.out.println("---------------------------------------");
    }

    @After
    public void clean() {
        talkRepository.deleteAll();
    }
}
