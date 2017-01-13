package com.av.data.services;

import com.av.domain.Event;

import java.util.List;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
public interface EventService {

    Event save(Event event);

    List<Event> findAll();

}
