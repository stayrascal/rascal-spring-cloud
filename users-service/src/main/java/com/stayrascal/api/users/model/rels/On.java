package com.stayrascal.api.users.model.rels;

import com.stayrascal.api.users.model.nodes.Content;
import com.stayrascal.api.users.model.nodes.Event;

public class On {
    private Long id;
    private Event event;
    private Content content;

    public On() {
    }

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
