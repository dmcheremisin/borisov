package org.example.spring.data.dao;

import org.example.spring.data.entities.Speaker;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SpeakerRepositoryOldSchool {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Speaker> findByName(String name) {
        Query query = entityManager.createQuery("select s from Speaker as s where s.name=:name");
        return query.setParameter("name", name).getResultList();
    }

    public List<Speaker> getAllSpeaker() {
        return entityManager.createQuery("from Speaker").getResultList();
    }

    public void save(List<Speaker> speakers) {
        speakers.forEach(entityManager::persist);
    }

    public long count() {
        return (long) entityManager.createQuery("select count(s.name) from Speaker s").getSingleResult();
    }

    public void deleteAll() {
        entityManager.createQuery("delete from Speaker").executeUpdate();
    }
}
