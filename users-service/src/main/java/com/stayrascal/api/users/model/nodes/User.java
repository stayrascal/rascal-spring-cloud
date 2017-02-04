package com.stayrascal.api.users.model.nodes;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.stayrascal.api.users.model.rels.Action;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity
public class User {

    @GraphId
    private Long id;

    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    private Long birthDate;

    @Relationship(type = "FOLLOWS", direction = Relationship.OUTGOING)
    private Set<User> follows;

    @Relationship(type = "FOLLOWS", direction = Relationship.INCOMING)
    private Set<User> followers;

    @Relationship(type = "ACTION", direction = Relationship.OUTGOING)
    private Set<Action> actions;

    @Relationship(type = "ACTION", direction = Relationship.OUTGOING)
    private Set<Event> events;


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<User> getFollows() {
        return follows;
    }

    public void setFollows(Set<User> follows) {
        this.follows = follows;
    }
}
