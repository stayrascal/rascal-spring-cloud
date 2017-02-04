package com.stayrascal.api.users.model.rels;

import com.stayrascal.api.users.model.nodes.Event;
import com.stayrascal.api.users.model.nodes.User;

public class Action {

    private Long id;

    private User actor;

    private Event event;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getActor() {
        return actor;
    }

    public void setActor(User actor) {
        this.actor = actor;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
