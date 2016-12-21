package com.av.repositories;

import com.av.domain.Event;
import javafx.collections.FXCollections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
@Repository
@Transactional
public class EventServiceImpl implements EventService {

    @PersistenceContext
    private EntityManager emf;

    @Override
    public Event save(Event event) {
        if (event.getId() == 0) {
            emf.persist(event);
        } else {
            emf.merge(event);
        }
        return event;


    }

    @Override
    public List<Event> findAll() {
        CriteriaBuilder cb = emf.getCriteriaBuilder();
        CriteriaQuery<Event> cq = cb.createQuery(Event.class);
        Root<Event> rootEntry = cq.from(Event.class);
        CriteriaQuery<Event> all = cq.select(rootEntry);
        TypedQuery<Event> allQuery = emf.createQuery(all);
        return FXCollections.observableArrayList(allQuery.getResultList());
    }
}
