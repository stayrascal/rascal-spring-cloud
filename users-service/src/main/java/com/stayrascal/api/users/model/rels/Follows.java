package com.stayrascal.api.users.model.rels;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.stayrascal.api.users.model.nodes.User;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "FOLLOWS")
public class Follows {

    @GraphId
    private Long id;

    @StartNode
    private User follower;

    @EndNode
    private User follows;

    public Follows() {
    }

    public Long getId() {
        return id;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollows() {
        return follows;
    }

    public void setFollows(User follows) {
        this.follows = follows;
    }
}
