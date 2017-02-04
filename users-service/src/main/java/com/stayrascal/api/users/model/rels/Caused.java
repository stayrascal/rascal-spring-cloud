package com.stayrascal.api.users.model.rels;

import com.stayrascal.api.users.model.nodes.Event;
import com.stayrascal.api.users.model.nodes.User;

public class Caused {
    private Long id;
    private User user;
    private Event event;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
